package gameCanvasUtil;

/**
 * game�̃C���^�[�t�F�[�X�N���X�ł��B
 * gameCanvas�ɓo�^���āAupdateGame���̃��\�b�h�Ăяo�����s�Ȃ��܂�
 */
public interface GameInterface
{
    /** �X�V���� */
    public void updateGame();

    /** �`�揈�� */
    public void drawGame();

    /** ���������� */
    public void initGame();

    /** �I������ */
    public void finalGame();
}
