package gameCanvasUtil.Resource;

/**
 * �T�E���h�}�l�[�W���̃C���^�[�t�F�[�X
 *
 * �����_�ŁAMIDI,WAV(�I��������),WAV(�X�g���[�~���O)��3�̃T�u�N���X������
 */
public interface SoundManagerInterface
{
    /**
     * �������B���\�[�X���܂Ƃ߂ă��[�h����
     * @param base_file_path �ǂݍ��ޘA�ԃt�@�C�����̎w��(xxx0.wav�́Axxx�̕���)
     */
    public void init(String base_file_path);

    /**
     * �T�E���h�̍X�V����
     */
    public void update();

    /**
     * �T�E���h���Đ�����
     *
     * @param id �T�E���h��ID���w��
     * @param loop ���[�v���s�������Z�b�g�B�s���Ȃ�true�B
     */
    public void playSound(int id, boolean loop);

    /**
     * �T�E���h�̒�~���s��
     *
     * @param id ��~���鉹��ID
     */
    public void stopSound(int id);

    /**
     * �S�ẴT�E���h�̒�~���s��
     */
    public void stopSound();

    /**
     * �T�E���h�̈ꎞ��~���s��
     *
     * @param id �ꎞ��~���鉹��ID
     */
    public void pauseSound(int id);

    /**
     * �S�ẴT�E���h�̈ꎞ��~���s��
     */
    public void pauseSound();

    /**
     * �T�E���h�̉��ʂ�ύX����
     *
     * @param id �ǂ̉���ύX���邩�H
     * @param vol ���̑傫�����w��(0-100)
     */
    public void changeVolume(int id, int vol);

    /**
     * �T�E���h�̉��ʂ�ύX����
     *
     * @param vol ���̑傫�����w��(0-100)
     */
    public void changeVolume(int vol);
}
