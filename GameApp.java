import gameCanvasUtil.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

/**
 * �A�v���P�[�V�����̃��C������(�S�Ă͂�������n�܂�)
 *
 * �X���b�h�AEvent�����Ƃ������Ɉ����󂯂�N���X �Ƃ����A��邱�Ƃ͊�{���ɂ��炢�܂킵�B
 *
 * ���ƁA�E�C���h�E���̂��̂̃N���X
 */

public class GameApp extends JFrame implements WindowListener, Runnable
{
    // / serialVersionUID
    private static final long serialVersionUID = 1L;

    // / ���ԊǗ����s���I�u�W�F�N�g
    private FPSManager timer = null;

    // / ��ʂ��̂��̂̃I�u�W�F�N�g
    private AppCanvas canvas = null;

    // / �X���b�h
    private Thread th = null;

    // false�ɂȂ�����X���b�h���[�v�𔲂���
    private boolean thFlag = true;

    /**
     * �Q�[�����[�h
     *
     * @param args ����
     */
    public static void main(String[] args)
    {
        new GameApp();
    }

    /**
     * �R���X�g���N�^ �E�C���h�E�̑傫���ݒ�Ȃǂ��s���Ă܂��B
     */
    private GameApp()
    {
        super("FrameTest");
        timer = FPSManager.getInstance();
        timer.init(GameCanvas.CONFIG_FPS);
        GameCanvas.getInstance().init(this, new Game());

        // ���T�C�Y�s��
        setResizable(false);
        // ����{�^�����������ۂ̏���
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ���X�i�[�Ɏ��g��o�^
        addWindowListener(this);

        // �R���|�[�l���g�ǉ�
        canvas = new AppCanvas();
        add(this.canvas, BorderLayout.CENTER);

        /* pack -> setPreferredSize �̏��Ɏ��s����ƃT�C�Y�ݒ肪���܂����� */
        // �R���|�[�l���g�̃T�C�Y�ɍ��킹�ăT�C�Y��ύX����
        pack();

        // �R���|�[�l���g�ǉ���ɁA�����̃T�C�Y�i�E�C���h�E�g���̂������T�C�Y�j����E�C���h�E�T�C�Y���w��
        setPreferredSize(new Dimension(GameCanvas.WIDTH, GameCanvas.HEIGHT));

        // �E�C���h�E��\��
        setVisible(true);

        th = new Thread(this);
        th.start();
    }

    /**
     * Window���o�������Ƃ��Ăяo�����
     *
     * @param evt �E�C���h�E�̃C�x���g
     */
    public void windowOpened(WindowEvent evt)
    {
    }

    /**
     * Window�́~�{�^���������ꂽ�Ƃ��Ăяo�����
     *
     * @param evt �E�C���h�E�̃C�x���g
     */
    public void windowClosing(WindowEvent evt)
    {
        GameCanvas.getInstance().finalize();
        thFlag = false;
    }

    /**
     * Window������Ƃ��Ăяo�����
     *
     * @param evt �E�C���h�E�̃C�x���g
     */
    public void windowClosed(WindowEvent evt)
    {
    }

    /**
     * Window���ŏ������ꂽ�Ƃ��ɌĂяo�����
     *
     * @param evt �E�C���h�E�̃C�x���g
     */
    public void windowIconified(WindowEvent evt)
    {
    }

    /**
     * Window���ŏ������ꂽ��Ԃ���߂����Ƃ��ɌĂяo�����
     *
     * @param evt �E�C���h�E�̃C�x���g
     */
    public void windowDeiconified(WindowEvent evt)
    {
    }

    /**
     * Window���A�N�e�B�u�ɂȂ����Ƃ��Ăяo�����B
     *
     * @param evt �E�C���h�E�̃C�x���g
     */
    public void windowActivated(WindowEvent evt)
    {
    }

    /**
     * Window���A�N�e�B�u����Ȃ��Ȃ����Ƃ��ɌĂяo�����B
     *
     * @param evt �E�C���h�E�̃C�x���g
     */
    public void windowDeactivated(WindowEvent evt)
    {
    }

    /**
     * ���C���̃X���b�h
     */
    public void run()
    {
        while (thFlag)
        {
            this.canvas.updateMessage();
            this.canvas.drawMessage();
            timer.Wait();
        }
    }

}
