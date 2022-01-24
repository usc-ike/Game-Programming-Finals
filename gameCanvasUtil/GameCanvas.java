package gameCanvasUtil;

import java.awt.*; // �O���t�B�b�N�X�N���X�̓ǂݍ���
import javax.swing.JFrame;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;

import gameCanvasUtil.Collision.Collision;
import gameCanvasUtil.Resource.ImageManager;
import gameCanvasUtil.Resource.InputManager;
import gameCanvasUtil.Resource.MidiManager;
import gameCanvasUtil.Resource.SoundManager;
import gameCanvasUtil.Resource.SoundManagerInterface;

/**
 * @author kuro@ shift>>sega
 *         fujieda@ shift>>ntt
 *
 * ���܂��܂ȋ@�\�����܂Ƃ߂��N���X
 *
 * ��{�I�ɂ͑��ɂ��炢�񂷂����ł�
 */
public class GameCanvas
{
    /** ��ʂ̕� */
    public static final int WIDTH = 640;
    /** ��ʂ̍��� */
    public static final int HEIGHT = 480;
    /** FPS�̐ݒ� */
    public static final int CONFIG_FPS = 30;

    /** ��{�^�� */
    public static final int KEY_UP = InputManager.BUTTON_UP;
    /** ���{�^�� */
    public static final int KEY_DOWN = InputManager.BUTTON_DOWN;
    /** ���{�^�� */
    public static final int KEY_LEFT = InputManager.BUTTON_LEFT;
    /** �E�{�^�� */
    public static final int KEY_RIGHT = InputManager.BUTTON_RIGHT;
    
    /** ��{�^�� */
    public static final int KEY_H = InputManager.BUTTON_H;
    /** ���{�^�� */
    public static final int KEY_N = InputManager.BUTTON_N;
    /** ���{�^�� */
    public static final int KEY_B = InputManager.BUTTON_B;
    /** �E�{�^�� */
    public static final int KEY_M = InputManager.BUTTON_M;
    
    /** ��{�^�� */
    public static final int KEY_I = InputManager.BUTTON_I;
    /** ���{�^�� */
    public static final int KEY_K = InputManager.BUTTON_K;
    /** ���{�^�� */
    public static final int KEY_J = InputManager.BUTTON_J;
    /** �E�{�^�� */
    public static final int KEY_L = InputManager.BUTTON_L;

    /** Z�L�[ */
    public static final int KEY_W = InputManager.BUTTON_W;
    /** X�L�[ */
    public static final int KEY_A = InputManager.BUTTON_A;
    /** C�L�[ */
    public static final int KEY_S = InputManager.BUTTON_S;
    /** V�L�[ */
    public static final int KEY_D = InputManager.BUTTON_D;

    /** ENTER */
    public static final int KEY_ENTER = InputManager.BUTTON_PAUSE;

    /** SPACE */
    public static final int KEY_SPACE = InputManager.BUTTON_SELECT;

    // �F�֌W�̒萔

    /** ���F */
    public static final int COLOR_WHITE = 0xFFFFFF;
    /** ���F */
    public static final int COLOR_BLACK = 0x000000;
    /** �D�F */
    public static final int COLOR_GRAY = 0x808080;
    /** �ԐF */
    public static final int COLOR_RED = 0xFF0000;
    /** �F */
    public static final int COLOR_BLUE = 0x0000FF;
    /** �ΐF */
    public static final int COLOR_GREEN = 0x00FF00;
    /** ���F */
    public static final int COLOR_YELLOW = 0xFFFF00;
    /** ���F */
    public static final int COLOR_PURPLE = 0xFF00FF;
    /** �V�A���F */
    public static final int COLOR_CYAN = 0x00FFFF;
    /** �݂����� */
    public static final int COLOR_AQUA = 0x7F7FFF;

