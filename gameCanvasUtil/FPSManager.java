package gameCanvasUtil;

/**
 * �t���[��������s�����߂̃N���X�ł��B
 *
 * ���FPS�̊Ǘ������Ă��܂��B ����l��������A�z�Ȏ����ł����A System.currentTimeMillis�̐��x�������̂Ŏd���Ȃ��E�E�E
 */
public class FPSManager
{
    // �O�̎���
    private long prevTime = 0;
    // �O��b��FPS,FPS�p�̃J�E���g�C��t���[��������̑҂�����
    private int fps, fpsTemp, waitTime;

    // ���z��FPS
    private int confFps = 60;

    // �v���C�x�[�g�R���X�g���N�^
    private void FPSManager() {}

    // �V���O���g���C���X�^���X
    private static FPSManager instance = null;

    /**
     * @return �I�u�W�F�N�g��Ԃ�
     */
    public static FPSManager getInstance()
    {
        if (instance == null)
            instance = new FPSManager();
        return instance;
    }

    /**
     * ������
     *
     * @param conf_fps FPS�̎w����s��
     */
    public void init(int conf_fps)
    {
        this.confFps = conf_fps;
        this.waitTime = 1000 / conf_fps;
    }

    /**
     * �҂����Ԃ��Z�o���ăX���[�v
     *
     * @return ���s����FPS
     */
    public int Wait()
    {
        long time, tmp;

        time = System.currentTimeMillis();
        fpsTemp++;
        if (prevTime / 1000 != time / 1000)
        {
            fps = fpsTemp;
            fpsTemp = 0;
            if (fps > confFps + 1)
            {
                waitTime++;
            }
            else if (fps < confFps - 1)
            {
                waitTime--;
            }
            if (fps > confFps + confFps / 3)
            {
                waitTime = (fps - waitTime) / 3 + waitTime;
            }
        }
        tmp = time - prevTime;
        prevTime = time;
        if (tmp == 0)
        {
            tmp = 1;
        }
        this.sleep();
        return fps;
    }

    /**
     * �X���[�v�������s��
     */
    private void sleep()
    {
        try
        {
            if (waitTime > 0)
                Thread.sleep(waitTime);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * FPS�𒲂ׂ�
     *
     * @return FPS��Ԃ��B
     */
    public int getFps()
    {
        return fps;
    }
}
