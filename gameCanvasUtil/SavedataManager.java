package gameCanvasUtil;

import java.io.*;

/**
 * �Z�[�u�f�[�^�}�l�[�W��
 *
 * int�^�z��̃Z�[�u�f�[�^���o�C�g��Ƃ��ăt�@�C���ɏ����o��/�ǂݍ��݂��s��
 */
public class SavedataManager
{
    // �Z�[�u�f�[�^�̃T�C�Y
    private static final int SAVE_DATA_SIZE = 1024;

    // /�Z�[�u�f�[�^�p�o�b�t�@
    private int savedata[] = null;

    // �Z�[�u�f�[�^������������ꂽ���ǂ���
    private boolean savedataChanged = false;

    // �v���C�x�[�g�R���X�g���N�^
    private void SavedataManager()
    {
        savedataChanged = false;
    }

    // �V���O���g���C���X�^���X
    private static SavedataManager instance = null;

    /**
     * @return �I�u�W�F�N�g��Ԃ�
     */
    public static SavedataManager getInstance()
    {
        if (instance == null)
            instance = new SavedataManager();
        return instance;
    }

    /**
     * �Z�[�u�f�[�^���t�@�C���ɏ����o��
     */
    public void writeRecord()
    {
        if(savedataChanged)
        {
            byte tmp[] = intarr2bytearr(savedata);
            writeByteArray("savedata.dat", tmp);
            savedataChanged = false;
        }
    }

    /**
     * �t�@�C������Z�[�u�f�[�^��ǂݍ���
     */
    public void readRecord()
    {
        byte tmp[] = readByteArray("savedata.dat");
        if (tmp == null)
        {
            this.savedata = new int[SAVE_DATA_SIZE];
            this.writeRecord();
        }
        else
        {
            this.savedata = bytearr2intarr(tmp);
        }
    }

    /**
     * �ǂݍ��񂾃Z�[�u�f�[�^����int�l��ǂݏo��
     *
     * @param idx �f�[�^�̃C���f�b�N�X���w��
     * @return �w�肳�ꂽ�ʒu����f�[�^��ǂݏo���ĕԂ�
     */
    public int load(int idx)
    {
        return savedata[idx];
    }

    /**
     * �Z�[�u�f�[�^�o�b�t�@�Ƀf�[�^���Z�b�g����
     *
     * @param idx �f�[�^�̃C���f�b�N�X���w��
     * @param param �Z�[�u�f�[�^�ɏ�������int�l
     */
    public void save(int idx, int param)
    {
        this.savedata[idx] = param;
        savedataChanged = true;
    }

    /**
     * ����data���t�@�C���ɏ�������
     *
     * @param file_name �t�@�C����
     * @param data �f�[�^�̎w��
     * @return �t�@�C���������݂ɐ����������ǂ���
     */
    public boolean writeByteArray(String file_name, byte data[])
    {
        FileOutputStream out = null;
        try
        {
            out = new FileOutputStream(file_name);
            out.write(data);
            out.close();
        }
        catch (Exception e)
        {
            try
            {
                out.close();
            }
            catch (Exception e2)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * �t�@�C����ǂݍ���ŁA�o�C�g�z��Ƃ��ĕԂ�
     *
     * @param file_name �t�@�C����
     * @return �ǂݍ��񂾃f�[�^��Ԃ�
     */
    private byte[] readByteArray(String file_name)
    {
        byte[] data = null;
        ;
        File fp = new File(file_name);
        long size = fp.length();
        data = new byte[(int) size];

        if(readByteArray(file_name, data))
            return data;
        else
            return null;
    }

    /**
     * �t�@�C����ǂݍ���ŁA�����̃o�C�g�z��Ɋi�[���Ă���
     *
     * @param file_name �t�@�C����
     * @param data �f�[�^�̊i�[��
     * @return �t�@�C���ǂݍ��݂ɐ��������true��Ԃ�
     */
    private boolean readByteArray(String file_name, byte data[])
    {
        FileInputStream in = null;
        try
        {
            in = new FileInputStream(file_name);
            in.read(data);
            in.close();
        }
        catch (Exception e)
        {
            try
            {
                in.close();
            }
            catch (Exception e2)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * �o�C�g�z��̎w��ʒu��int�l����������
     *
     * @param dest �z���˂����ސ�
     * @param offset �z���˂����ރI�t�Z�b�g
     * @param src �˂����ޒl
     */
    private void int2byte(byte dest[], int offset, int src)
    {
        dest[offset + 0] = (byte) ((src >> 0) & 0xff);
        dest[offset + 1] = (byte) ((src >> 8) & 0xff);
        dest[offset + 2] = (byte) ((src >> 16) & 0xff);
        dest[offset + 3] = (byte) ((src >> 24) & 0xff);
    }

    /**
     * �o�C�g�z��̎w��ʒu����int�l�𒊏o
     *
     * @param src �����o�����̔z��
     * @param offset �����o���I�t�Z�b�g
     * @return ���o����int�l
     */
    private int byte2int(byte src[], int offset)
    {
        return ((src[offset + 0] & 0xff) << 0)
                + ((src[offset + 1] & 0xff) << 8)
                + ((src[offset + 2] & 0xff) << 16)
                + ((src[offset + 3] & 0xff) << 24);
    }

    /**
     * int�̔z�񂩂�byte�̔z��֕ϊ����܂�
     *
     * @param src byte�z��ɕϊ�������int�̔z��
     * @return ����src����ϊ�����byte�z��
     */
    private byte[] intarr2bytearr(int src[])
    {
        byte val[] = new byte[src.length * 4];
        for (int i = 0; i < src.length; i++)
        {
            int2byte(val, i * 4, src[i]);
        }
        return val;
    }

    /**
     * byte�̔z�񂩂�int�̔z��֕ϊ����܂�
     *
     * @param src int�z��ɕϊ�������byte�̔z��
     * @return ����byte����ϊ�����int�z��
     */
    private int[] bytearr2intarr(byte src[])
    {
        int val[] = new int[src.length / 4];
        for (int i = 0; i < val.length; i++)
        {
            val[i] = byte2int(src, i * 4);
        }
        return val;
    }
}