    // �摜�̊Ǘ��Ƃ�������I�u�W�F�N�g
    private ImageManager imageManager;
    // SE�̊Ǘ�������I�u�W�F�N�g
    private SoundManagerInterface seManager;
    // BGM�̊Ǘ�������I�u�W�F�N�g
    private SoundManagerInterface bgmManager;
    // �L�[�̓��͂��Ǘ�����I�u�W�F�N�g
    private InputManager inputManager;
    // ���s����Q�[���C���^�[�t�F�[�X���p�����I�u�W�F�N�g
    private GameInterface game;
    // �Z�[�u�f�[�^�}�l�[�W��
    private SavedataManager savedataManager;

    // �����_���p
    private Random rand = new Random();

    // �`���
    private Graphics graphics;
    // �I�t�X�N���[���p�̃C���[�W
    private Image offImage;

    // JFrame�ւ̎Q��
    private JFrame frame;

    // �V���O���g���p�ɍ쐬
    static private GameCanvas _gc;

    /**
     * �V���O���g�� ����gameCanvas�I�u�W�F�N�g����������Ă�����A�����Ԃ��B�Ȃ��Ȃ琶�����ĕԂ��B
     *
     * @return gameCanvas�I�u�W�F�N�g��Ԃ�
     */
    static public GameCanvas getInstance()
    {
        if (_gc == null)
            _gc = new GameCanvas();
        return _gc;
    }

    /**
     * �V���O���g���̂��߁A�v���C�x�[�g�R���X�g���N�^
     */
    private GameCanvas()
    {
    }

    /**
     * gameCanvas�̏��������s��
     */
    public void init(JFrame _f, GameInterface g)
    {
        this.frame = _f;

        this.setImageManager(ImageManager.getInstance());
        this.imageManager.init("res/img");

        this.setSEManager(SoundManager.getInstance());
        this.seManager.init("res/snd");
        this.changeSEVolume(100);

        this.setBGMManager(MidiManager.getInstance());
        this.bgmManager.init("res/bgm");
        this.changeBGMVolume(60);

        this.inputManager = InputManager.getInstance();
        this.savedataManager = SavedataManager.getInstance();
        this.readRecord();

        this.game = g;
        this.game.initGame();
    }

    /**
     * gameCanvas�̏I�����̏����ł�
     */
    public void finalize()
    {
        if (this.game != null)
        {
            this.game.finalGame();
        }
        // �Z�[�u����
        this.writeRecord();
    }

    /**
     * Graphics�N���X�ւ̎Q�Ƃ��Z�b�g����
     *
     * @param gr
     */
    public void setGraphics(Graphics gr, Image img)
    {
        this.graphics = gr;
        this.offImage = img;
        setFont("", 0, 25);
    }

