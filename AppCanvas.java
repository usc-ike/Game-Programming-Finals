import gameCanvasUtil.Resource.InputManager;
import gameCanvasUtil.GameCanvas;

import java.awt.*;
import java.awt.event.*;

/**
 * Canvas(�`����Ǘ�����N���X)
 *
 * �����ɃX�N���[���o�b�t�@�������Ă��āA�_�u���o�b�t�@�����O�Ƃ�������N���X�B
 * ���ƁA�X�V������gameCanvas�ɂ��炢�܂킵����
 */
public class AppCanvas extends Canvas implements MouseMotionListener,
        MouseListener, KeyListener
{

    // serialVersionUID
    private static final long serialVersionUID = 1L;
    // �I�t�X�N���[���p��Image�I�u�W�F�N�g
    private Image offImage = null;
    // �I�t�X�N���[���o�b�t�@
    private Graphics offScreen  = null;
    // �L�[���͂Ƃ��̃N���X
    private InputManager inputManager = null;
    // GameCanvas
    private GameCanvas gameCanvas = null;

    /**
     * �R���X�g���N�^ �C�x���g�n���h���̓o�^�Ƃ��E�E�E
     */
    public AppCanvas()
    {
        super();

        inputManager = InputManager.getInstance();
        gameCanvas = GameCanvas.getInstance();

        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setSize(GameCanvas.WIDTH, GameCanvas.HEIGHT);
    }

    /**
     * �X�V���������ׂ����ɌĂяo����܂�
     */
    public void updateMessage()
    {
        gameCanvas.updateMessage();
        inputManager.updateKeyData();
    }

    /**
     * �`�揈�������ׂ����ɌĂяo����܂��B
     */
    public void drawMessage()
    {
        gameCanvas.drawMessage();
        repaint();
    }

    /**
     * repaint�Ăяo������@���ꂪ�Ăяo�����͂��ł��E�E�E
     *
     * @param g �`��Ώ�
     */
    public void update(Graphics g)
    {
        this.paint(g);
    }

    /**
     * �`�悪�K�v�ɂȂ�����Ăяo����܂�
     *
     * @param g �`��Ώ�
     */
    public void paint(Graphics g)
    {
        if (offImage == null)
        {
            offImage = createImage(GameCanvas.WIDTH, GameCanvas.HEIGHT);
            offScreen = offImage.getGraphics();
            gameCanvas.setGraphics(offScreen, offImage);
            this.requestFocusInWindow();
        }
        g.drawImage(offImage, 0, 0, null);
    }

    /**
     * �L�[�������ꂽ�Ƃ��ɌĂяo����܂�
     *
     * @param e �L�[�C�x���g���
     */
    public synchronized void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE)
        { // ESC�Ń��Z�b�g
            if (gameCanvas.showYesNoDialog("�Q�[�������Z�b�g���܂����H"))
            {
                gameCanvas.resetGame();
                gameCanvas.resetGameInstance(new Game());
            }
        }

        inputManager.keyPressed(e);
    }

    /**
     * �L�[�������ꂽ�Ƃ��ɌĂяo����܂�
     *
     * @param e �L�[�C�x���g���
     */
    public synchronized void keyReleased(KeyEvent e)
    {
        inputManager.keyReleased(e);
    }

    /**
     * �L�[���^�C�v���ꂽ�Ƃ��ɌĂяo����܂�
     *
     * @param e �L�[�C�x���g���
     */
    public void keyTyped(KeyEvent e)
    {
    }

    /**
     * �}�E�X����ʂɓ������Ƃ��ɌĂяo�����H
     *
     * @param e �}�E�X�C�x���g
     */
    public void mouseEntered(MouseEvent e)
    {
        this.inputManager.mouseEntered(e);
    }

    /**
     * �}�E�X����ʂ���o���Ƃ��ɌĂяo�����H
     *
     * @param e �}�E�X�C�x���g
     */
    public void mouseExited(MouseEvent e)
    {
        this.inputManager.mouseExited(e);
    }

    /**
     * �}�E�X���N���b�N�Ƃ��ɌĂяo�����H
     *
     * @param e �}�E�X�C�x���g
     */
    public void mouseClicked(MouseEvent e)
    {
        this.inputManager.mouseClicked(e);
    }

    /**
     * �}�E�X�̃{�^���������ꂽ�Ƃ��Ăяo�����
     *
     * @param e �}�E�X�C�x���g
     */
    public void mousePressed(MouseEvent e)
    {
        this.inputManager.mousePressed(e);
    }

    /**
     * �}�E�X�̃{�^���������ꂽ�Ƃ��Ăяo�����
     *
     * @param e �}�E�X�C�x���g
     */
    public void mouseReleased(MouseEvent e)
    {
        this.inputManager.mouseReleased(e);
    }

    /**
     * �}�E�X�h���b�O���ꂽ�Ƃ��Ăяo�����
     *
     * @param e �}�E�X�C�x���g
     */
    public void mouseDragged(MouseEvent e)
    {
        this.inputManager.mouseDragged(e);
    }

    /**
     * �}�E�X���������Ƃ��Ăяo�����
     *
     * @param e �}�E�X�C�x���g
     */
    public void mouseMoved(MouseEvent e)
    {
        this.inputManager.mouseMoved(e);
    }

}
