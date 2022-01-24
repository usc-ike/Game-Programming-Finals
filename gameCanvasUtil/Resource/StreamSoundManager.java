package gameCanvasUtil.Resource;

import javax.sound.sampled.*;

/**
 * �T�E���h(WAV)�̃X�g���[�~���O�Đ��s���Ă���N���X
 *
 * �����ɉ�������炷���Ƃ��\�����A���Ȃ蕉�ׂ�����
 */
public class StreamSoundManager implements SoundManagerInterface
{
    // ���\�[�X��(�z��̗v�f��)
    private int resourceNum;

    // ����ǂݍ���Stream
    private AudioInputStream audioInputStream[] = null;
    // LINE
    private SourceDataLine line[] = null;
    // �T�E���h�̃��[�v
    private boolean loopFlag[] = null;

    // ���C���o�b�t�@�[�ɑ΂��鉹������
    private int bind[] = null;

    // 1���C��������̃o�b�t�@
    private static final int EXTERNAL_BUFFER_SIZE = 12800 / 3;
    // �����Đ��ł��鐔�B���ׂ������̂�1���w��
    private static final int LINE_BUFFER_NUM = 1;

    // ���ʂ��o���Ă���
    private int volume[] = null;

    // �Đ��p�o�b�t�@
    private byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

    // �t�@�C���̃��X�g��ێ����܂��B
    private String fileNameList[] = null;

    // �V���O���g���C���X�^���X
    private static StreamSoundManager instance = null;

    // �v���C�x�[�g�R���X�g���N�^
    private void StreamSoundManager()
    {
        resourceNum = 0;
    }

    /**
     * @return �I�u�W�F�N�g��Ԃ�
     */
    public static StreamSoundManager getInstance()
    {
        if (instance == null)
            instance = new StreamSoundManager();
        return instance;
    }

    /**
     * �������B���\�[�X���܂Ƃ߂ă��[�h����
     * @param base_file_path �ǂݍ��ޘA�ԃt�@�C�����̎w��(xxx0.wav�́Axxx�̕���)
     */
    public void init(String base_file_path)
    {
        String type_list[] = { ".wav" };
        resourceNum = ResourceUtil.getResourceLastID(base_file_path, type_list);
        if(resourceNum <= 0) return;

        this.fileNameList = new String[resourceNum];

        for (int i = 0; i < resourceNum; i++)
            fileNameList[i] = base_file_path + i + ".wav";

        // �K�v�ȃI�u�W�F�N�g�𐶐�
        this.audioInputStream = new AudioInputStream[LINE_BUFFER_NUM];
        line = new SourceDataLine[LINE_BUFFER_NUM];
        this.loopFlag = new boolean[LINE_BUFFER_NUM];
        this.bind = new int[LINE_BUFFER_NUM];
        this.volume = new int[LINE_BUFFER_NUM];
        for (int i = 0; i < LINE_BUFFER_NUM; i++)
            this.bind[i] = -1;
    }

    /**
     * �T�E���h���w�肵�����C���Ƀ��[�h����
     *
     * @param line_id ���C���̎w��
     * @param snd_id �T�E���h��ID�w��
     */
    private void loadAndPlaySound(int line_id, int snd_id)
    {
        try
        {
            audioInputStream[line_id] = AudioSystem
                    .getAudioInputStream(this.getClass().getResourceAsStream(
                            "/" + fileNameList[snd_id]));

            AudioFormat audioFormat = audioInputStream[line_id].getFormat();

            // �f�[�^���C���̏��I�u�W�F�N�g�𐶐����܂�
            DataLine.Info info = new DataLine.Info(SourceDataLine.class,
                    audioFormat);
            // �w�肳�ꂽ�f�[�^���C�����Ɉ�v���郉�C�����擾���܂�
            line[line_id] = (SourceDataLine) AudioSystem.getLine(info);
            // �w�肳�ꂽ�I�[�f�B�I�`���Ń��C�����J���܂�
            line[line_id].open(audioFormat);
            // ���C���ł̃f�[�^���o�͂��\�ɂ��܂�
            line[line_id].start();
            // ���ʂ��Z�b�g���܂�
            this.changeVolume(line_id, volume[line_id]);

            this.bind[line_id] = snd_id;
        }
        catch (Exception e)
        {
            System.out.println("soundStream play Error " + e);
            e.printStackTrace();
        }

    }