    /**
     * ���݂̉�ʂ��A�摜�Ƃ��ĕۑ����܂�
     *
     * @param file �g���q���������t�@�C���������܂�
     * @return �ۑ��ɐ�����������Ԃ��܂�
     */
    public boolean writeScreenImage(String file)
    {
        BufferedImage cur_off = new BufferedImage(GameCanvas.WIDTH,
                GameCanvas.HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics gr = cur_off.getGraphics();
        gr.drawImage(offImage, 0, 0, null);
        try
        {
            return ImageIO.write(cur_off, "PNG", new File(file + ".png"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Window�̕�������w�肵�܂�
     *
     * @param title Window�̃^�C�g���̕�������w��
     */
    public void setWindowTitle(String title)
    {
        frame.setTitle(title);
    }

    /**
     * �������`�悷��
     *
     * @param str �`�悷�镶����
     * @param x ����̂w���W
     * @param y ����̂x���W
     */
    public void drawString(String str, int x, int y)
    {
        graphics.drawString(str, x, y + graphics.getFont().getSize());
    }

    /**
     * ������𒆐S�ʒu���w�肵�ĕ`�悷��
     *
     * @param str �`�悷�镶����
     * @param x ���S�̂w���W
     * @param y ��̂x���W
     */
    public void drawCenterString(String str, int x, int y)
    {
        this.drawString(str, x - getStringWidth(str) / 2, y);
    }

    /**
     * ��������E�񂹂ɂ��ĕ`�悷��
     *
     * @param str �`�悷�镶����
     * @param x �E��̂w���W
     * @param y ��̂x���W
     */
    public void drawRightString(String str, int x, int y)
    {
        this.drawString(str, x - getStringWidth(str), y);
    }

    // /�t�H���g�I�u�W�F�N�g
    private Font myFont;
    private int FontSize;

    /**
     * drawString�ȂǂŎg�p����t�H���g��ύX���܂��B
     *
     * @param font_name �t�H���g���̎w��
     * @param font_style �t�H���g�̃X�^�C���̎w��
     * @param font_size �t�H���g�̃T�C�Y�̎w��
     */
    public void setFont(String font_name, int font_style, int font_size)
    {
        myFont = new Font(font_name, font_style, font_size);
        graphics.setFont(myFont);
        FontSize = font_size;
    }

    /**
     * �t�H���g�T�C�Y�̕ύX
     *
     * @param font_size �t�H���g�̃T�C�Y���w�肵�܂�
     */
    public void setFontSize(int font_size)
    {
        this.setFont("", 0, font_size);
    }

    /**
     * ������̃h�b�g���𒲂ׂ܂�
     *
     * ����str��drawString���ŕ`�悵���Ƃ��̕���Ԃ��܂��B
     *
     * @param str ���ׂ镶����
     * @return ����str��`�悵���Ƃ��̕�
     */
    public int getStringWidth(String str)
    {
        FontMetrics obj = graphics.getFontMetrics();
        return obj.stringWidth(str);
    }

    /**
     * drawString��AdrawRect�ȂǂŎg�p����F�̃Z�b�g
     *
     * @param color RGB�Ŏw��
     */
    public void setColor(int color)
    {
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;
        setColor(r, g, b);
    }

    /**
     * drawString��AdrawRect�ȂǂŎg�p����F�̃Z�b�g
     *
     * @param red �q����
     * @param green �f����
     * @param blue �a����
     */
    public void setColor(int red, int green, int blue)
    {
        graphics.setColor(new Color(red, green, blue));
    }

    /**
     * �����̕`��
     *
     * @param sx �J�n�_��X���W
     * @param sy �J�n�X��Y���W
     * @param ex �I���_��X���W
     * @param ey �I���_��Y���W
     */
    public void drawLine(int sx, int sy, int ex, int ey)
    {
        graphics.drawLine(sx, sy, ex, ey);
    }

    /**
     * �������̒����`�̕`��
     *
     * @param x �����`�̍���̂w���W
     * @param y �����`�̍���̂x���W
     * @param w �����`�̕�
     * @param h �����`�̍���
     */
    public void drawRect(int x, int y, int w, int h)
    {
        graphics.drawRect(x, y, w, h);
    }

    /**
     * �h��Ԃ��̒����`�̕`��
     *
     * @param x �����`�̍���̂w���W
     * @param y �����`�̍���̂x���W
     * @param w �����`�̕�
     * @param h �����`�̍���
     */
    public void fillRect(int x, int y, int w, int h)
    {
        graphics.fillRect(x, y, w, h);
    }

    /**
     * �������~�̕`��
     *
     * @param x �~�̒��S�̂w���W
     * @param y �~�̒��S�̂x���W
     * @param r �~�̔��a
     */
    public void drawCircle(int x, int y, int r)
    {
        graphics.drawArc(x - r, y - r, r * 2, r * 2, 0, 360);
    }

    /**
     * �h��Ԃ��~�̕`��
     *
     * @param x �~�̒��S�̂w���W
     * @param y �~�̒��S�̂x���W
     * @param r �~�̔��a
     */
    public void fillCircle(int x, int y, int r)
    {
        graphics.fillArc(x - r, y - r, r * 2, r * 2, 0, 360);
    }

    /**
     * �摜�`��
     *
     * @param id �摜��ID�Bimg0.gif�Ȃ�ID��0�Bimg1.gif�Ȃ�ID��1�B
     * @param x �摜�̍���̂w���W
     * @param y �摜�̍���̂x���W
     */
    public void drawImage(int id, int x, int y)
    {
        try
        {
            graphics.drawImage(imageManager.getImage(id), x, y, null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * �摜�����`��
     *
     * @param id �摜��ID�Bimg0.gif�Ȃ�ID��0�Bimg1.gif�Ȃ�ID��1�B
     * @param x �摜�̍���̂w���W
     * @param y �摜�̍���̂x���W
     * @param u ���摜���g�p���镔���̍���w���W
     * @param v ���摜���g�p���镔���̍���x���W
     * @param w �`�悷�镝
     * @param h �`�悷�鍂��
     */
    public void drawClipImage(int id, int x, int y, int u, int v, int w, int h)
    {
        try
        {
            graphics.drawImage(imageManager.getImage(id), x, y, x + w, y + h, u, v, w + u, v
                    + h, null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // / �A�t�B���g�����X�p
    private AffineTransform tr = new AffineTransform();

    /**
     * �摜���g��k���E��]�������ĕ\��
     *
     * @param id �摜�̃i���o�[�ł�
     * @param x �摜�̒��S�w���W�ł�
     * @param y �摜�̒��S�x���W�ł�
     * @param xsize ���ɂǂ̂��炢�g�傷�邩�H100%����ɂ��Ă܂��B(xsize��100�̎��A���{�B200�Ȃ�2�{�̑傫��)
     * @param ysize �c�ɂǂ̂��炢�g�傷�邩�H100%����ɂ��Ă܂��B(ysize��100�̎��A���{�B200�Ȃ�2�{�̑傫��)
     * @param angle �摜�����x��]�����邩�H(�p�x�Ŏw��)not�ʓx�@
     */
    public void drawScaledRotateImage(int id, int x, int y, int xsize,
            int ysize, double rotate)
    {
        double w = (double) (this.getImageWidth(id)) / 2.0;
        double h = (double) (this.getImageHeight(id)) / 2.0;
        this.drawScaledRotateImage(id, x, y, xsize, ysize, rotate, w, h);
    }

    /**
     * �摜���g��k���E��]�������ĕ\��
     *
     * @param id�@ �摜�̃i���o�[�ł�
     * @param x �摜�̒��S�w���W�ł�
     * @param y �摜�̒��S�x���W�ł�
     * @param xsize ���ɂǂ̂��炢�g�傷�邩�H100%����ɂ��Ă܂��B(xsize��100�̎��A���{�B200�Ȃ�2�{�̑傫��)
     * @param ysize �c�ɂǂ̂��炢�g�傷�邩�H100%����ɂ��Ă܂��B(ysize��100�̎��A���{�B200�Ȃ�2�{�̑傫��)
     * @param angle �摜�����x��]�����邩�H(�p�x�Ŏw��)not�ʓx�@
     * @param px �摜�̉�]�̒��S�ʒu�̂w���W
     * @param py �摜�̉�]�̒��S�ʒu�̂x���W
     */
    public void drawScaledRotateImage(int id, int x, int y, int xsize,
            int ysize, double rotate, double px, double py)
    {
        Image img = this.imageManager.getImage(id);
        if (img == null)
            return;
        Graphics2D gr = (Graphics2D) this.graphics;

        px *= xsize / 100.0;
        py *= ysize / 100.0;

        // ���K��
        tr.setToIdentity();

        tr.translate(x, y);
        tr.rotate(rotate * Math.PI / 360.0);
        tr.translate(-px, -py);

        tr.scale(xsize / 100.0, ysize / 100.0);
        gr.drawImage(img, tr, null);
    }

    /**
     * �摜�̕��𓾂�
     *
     * @param id �摜��ID�Bimg0.gif�Ȃ�ID��0�Bimg1.gif�Ȃ�ID��1�B
     * @return ����id�Ŏw�肳�ꂽ�摜�̕���Ԃ�
     */
    public int getImageWidth(int id)
    {
        return imageManager.getPicXsize(id);
    }

    /**
     * �摜�̍����𓾂�
     *
     * @param id �摜��ID�Bimg0.gif�Ȃ�ID��0�Bimg1.gif�Ȃ�ID��1�B
     * @return ����id�Ŏw�肳�ꂽ�摜�̍�����Ԃ�
     */
    public int getImageHeight(int id)
    {
        return imageManager.getPicYsize(id);
    }

    /**
     * �����̎���Z�b�g����
     *
     * @param seed �Z�b�g���闐���̃V�[�h
     */
    public void setSeed(int seed)
    {
        rand.setSeed(seed);
    }

    /**
     * min�`max�܂ł̊Ԃ̃����_���Ȓl��Ԃ��B
     *
     * @param min �����_���̍ŏ��l
     * @param max �����_���̍ő�l
     * @return �������������_���l
     */
    public int rand(int min, int max)
    {
        if(min < 0 || max < 0) return -1;

        int tmp = rand.nextInt();
        if (tmp < 0)
            tmp = -tmp;
        if (min < max)
        {
            max = max - min + 1;
            return tmp % max + min;
        }
        else
        {
            min = min - max + 1;
            return tmp % min + max;
        }
    }

    /**
     * �Q�[���X�e�[�g���f�t�H���g��Ԃɂ��܂�
     */
    public void resetGame()
    {
        this.stopBGM();
        this.stopSE();
        this.graphics.translate(0, 0);
    }

    /**
     * ���s�����Q�[���N���X���ăZ�b�g
     */
    public void resetGameInstance(GameInterface g)
    {
        if (this.game != null)
            this.game.finalGame();
        if (g != null)
            g.initGame();
        this.game = g;
    }

    /**
     * �X�V���ɍs������
     */
    public void updateMessage()
    {
        if (this.game != null)
        {
            this.game.updateGame();
            this.writeRecord();
        }
        // BGM���X�g���[�~���O�Đ��Ȃ̂ŃA�b�v�f�[�g
        this.bgmManager.update();
    }

    /**
     * �`�掞�ɍs������
     */
    public void drawMessage()
    {
        if (this.game != null && this.graphics != null)
            this.game.drawGame();
    }

    /**
     * ��ʂ𔒂œh��Ԃ�
     *
     */
    public void clearScreen()
    {
        setColor(255, 255, 255);
        fillRect(0, 0, WIDTH, HEIGHT);
    }

    /**
     * �A�v�����I��������
     */
    public void exitApp()
    {

        this.game.finalGame();
        System.exit(0);
    }

    /**
     * YesNo��I��������_�C�A���O���o��
     *
     * @param message �m�F�p�̃��b�Z�[�W
     * @return �I�����̌��ʂ�Ԃ�
     */
    public boolean showYesNoDialog(String message)
    {
        return (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                message, null, JOptionPane.YES_NO_OPTION));
    }

    /**
     * ���[�U�[�ɕ�����̓��͂����߂�_�C�A���O���o��
     *
     * @param message ���[�U�[�ɑ΂��郁�b�Z�[�W
     * @param default_input �f�t�H���g��Ԃł̓���
     * @return ���͂��ꂽ���b�Z�[�W��Ԃ�
     */
    public String showInputDialog(String message, String default_input)
    {
        return JOptionPane.showInputDialog(null, message, default_input);
    }










    // ---------------- Sound �֌W -------------------//

    // ���ݍĐ�����BGM ID
    private int cur_bgm = -1;

    /**
     * BGM�����[�v�Đ�����
     * BGM�̍Đ��͔r���I�ŁA2�����ɍĐ��͍s��Ȃ�
     *
     * @param id BGM�̔ԍ�
     */
    public void playBGM(int id)
    {
        this.playBGM(id, true);
    }

    /**
     * BGM���Đ�����
     * BGM�̍Đ��͔r���I�ŁA2�����ɍĐ��͍s��Ȃ�
     *
     * @param id BGM�̔ԍ�
     * @param loop ���[�v���邩�ǂ������w�肷��
     */
    public void playBGM(int id, boolean loop)
    {
        if (cur_bgm != id)
        {
            bgmManager.stopSound();
            bgmManager.playSound(id, loop);
        }
        cur_bgm = id;
    }

    /**
     * BGM�̉��ʂ�ύX����
     *
     * @param volume ���ʂ̎w��(0-100)
     */
    public void changeBGMVolume(int volume)
    {
        bgmManager.changeVolume(volume);
    }

    /**
     * BGM���~����
     */
    public void stopBGM()
    {
        if (bgmManager != null)
            bgmManager.stopSound();

        cur_bgm = -1;
    }

    /**
     * BGM���ꎞ��~����
     */
    public void pauseBGM()
    {
        bgmManager.pauseSound();
        cur_bgm = -1;
    }

    /**
     * SE���Đ�����
     *
     * @param id SE�̔ԍ�
     */
    public void playSE(int id)
    {
        this.playSE(id, false);
    }

    /**
     * SE���Đ�����
     *
     * @param id SE�̔ԍ�
     * @param loop SE�����[�v�����邩�Z�b�g����
     */
    public void playSE(int id, boolean loop)
    {
        this.seManager.playSound(id, loop);
    }

    /**
     * SE�̉��ʂ�ύX����
     *
     * @param volume ���ʂ̎w��(0-100)
     */
    public void changeSEVolume(int volume)
    {
        this.seManager.changeVolume(volume);
    }

    /**
     * �S�Ă�SE���~����
     */
    public void stopSE()
    {
        this.seManager.stopSound();
    }

    /**
     * �S�Ă�SE���ꎞ��~����
     */
    public void pauseSE()
    {
        this.seManager.pauseSound();
    }










    // -------------------�L�[���͊֌W-----------//

    /**
     * �L�[�������Ă��钷���𒲂ׂ�
     * �����Ŏw�肵���L�[���A�ǂ̂��炢������Ă��邩��Ԃ�
     *
     * @param keyCode KEY_0 �Ȃ�u0�L�[�vKEY_LEFT �Ȃ� �u���J�[�\���L�[�v�Ƃ��������ŁA���ׂ����L�[���w��
     * @return ���� keyCode�Ŏw�肳�ꂽ�L�[�������Ă��钷����Ԃ��B-1������������B0�Ȃ牟����Ă��Ȃ��B1�ȏ�͉����Ă��钷��
     */
    public int getKeyPressLength(int keyCode)
    {
        return inputManager.getKeyPressLength(keyCode);
    }

    /**
     * �L�[�������ꂽ��Ԃ��ǂ����𒲂ׂ�
     * �����Ŏw�肵���L�[��������Ă���ꍇ�Atrue���Ԃ����
     *
     * @param keyCode KEY_0 �Ȃ�u0�L�[�vKEY_LEFT �Ȃ� �u���J�[�\���L�[�v�Ƃ��������ŁA���ׂ����L�[���w��
     * @return ���� keyCode�Ŏw�肳�ꂽ�L�[�������ꂽ����ł������ꍇ true�B�����Ă����ꍇ false
     */
    public boolean isKeyPress(int keyCode)
    {
        return inputManager.isKeyPressed(keyCode);
    }

    /**
     * �L�[���������u�Ԃ��ǂ����𒲂ׂ�
     * �����Ŏw�肵���L�[���A�����ꂽ����ł������ꍇtrue��Ԃ�
     *
     * @param keyCode KEY_0 �Ȃ�u0�L�[�vKEY_LEFT �Ȃ� �u���J�[�\���L�[�v�Ƃ��������ŁA���ׂ����L�[���w��
     * @return ���� keyCode�Ŏw�肳�ꂽ�L�[�������ꂽ����ł������ꍇ true�B�L�[���������ςȂ��A������Ă����Ԃ̏ꍇ false
     */
    public boolean isKeyPushed(int keyCode)
    {
        return inputManager.isKeyPushed(keyCode);
    }

    /**
     * �L�[�������ꂽ�u�Ԃ��ǂ����𒲂ׂ�
     * �����Ŏw�肵���L�[���A����������ł������ꍇtrue��Ԃ�
     *
     * @param keyCode KEY_0 �Ȃ�u0�L�[�vKEY_LEFT �Ȃ� �u���J�[�\���L�[�v�Ƃ��������ŁA���ׂ����L�[���w��
     * @return ���� keyCode�Ŏw�肳�ꂽ�L�[�������ꂽ����ł������ꍇ true�B�L�[�������Ă���A�������ςȂ��̏�Ԃ̏ꍇ false
     */
    public boolean isKeyReleased(int keyCode)
    {
        return inputManager.isKeyReleased(keyCode);
    }

    /**
     * �}�E�X��X���W���擾����
     *
     * @return ���݂̃}�E�X��X���W��Ԃ�
     */
    public int getMouseX()
    {
        return this.inputManager.getMouseX();
    }

    /**
     * �}�E�X��Y���W���擾����
     *
     * @return ���݂̃}�E�X��X���W��Ԃ�
     */
    public int getMouseY()
    {
        return this.inputManager.getMouseY();
    }

    /**
     * �}�E�X�̃{�^����������Ă��鎞�Ԃ𒲂ׂ�
     *
     * @return �}�E�X�̃{�^����������Ă��鎞�Ԃ𒲂ׂ�
     */
    public int getMouseClickLength()
    {
        return this.inputManager.getMouseClickLength();
    }

    /**
     * �}�E�X�̃{�^�����������u�Ԃ��ǂ����𒲂ׂ�
     *
     * @return �}�E�X�̃{�^�����������u�ԂȂ�true��Ԃ�
     */
    public boolean isMousePushed()
    {
        return this.inputManager.isMousePushed();
    }

    /**
     * �}�E�X�̃{�^���𗣂����u�Ԃ��ǂ����𒲂ׂ�
     *
     * @return �}�E�X�̃{�^���𗣂����u�ԂȂ�true��Ԃ�
     */
    public boolean isMouseReleased()
    {
        return this.inputManager.isMouseReleased();
    }

    /**
     * �}�E�X�̃{�^���������ꂽ��Ԃ��ǂ����𒲂ׂ�
     *
     * @return �}�E�X�̃{�^���������Ă�����true��Ԃ�
     */
    public boolean isMousePress()
    {
        return this.inputManager.isMousePress();
    }



    // -------------------- �Z�[�u�f�[�^�n ------------------//
    /**
     * �Z�[�u�f�[�^���t�@�C���ɏ����o��
     */
    private void writeRecord()
    {
        this.savedataManager.writeRecord();
    }

    /**
     * �t�@�C������Z�[�u�f�[�^��ǂݍ���
     */
    private void readRecord()
    {
        this.savedataManager.readRecord();
    }

    /**
     * �ǂݍ��񂾃Z�[�u�f�[�^����int�l��ǂݏo��
     *
     * @param idx �f�[�^�̃C���f�b�N�X���w��
     * @return �w�肳�ꂽ�ʒu����f�[�^��ǂݏo���ĕԂ�
     */
    public int load(int idx)
    {
        return this.savedataManager.load(idx);
    }

    /**
     * �Z�[�u�f�[�^�o�b�t�@�Ƀf�[�^���Z�b�g����
     *
     * @param idx �f�[�^�̃C���f�b�N�X���w��
     * @param param �Z�[�u�f�[�^�ɏ�������int�l
     */
    public void save(int idx, int param)
    {
        this.savedataManager.save(idx, param);
    }











    // --------------- �����蔻��n ----------------//

    /**
     * ��`�`�Ƌ�`�a���Ԃ����Ă��邩���肷��
     *
     * @param x1 ��`�`�̍���w���W
     * @param y1 ��`�`�̍���x���W
     * @param w1 ��`�`�̕�
     * @param h1 ��`�`�̍���
     * @param x2 ��`�a�̍���w���W
     * @param y2 ��`�a�̍���x���W
     * @param w2 ��`�a�̕�
     * @param h2 ��`�a�̍���
     *
     */
    public boolean checkHitRect(int x1, int y1, int w1, int h1, int x2, int y2,
            int w2, int h2)
    {
        return Collision.checkHitRect(x1, y1, w1, h1, x2, y2, w2, h2);
    }

    /**
     * �摜A�Ɖ摜B���w��ʒu�ɏ������Ƃ����Ƃ��ɉ摜���m���������Ă��邩���m���߂�
     *
     * drawImage�ł����A�摜A�Ɖ摜B���������Ƃ���
     *
     * @param img1 �摜A��ID���w��
     * @param x1 �摜A�̍���X���W���w��
     * @param y1 �摜A�̍���Y���W���w��
     * @param img2 �摜B��ID���w��
     * @param x2 �摜B�̍���X���W���w��
     * @param y2 �摜B�̍���Y���W���w��
     * @return �摜���m���������Ă��邩�ǂ�����Ԃ��܂�
     */
    public boolean checkHitImage(int img1, int x1, int y1, int img2, int x2,
            int y2)
    {
        return this.checkHitRect(x1, y1, this.getImageWidth(img1),
                this.getImageHeight(img1), x2, y2, this.getImageWidth(img2),
                this.getImageHeight(img2));
    }

    /**
     * �~A�Ɖ~B�̓����蔻����s��
     *
     * @param x1 �~A�̒��SX���W
     * @param y1 �~A�̒��SY���W
     * @param r1 �~A�̔��a
     * @param x2 �~B�̒��SX���W
     * @param y2 �~B�̒��SY���W
     * @param r2 �~B�̔��a
     * @return �~A�Ɖ~B�������������ǂ����H
     */
    public boolean checkHitCircle(int x1, int y1, int r1, int x2, int y2, int r2)
    {
        return Collision.checkHitCircle(x1, y1, r1, x2, y2, r2);
    }











    // ----------------- ���w�n�̃��\�b�h ------------//
    /**
     * ������(��)�����߂�
     *
     * @param data �����������߂�������
     * @return �����ŗ^����ꂽ�����̕�������Ԃ�
     */
    public double sqrt(double data)
    {
        return Math.sqrt(data);
    }

    /**
     * cos�����߂�
     *
     * @param angle �p�x���w�肷��(not �ʓx�@)
     * @return angle��cos
     */
    public double cos(double angle)
    {
        return Math.cos(angle * Math.PI / 180.0);
    }

    /**
     * sin�����߂�
     *
     * @param angle �p�x���w�肷��(not �ʓx�@)
     * @return angle��sin
     */
    public double sin(double angle)
    {
        return Math.sin(angle * Math.PI / 180.0);
    }

    /**
     * atan2�����߂�(�x�N�g���̊p�x�����߂�)
     *
     * @param x �x�N�g����X����
     * @param y �x�N�g����Y����
     * @return �x�N�g���̊p�x��Ԃ�
     */
    public double atan2(double x, double y)
    {
        return Math.atan2(x, y) * 180.0 / Math.PI;
    }











    // ------------- �}�l�[�W���֌W --------//

    /**
     * �摜�̃}�l�[�W�����Z�b�g
     *
     * @param manager �}�l�[�W��
     */
    private void setImageManager(ImageManager manager)
    {
        this.imageManager = manager;
    }

    /**
     * ���ʉ��̃}�l�[�W�����Z�b�g
     *
     * @param manager �}�l�[�W��
     */
    private void setSEManager(SoundManagerInterface manager)
    {
        if (this.seManager != null)
            this.seManager.stopSound();
        this.seManager = manager;
    }

    /**
     * BGM�̃}�l�[�W�����Z�b�g
     *
     * @param manager �}�l�[�W��
     */
    private void setBGMManager(SoundManagerInterface manager)
    {
        this.stopBGM();
        this.bgmManager = manager;
    }
}
