package gameCanvasUtil.Resource;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * �L�[���́A�}�E�X���͂̊Ǘ����s���N���X
 *
 * ��Ȏd���̓C�x���g�ŗ������̂��o�b�t�@���邱�ƁB
 *
 */
public class InputManager
{

    // �L�[�̊֘A
    public static final int BUTTON_UP = 0;
    public static final int BUTTON_DOWN = 1;
    public static final int BUTTON_LEFT = 2;
    public static final int BUTTON_RIGHT = 3;

    public static final int BUTTON_W = 4;
    public static final int BUTTON_A = 5;
    public static final int BUTTON_S = 6;
    public static final int BUTTON_D = 7;

    public static final int BUTTON_PAUSE = 8;
    public static final int BUTTON_Z = 9;
    public static final int BUTTON_X = 10;
    public static final int BUTTON_SELECT = 11;
    
    public static final int BUTTON_H = 12;
    public static final int BUTTON_N = 13;
    public static final int BUTTON_B = 14;
    public static final int BUTTON_M = 15;
    
    public static final int BUTTON_I = 16;
    public static final int BUTTON_K = 17;
    public static final int BUTTON_J = 18;
    public static final int BUTTON_L = 19;

    private static final int KEYLIST[] = { KeyEvent.VK_UP, KeyEvent.VK_DOWN,
            KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_W, KeyEvent.VK_A,
            KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_ENTER, KeyEvent.VK_Z,
            KeyEvent.VK_X, KeyEvent.VK_SPACE, KeyEvent.VK_H, KeyEvent.VK_N, KeyEvent.VK_B,
            KeyEvent.VK_M, KeyEvent.VK_I, KeyEvent.VK_K, KeyEvent.VK_J, KeyEvent.VK_L};

    // �L�[���͏��̃o�b�t�@�����O�ׂ̈Ɏg�p
    private int Push_Key_State[] = null;
    private boolean keyReleaseFlag[] = null;
    private boolean keyPushFlag[] = null;

    // �}�E�X�̍��W
    private int mouse_x, mouse_y;
    // �}�E�X�̃N���b�N����
    private int mouse_click_time;

    // �V���O���g���p�I�u�W�F�N�g
    private static InputManager instance = null;

    /**
     * @return �I�u�W�F�N�g��Ԃ�
     */
    public static InputManager getInstance()
    {
        if (instance == null)
            instance = new InputManager();
        return instance;
    }

    /**
     * �v���C�x�[�g�R���X�g���N�^
     */
    private InputManager()
    {
        this.Push_Key_State = new int[KEYLIST.length];
        this.keyReleaseFlag = new boolean[KEYLIST.length];
        this.keyPushFlag = new boolean[KEYLIST.length];
        this.mouse_click_time = 0;
        this.mouse_x = 0;
        this.mouse_y = 0;
    }

    /**
     * �}�E�X���������Ƃ��ɌĂ΂�郁�\�b�h
     *
     * @param e �}�E�X�C�x���g�I�u�W�F�N�g
     */
    public void mouseEntered(MouseEvent e)
    {
        this.mouse_x = e.getX();
        this.mouse_y = e.getY();
    }

    /**
     * �}�E�X���o���Ƃ��ɌĂ΂�郁�\�b�h
     *
     * @param e �}�E�X�C�x���g�I�u�W�F�N�g
     */
    public void mouseExited(MouseEvent e)
    {
        this.mouse_x = e.getX();
        this.mouse_y = e.getY();
    }

    /**
     * �}�E�X���N���b�N���ꂽ�ɌĂ΂�郁�\�b�h
     *
     * @param e �}�E�X�C�x���g�I�u�W�F�N�g
     */
    public void mouseClicked(MouseEvent e)
    {
        this.mouse_x = e.getX();
        this.mouse_y = e.getY();

    }

    /**
     * �}�E�X�������ꂽ�Ƃ��ɌĂ΂�郁�\�b�h
     *
     * @param e �}�E�X�C�x���g�I�u�W�F�N�g
     */
    public void mousePressed(MouseEvent e)
    {
        this.mouse_x = e.getX();
        this.mouse_y = e.getY();
        mouse_click_time = 1;
    }

    /**
     * �}�E�X�������ꂽ�Ƃ��ɌĂ΂�郁�\�b�h
     *
     * @param e �}�E�X�C�x���g�I�u�W�F�N�g
     */
    public void mouseReleased(MouseEvent e)
    {
        this.mouse_x = e.getX();
        this.mouse_y = e.getY();
        mouse_click_time = -1;
    }

    /**
     * �}�E�X���h���b�O���ꂽ�Ƃ��ɌĂ΂�郁�\�b�h
     *
     * @param e �}�E�X�C�x���g�I�u�W�F�N�g
     */
    public void mouseDragged(MouseEvent e)
    {
        this.mouse_x = e.getX();
        this.mouse_y = e.getY();
    }

    /**
     * �}�E�X���������Ƃ��ɌĂ΂�郁�\�b�h
     *
     * @param e �}�E�X�C�x���g�I�u�W�F�N�g
     */
    public void mouseMoved(MouseEvent e)
    {
        this.mouse_x = e.getX();
        this.mouse_y = e.getY();

    }

