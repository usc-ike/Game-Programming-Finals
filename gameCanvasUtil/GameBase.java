package gameCanvasUtil;

import gameCanvasUtil.GameInterface;
import gameCanvasUtil.GameCanvas;

/**
 * gameInterface���p�������N���X�B������gameCanvas�I�u�W�F�N�g������
 */
public abstract class GameBase implements GameInterface
{
    /** gameCanvas�ւ̎Q�� */
    protected GameCanvas gc = null;

    /**
     * �R���X�g���N�^�B�����P�ɁAgameCanvas�I�u�W�F�N�g�ւ̎Q�Ƃ����炤�����B
     */
    public GameBase()
    {
        gc = GameCanvas.getInstance();
    }

    /**
     * �I�������B
     */
    public abstract void finalGame();

    /**
     * �����������B
     */
    public abstract void initGame();

    /**
     * �X�V�����B
     */
    public abstract void updateGame();

    /**
     * �`�揈���B
     */
    public abstract void drawGame();
}
