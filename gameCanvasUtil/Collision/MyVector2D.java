package gameCanvasUtil.Collision;

/**
 * 2D�p�̃x�N�g���N���X�ł��B
 */
public class MyVector2D
{
    // �x�N�g���̂w�����A�x����
    private double x, y;

    /**
     * �R���X�g���N�^
     */
    public MyVector2D()
    {
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * �R���X�g���N�^
     *
     * @param vec ����vec�̒��g���R�s�[���܂�
     */
    public MyVector2D(MyVector2D vec)
    {
        this.x = vec.x;
        this.y = vec.y;
    }

    /**
     * �R���X�g���N�^
     *
     * @param _x �w�����̎w��
     * @param _y �x�����̎w��
     */
    public MyVector2D(double _x, double _y)
    {
        this.x = _x;
        this.y = _y;
    }

    /**
     * X�����̎擾
     *
     * @return X����
     */
    public double getX()
    {
        return this.x;
    }

    /**
     * �x�����̎擾
     *
     * @return �x����
     */
    public double getY()
    {
        return this.y;
    }

    /**
     * �w�����̎w��
     *
     * @param _x �w�����̎w��
     */
    public void setX(double _x)
    {
        this.x = _x;
    }

    /**
     * �x�����̎w��
     *
     * @param _y �x�����̎w��
     */
    public void setY(double _y)
    {
        this.y = _y;
    }

}