    /**
     * �}�E�X��X���W�𒲂ׂ�
     *
     * @return �}�E�X��X���W��Ԃ�
     */
    public int getMouseX()
    {
        return this.mouse_x;
    }

    /**
     * �}�E�X��Y���W�𒲂ׂ�
     *
     * @return �}�E�X��Y���W��Ԃ�
     */
    public int getMouseY()
    {
        return this.mouse_y;
    }

    /**
     * �}�E�X�̃{�^���������Ă��鎞�Ԃ𒲂ׂ�
     *
     * @return �}�E�X�̉����Ă��鎞�Ԃ𒲂ׂ�
     */
    public int getMouseClickLength()
    {
        return this.mouse_click_time;
    }

    /**
     * �}�E�X�̃{�^�����������u�Ԃ����ׂ�
     *
     * @return �}�E�X�̃{�^�����������u�ԂȂ�true��Ԃ�
     */
    public boolean isMousePushed()
    {
        return this.mouse_click_time == 1;
    }

    /**
     * �}�E�X�̃{�^���𗣂����u�Ԃ��𒲂ׂ�
     *
     * @return �}�E�X�̃{�^���𗣂����u�ԂȂ�true��Ԃ�
     */
    public boolean isMouseReleased()
    {
        return this.mouse_click_time == -1;
    }

    /**
     * �}�E�X�̃{�^���������Ă��邩���ׂ�
     *
     * @return �}�E�X�̃{�^���������Ă�����true��Ԃ�
     */
    public boolean isMousePress()
    {
        return this.mouse_click_time >= 1;
    }

    /**
     * �}�E�X��L�[�̏�Ԃ��X�V����
     */
    public void updateKeyData()
    {
        for (int i = 0; i < KEYLIST.length; i++)
        {
            if (Push_Key_State[i] != 0)
            {
                Push_Key_State[i] += 1;
            }
        }
        for (int i = 0; i < KEYLIST.length; i++)
        {
            if (this.keyPushFlag[i] && this.getKeyState(i) == 0)
            {
                this.Push_Key_State[i] = 1;
            }
            else if (this.keyReleaseFlag[i] && this.getKeyState(i) > 0)
            {
                this.Push_Key_State[i] = -1;
                this.keyReleaseFlag[i] = false;
            }
            this.keyPushFlag[i] = false;
        }

        if (mouse_click_time != 0)
            mouse_click_time++;
    }

    /**
     * �L�[�������ꂽ�Ƃ��ɌĂяo����郁�\�b�h
     *
     * @param e �L�[�C�x���g
     */
    public synchronized void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        for (int i = 0; i < KEYLIST.length; i++)
        {
            if (KEYLIST[i] == key)
            {
                this.keyPushFlag[i] = true;
                break;
            }
        }
    }

    /**
     * �L�[�������ꂽ�Ƃ��ɌĂяo����郁�\�b�h
     *
     * @param e �L�[�C�x���g
     */
    public synchronized void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        for (int i = 0; i < KEYLIST.length; i++)
        {
            if (KEYLIST[i] == key)
            {
                this.keyReleaseFlag[i] = true;
                break;
            }
        }
    }

    /**
     * �L�[���^�C�v���ꂽ�Ƃ��炵��
     *
     * @param e �L�[�C�x���g
     */
    public void keyTyped(KeyEvent e)
    {
    }

    /**
     * �L�[�̏�Ԃ𓾂�
     *
     * @param num �L�[�R�[�h
     * @return �L�[�̉����Ă��钷����Ԃ�
     */
    private int getKeyState(int num)
    {
        if (num < 0 || num >= KEYLIST.length)
        {
            return -1;
        }
        return Push_Key_State[num];
    }

    /**
     * �L�[�������Ă��钷����Ԃ�
     *
     * @param number ���ׂ�L�[�̔ԍ����w�肷��
     * @return ���ׂĂ���L�[�̒�����Ԃ�
     */
    public int getKeyPressLength(int number)
    {
        return getKeyState(number);
    }

    /**
     * �L�[�������Ă��邩�ǂ�����Ԃ�
     *
     * @param key ���ׂ����L�[���w��
     * @return true�Ȃ�΁A���ׂĂ���L�[��������Ă��āAfalse�Ȃ牟����Ă��Ȃ�
     */
    public boolean isKeyPressed(int key)
    {
        return (this.getKeyState(key) > 0);
    }

    /**
     * �L�[�������ꂽ�u�Ԃ���Ԃ�
     *
     * @param key ���ׂ����L�[���w��
     * @return true�Ȃ�΁A���̎w��L�[�������ꂽ�u�ԁBfalse�Ȃ�΁A�����ꂽ�u�Ԃł͂Ȃ��D
     */
    public boolean isKeyPushed(int key)
    {
        return (this.getKeyState(key) == 1);
    }

    /**
     * �L�[�������ꂽ�u�Ԃ���Ԃ�
     *
     * @param key ���ׂ����L�[���w��
     * @return true�Ȃ�΁A���̎w��L�[�������ꂽ�u�ԁBfalse�Ȃ�΁A�����ꂽ�u�Ԃł͂Ȃ��D
     */
    public boolean isKeyReleased(int key)
    {
        return (this.getKeyState(key) < 0);
    }
}
