package gameCanvasUtil.Collision;

/**
 * �Փ˔���Ȃǂ����܂Ƃ߂��N���X�ł�
 */
public class Collision
{

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
    static public boolean checkHitRect(int x1, int y1, int w1, int h1, int x2,
            int y2, int w2, int h2)
    {
        if (x1 < x2 + w2 && x1 + w1 > x2 && y1 < y2 + h2 && y1 + h1 > y2)
        {
            return true;
        }
        return false;
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
    static public boolean checkHitCircle(double x1, double y1, double r1,
            double x2, double y2, double r2)
    {
        double r = r1 + r2;
        double x = x1 - x2;
        double y = y1 - y2;

        if (x * x + y * y <= r * r)
        {
            return true;
        }
        return false;
    }

    /**
     * ��_�Ԃ̋��������߂�
     *
     * @param x1 �_A��X���W
     * @param y1 �_A��Y���W
     * @param x2 �_B��X���W
     * @param y2 �_B��Y���W
     * @return �_A�Ɠ_B�̋�����Ԃ�
     */
    static public double getPointDistance(double x1, double y1, double x2,
            double y2)
    {
        double x = x1 - x2;
        double y = y1 - y2;

        return Math.sqrt(x * x + y * y);
    }

    /**
     * ����A�Ɛ���B�̓����蔻��
     *
     * @param st_x1 ����A�̎n�_X���W
     * @param st_y1 ����A�̎n�_Y���W
     * @param ed_x1 ����A�̏I�_X���W
     * @param ed_y1 ����A�̏I�_Y���W
     * @param st_x2 ����B�̎n�_X���W
     * @param st_y2 ����B�̎n�_Y���W
     * @param ed_x2 ����B�̏I�_X���W
     * @param ed_y2 ����B�̏I�_Y���W
     * @return �������m�̌�_��Ԃ��B(��_�������ꍇ�Anull��Ԃ�)
     */
    static public MyVector2D checkHitVector(double st_x1, double st_y1,
            double ed_x1, double ed_y1, double st_x2, double st_y2,
            double ed_x2, double ed_y2)
    {

        MyVector2D p = null;
        double s, r;

        double acx = st_x2 - st_x1;
        double acy = st_y2 - st_y1;
        double bunbo = (ed_x1 - st_x1) * (ed_y2 - st_y2) - (ed_y1 - st_y1)
                * (ed_x2 - st_x2);

        if (bunbo == 0.0)
            return null;

        r = ((ed_y2 - st_y2) * acx - (ed_x2 - st_x2) * acy) / bunbo;
        s = ((ed_y1 - st_y1) * acx - (ed_x1 - st_x1) * acy) / bunbo;

        if (0.0 <= r && r <= 1.0 && 0.0 <= s && s <= 1.0)
        {
            p = new MyVector2D((int) (st_x1 + (ed_x1 - st_x1) * r),
                    (int) (st_y1 + (ed_y1 - st_y1) * r));
        }
        return p;
    }

    /**
     * ����A�Ɛ���B�̓����蔻����s��(new ���Ȃ���)
     *
     * @param st_x1 ����A�̎n�_X���W
     * @param st_y1 ����A�̎n�_Y���W
     * @param ed_x1 ����A�̏I�_X���W
     * @param ed_y1 ����A�̏I�_Y���W
     * @param st_x2 ����B�̎n�_X���W
     * @param st_y2 ����B�̎n�_Y���W
     * @param ed_x2 ����B�̏I�_X���W
     * @param ed_y2 ����B�̏I�_Y���W
     * @param p ���������|�C���g���i�[����
     * @return �������m�̌�_���������ꍇ�Atrue,
     */
    static public boolean checkHitVector(double st_x1, double st_y1,
            double ed_x1, double ed_y1, double st_x2, double st_y2,
            double ed_x2, double ed_y2, MyVector2D p)
    {

        double s, r;

        double acx = st_x2 - st_x1;
        double acy = st_y2 - st_y1;
        double bunbo = (ed_x1 - st_x1) * (ed_y2 - st_y2) - (ed_y1 - st_y1)
                * (ed_x2 - st_x2);

        if (bunbo == 0.0)
            return false;

        r = ((ed_y2 - st_y2) * acx - (ed_x2 - st_x2) * acy) / bunbo;
        s = ((ed_y1 - st_y1) * acx - (ed_x1 - st_x1) * acy) / bunbo;

        if (0.0 <= r && r <= 1.0 && 0.0 <= s && s <= 1.0)
        {
            p.setX(st_x1 + (ed_x1 - st_x1) * r);
            p.setY(st_y1 + (ed_y1 - st_y1) * r);
        }
        return true;
    }

    /**
     * �����Ɠ_�̋����𓾂�
     *
     * @param px �_��X���W
     * @param py �_��Y���W
     * @param st_x �����̎n�_X���W
     * @param st_y �����̎n�_Y���W
     * @param ed_x �����̏I�_X���W
     * @param ed_y �����̏I�_Y���W
     * @return �_�Ɛ����̋���
     */
    static public double getVectorPointDistance(double px, double py,
            double st_x, double st_y, double ed_x, double ed_y)
    {
        double distance = 0.0;

        double dx, dy;
        double a, b, t;
        double tx, ty;
        dx = ed_x - st_x;
        dy = ed_y - st_y;

        a = (dx * dx + dy * dy);
        b = dx * (st_x - px) + dy * (st_y - py);
        t = -b / a;

        if (t < 0.0)
            t = 0.0;
        if (t > 1.0)
            t = 1.0;

        tx = st_x + dx * t;
        ty = st_y + dy * t;

        distance = Math.sqrt((px - tx) * (px - tx) + (py - ty) * (py - ty));
        return distance;
    }

}