    /**
     * �X�g���[�~���O�Đ��Ȃ̂Ł@���傭���傭�Ăяo���Ă��
     *
     * �Ăяo�����r�؂��ƁA�Đ����r�؂��̂ł��B
     */
    public void update()
    {
        int nBytesRead = 0;
        try
        {
            for (int i = 0; i < LINE_BUFFER_NUM; i++)
            {
                if (line[i] != null && line[i].isOpen())
                {
                    // �I�[�f�B�I�X�g���[������f�[�^��ǂݍ��݂܂�
                    nBytesRead = audioInputStream[i].read(abData, 0,
                            abData.length);
                    if (nBytesRead >= 0)
                    {
                        // �I�[�f�B�I�f�[�^���~�L�T�[�ɏ������݂܂�
                        line[i].write(abData, 0, nBytesRead);
                    }
                    else
                    {
                        if (loopFlag[i])
                        {
                            this.loadAndPlaySound(i, this.bind[i]);
                        }
                        else
                        {
                            this.stopSound(i);
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * �J���Ă��郉�C���o�b�t�@�[��ID���擾
     *
     * @return �J���Ă��郉�C���o�b�t�@�[��ID��Ԃ��B-1�̏ꍇ�S�Ďg�p����Ă��܂��B
     */
    private int getFreeLineBuf()
    {
        try
        {
            for (int i = 0; i < LINE_BUFFER_NUM; i++)
            {
                if (this.line[i] == null || (!this.line[i].isOpen()))
                    return i;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * �w�肵�������w�肵�����C������炷
     *
     * @param line_id ���C����ID
     * @param snd_id ����ID�w��
     * @param loop ���[�v���邩�ǂ������w��
     */
    private void playSound(int line_id, int snd_id, boolean loop)
    {
        try
        {
            this.loopFlag[line_id] = loop;
            if (this.line[line_id] != null && this.line[line_id].isOpen())
            {
                this.line[line_id].start();
            }
            else
            {
                this.loadAndPlaySound(line_id, snd_id);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * �w�肵������炷
     *
     * @param snd_id ����ID�w��
     * @param loop ���[�v���邩�ǂ������w��
     */
    public void playSound(int snd_id, boolean loop)
    {
        int line_id = getFreeLineBuf();
        if (line_id >= 0)
        {
            this.playSound(line_id, snd_id, loop);
        }
        else
        {
            for (int i = 0; i < this.bind.length; i++)
            {
                if (bind[i] == snd_id)
                {
                    this.playSound(i, snd_id, loop);
                }
            }
        }
    }

    /**
     * ���̃I�u�W�F�N�g���Ǘ����Ă���S�ẴT�E���h�o�b�t�@���~������
     */
    public void stopSound()
    {
        for (int i = 0; i < LINE_BUFFER_NUM; i++)
            this.stopSound(i);
    }

    /**
     * �w�肵���T�E���h�o�b�t�@�̒�~
     *
     * @param id ��ID�̎w��
     */
    public void stopSound(int id)
    {
        try
        {
            this.line[id].drain();
            this.line[id].close();
            this.line[id] = null;
            this.bind[id] = -1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * �w�肵���T�E���h�o�b�t�@���ꎞ��~
     *
     * @param id ���̎w��
     */
    public void pauseSound(int id)
    {
        try
        {
            this.line[id].stop();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * �T�E���h�o�b�t�@�̉��ʂ�ύX����
     *
     * @param id ���ʂ�ύX����T�E���h�o�b�t�@��ID
     * @param param ���̑傫�����w��(0-100)
     */
    public void changeVolume(int id, int param)
    {
        try
        {
            this.volume[id] = param;

            FloatControl control = (FloatControl) this.line[id]
                    .getControl(FloatControl.Type.MASTER_GAIN);
            float range = control.getMaximum() - control.getMinimum();
            control.setValue(range * (float) Math.sqrt(param / 100.0f)
                    + control.getMinimum());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * �S�ẴT�E���h�o�b�t�@���ꎞ��~����
     */
    public void pauseSound()
    {
        for (int i = 0; i < LINE_BUFFER_NUM; i++)
            this.pauseSound(i);
    }

    /**
     * �S�ẴT�E���h�o�b�t�@�̉��ʕύX
     */
    public void changeVolume(int vol)
    {
        for (int i = 0; i < LINE_BUFFER_NUM; i++)
            this.changeVolume(i, vol);
    }
}
