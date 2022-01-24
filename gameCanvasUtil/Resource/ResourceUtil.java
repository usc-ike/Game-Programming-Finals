package gameCanvasUtil.Resource;

import java.io.File;

public class ResourceUtil
{
    /**
     * �A�ԃt�@�C���̍ŏI�ԍ���Ԃ�
     * 0�Ԃ���t�@�C���𒲂ׂĂ����āA�Ō�̘A�ԃt�@�C��ID��Ԃ�
     *
     * @param base_file_path �ǂݍ��ޘA�ԃt�@�C�����̎w��(xxx0.type�́Axxx�̕���)
     * @param file_type_array �g���q���X�g
     * �Ⴆ�΁A{ ".gif", ".png" } ���w�肳�ꂽ��Agif, png �̏��ɑ��݂��`�F�b�N����
     * @return
     */
    public static int getResourceLastID(String base_file_path, String[] file_type_array)
    {
        for(int i=0; i<1000; i++)
        {
            boolean ok = false;
            for(int j=0; j<file_type_array.length; j++)
            {
                File file = new File(base_file_path + i + file_type_array[j]);
                if (file.exists())
                {
                    ok = true;
                    break;
                }
            }
            if(!ok) return i;
        }
        return 1000;
    }
}
