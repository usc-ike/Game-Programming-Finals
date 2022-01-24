package gameCanvasUtil.Resource;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.InputStream;

/**
 * �摜�̊Ǘ����s���N���X
 *
 * ���ۂ̕`��� gameCanvas��Image�I�u�W�F�N�g�Ԃ��Ă�邩��@����Ă���[<br />
 * �摜�͘A�Ԃœǂݍ��݂܂�
 */
public class ImageManager
{
    // ���\�[�X��(�z��̗v�f��)
    private int resourceNum;

    // �摜
    private Image img[] = null;

    // �摜�̃o�b�t�@�T�C�Y�B�����ł�4MB���w�肵�Ă���
    private byte imageBuffer[] = new byte[1024 * 1024 * 4];

    // �V���O���g���C���X�^���X
    private static ImageManager instance = null;

    // �v���C�x�[�g�R���X�g���N�^
    private void ImageManager()
    {
        resourceNum = 0;
    }

    /**
     * @return �I�u�W�F�N�g��Ԃ�
     */
    public static ImageManager getInstance()
    {
        if (instance == null)
            instance = new ImageManager();
        return instance;
    }

    /**
     * �������B���\�[�X���܂Ƃ߂ă��[�h����
     * @param base_file_path �ǂݍ��ޘA�ԃt�@�C�����̎w��(xxx0.wav�́Axxx�̕���)
     */
    public void init(String base_file_path)
    {
        this.loadNumberingImage(base_file_path);
    }

    /**
     * �A�Ԃ̉摜�t�@�C�����A�t�@�C�������݂��Ȃ��Ȃ�܂œǂ�
     * ".gif", ".GIF", ".png", ".PNG", ".jpg", ".JPG" �̏��ɑ��݂��`�F�b�N
     *
     * @param base_file_path �ǂݍ��ޘA�ԃt�@�C�����̎w��(xxx0.png�́Axxx�̕���)
     */
    private void loadNumberingImage(String base_file_path)
    {
        String type_list[] = { ".gif", ".GIF", ".png", ".PNG", ".jpg", ".JPG" };
        resourceNum = ResourceUtil.getResourceLastID(base_file_path, type_list);
        if(resourceNum <= 0) return;

        img = new Image[resourceNum];

        int i, j;
        for (i = 0; i < resourceNum; i++)
        {
            for (j = 0; j < type_list.length; j++)
            {
                File file = new File(base_file_path + i + type_list[j]);
                if (file.exists())
                {
                    this.img[i] = loadImage(base_file_path + i + type_list[j]);
                    if (this.img[i] != null)
                    {
                        break;
                    }
                }
            }
        }
    }

    /**
     * �摜�t�@�C����ǂݍ��ށB�ǂݍ��߂���I�u�W�F�N�g��Ԃ�
     *
     * @param file_name �t�@�C����
     * @return �ǂݍ���Image�I�u�W�F�N�g��Ԃ�
     */
    private Image loadImage(String file_name)
    {
        try
        {
            Image obj = null;
            int read = 0, tmp = 0;
            InputStream is = this.getClass().getResourceAsStream("/" + file_name);
            if (is == null)
            {
                return null;
            }
            while ((tmp = is.read(imageBuffer, read, imageBuffer.length
                    - read)) > 0)
                read += tmp;
            is.close();
            byte img_dat[] = new byte[read];
            System.arraycopy(imageBuffer, 0, img_dat, 0, read);
            obj = Toolkit.getDefaultToolkit().createImage(img_dat, 0, read);
            return obj;
        }
        catch (Exception e)
        {
            System.out.println("loadImage Exception " + file_name + "::" + e);
            return null;
        }
    }

    /**
     * �摜�̕���Ԃ�
     *
     * @param id �摜��ID
     * @return �w�肳�ꂽ�摜�̕�
     */
    public int getPicXsize(int id)
    {
        try
        {
            return img[id].getWidth(null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * �摜�̍�����Ԃ�
     *
     * @param id �摜��ID
     * @return �w�肳�ꂽ�摜�̍���
     */
    public int getPicYsize(int id)
    {
        try
        {
            return img[id].getHeight(null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * ImageManager���ŊǗ����Ă���摜��Ԃ�
     *
     * @param id �摜��ID
     * @return �摜�I�u�W�F�N�g
     */
    public Image getImage(int id)
    {
        try
        {
            return img[id];
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
