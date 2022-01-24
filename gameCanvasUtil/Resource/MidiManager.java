package gameCanvasUtil.Resource;

import java.io.*;

import javax.sound.midi.*;

/**
 * MIDI���Ǘ����A�Đ��Ȃǂ��s��
 *
 */
public class MidiManager implements SoundManagerInterface
{
    // ���\�[�X��(�z��̗v�f��)
    private int resourceNum;

    // ����炷�V�[�P���T�[
    private Sequencer sequencer[] = null;
    private Synthesizer synthesizer = null;

    // �����ƂɃ��[�v���邩�̃t���O
    private boolean loopFlag[] = null;

    // �����Ƃ̉���
    private int volume[] = null;

    // MIDI�̎d�l�ŁA�T�E���h���ʕύX����
    private static final int CHANGE_VOLUME = 7;

    // �V���O���g���C���X�^���X
    private static MidiManager instance = null;

    // �v���C�x�[�g�R���X�g���N�^
    private void MidiManager()
    {
        resourceNum = 0;
    }

    /**
     * @return �I�u�W�F�N�g��Ԃ�
     */
    public static MidiManager getInstance()
    {
        if (instance == null)
            instance = new MidiManager();
        return instance;
    }

    /**
     * �������B���\�[�X���܂Ƃ߂ă��[�h����
     * @param base_file_path �ǂݍ��ޘA�ԃt�@�C�����̎w��(xxx0.mid�́Axxx�̕���)
     */
    public void init(String base_file_path)
    {
        this.loadNumberingMidi(base_file_path);
        initSynthesizer();
    }

    /**
     * �A�Ԃ�MIDI�t�@�C�������[�h����
     *
     * @param base_file_path �ǂݍ��ޘA�ԃt�@�C�����̎w��(xxx0.mid�́Axxx�̕���)
     */
    private void loadNumberingMidi(String base_file_path)
    {
        String type_list[] = { ".mid" };
        resourceNum = ResourceUtil.getResourceLastID(base_file_path, type_list);
        if(resourceNum <= 0) return;

        sequencer = new Sequencer[resourceNum];
        loopFlag = new boolean[resourceNum];
        volume = new int[resourceNum];

        for (int i = 0; i < resourceNum; i++)
        {
            this.sequencer[i] = loadMidi(base_file_path + i + ".mid");
            if (this.sequencer[i] == null)
                break;
        }
    }

    /**
     * �t�@�C��������MIDI�����[�h����
     *
     * @param file_name �t�@�C����
     * @return �ǂݍ���MIDI�I�u�W�F�N�g��Ԃ�
     */
    private Sequencer loadMidi(String file_name)
    {
        Sequencer tmp;
        try
        {
            tmp = MidiSystem.getSequencer();
            tmp.open();
            InputStream is = null;
            is = this.getClass().getResourceAsStream("/" + file_name);
            Sequence s = MidiSystem.getSequence(is);
            tmp.setSequence(s);
            is.close();
            return tmp;
        }
        catch (Exception e)
        {
            System.out.println("loadMidi Exception " + file_name + " " + e);
            return null;
        }
    }

    /**
     * MIDI���Đ�����
     *
     * @param id MIDI��ID���w��
     * @param flag ���[�v���s�������Z�b�g�B�s���Ȃ�true�B
     */
    public void playSound(int id, boolean flag)
    {
        try
        {
            this.loopFlag[id] = flag;
            sequencer[id].start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * MIDI���ꎞ��~����
     *
     * @param id ��~������MIDI���w�肷��
     */
    public void pauseSound(int id)
    {
        try
        {
            this.sequencer[id].stop();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * MIDI���~������
     *
     * @param id ��~������MIDI���w�肷��
     */
    public void stopSound(int id)
    {
        try
        {
            this.sequencer[id].stop();
            this.sequencer[id].setTickPosition(0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * MIDI�̉��ʂ��Z�b�g
     *
     * @param id MIDI��ID�w��
     * @param vol ���ʂ��w��(0-100)
     */
    public void changeVolume(int id, int vol)
    {
        try
        {
            if (vol < 0)
            {
                vol = 0;
            }
            else if (vol > 100)
            {
                vol = 100;
            }
            volume[id] = (vol * 127) / 100;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * MIDI�̉��ʂ��Z�b�g
     *
     * @param id MIDI��ID�w��
     * @param vol ���ʂ��w��(0-100)
     */
    private void setVolume(int id, int vol)
    {
        int midiVolume = vol;
        try
        {
            if (synthesizer.getDefaultSoundbank() == null)
            {
                // HARDWARE SYNTHESIZER
                try
                {
                    ShortMessage volumeMessage = new ShortMessage();
                    for (int i = 0; i < 16; i++)
                    {
                        volumeMessage.setMessage(ShortMessage.CONTROL_CHANGE,
                                i, CHANGE_VOLUME, midiVolume);
                        MidiSystem.getReceiver().send(volumeMessage, -1);
                    }
                }
                catch (InvalidMidiDataException imde)
                {
                    System.err.println("Invalid MIDI data.");
                    return;
                }
                catch (MidiUnavailableException mue)
                {
                    System.err.println("MIDI unavailable.");
                    return;
                }
            }
            else
            {
                // SOFTWARE SYNTHESIZER:
                MidiChannel[] channels = synthesizer.getChannels();
                for (int c = 0; channels != null && c < channels.length; c++)
                {
                    channels[c].controlChange(CHANGE_VOLUME, midiVolume);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * �T�E���h�̍X�V����
     */
    public void update()
    {
        for (int i = 0; i < resourceNum; i++)
        {
            try
            {
                setVolume(i, volume[i]);
                if (sequencer[i] != null
                        && sequencer[i].getTickLength() <= sequencer[i]
                                .getTickPosition())
                {
                    this.sequencer[i].stop();
                    this.sequencer[i].setTickPosition(0);
                    this.sequencer[i].start();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * �S�ẴT�E���h���ꎞ��~����
     */
    public void pauseSound()
    {
        for (int i = 0; i < resourceNum; i++)
        {
            pauseSound(i);
        }
    }

    /**
     * �S�ẴT�E���h���~����
     */
    public void stopSound()
    {
        for (int i = 0; i < resourceNum; i++)
        {
            stopSound(i);
        }
    }

    /**
     * �S�ẴT�E���h�̉��ʂ�ύX����
     */
    public void changeVolume(int vol)
    {
        for (int i = 0; i < resourceNum; i++)
        {
            this.changeVolume(i, vol);
        }
    }

    /**
     * �V���Z�T�C�U�[�̏�����
     */
    private void initSynthesizer()
    {
        if(resourceNum <= 0) return;

        try
        {
            if (!(sequencer[0] instanceof Synthesizer))
            {
                synthesizer = MidiSystem.getSynthesizer();
                synthesizer.open();
                if (synthesizer.getDefaultSoundbank() == null)
                {
                    // HARDWARE SYNTHESIZER
                    for (int i = 0; i < resourceNum; i++)
                    {
                        sequencer[i].getTransmitter().setReceiver(
                                MidiSystem.getReceiver());
                    }
                }
                else
                {
                    // SOFTWARE SYNTHESIZER
                    for (int i = 0; i < resourceNum; i++)
                    {
                        sequencer[i].getTransmitter().setReceiver(
                                synthesizer.getReceiver());
                    }
                }
            }
            else
            {
                synthesizer = (Synthesizer) sequencer[0];
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
