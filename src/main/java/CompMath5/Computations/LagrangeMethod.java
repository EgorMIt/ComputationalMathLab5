package CompMath5.Computations;

public class LagrangeMethod {
    private double l(int index, double[] points_x, double x) {
        double l = 1;
        for (int i = 0; i < points_x.length; i++) {
            if (i != index) {
                l *= (x - points_x[i]) / (points_x[index] - points_x[i]);
            }
        }
        return l;
    }

    public double getCountValue(double[][] points, double x) {
        double y = 0;
        for (int i = 0; i < points[0].length; i++) {
            y += points[1][i] * l(i, points[0], x);
        }
        return y;
    }

    public double calculationError(double[][] points, int functionNumber, double x) {
        double tmp = 1;

        for (int i = 2; i <= points[0].length; i++)
            tmp *= i;

        return getMaxF(points, functionNumber, points[0].length) * getCf(points, x) / tmp;
    }

    private double getMaxF(double[][] points, int functionNumber, int n) {
        double max = 0;
        Functions f = new Functions();
        if (n == 1) {
            for (int i = 0; i < points[0].length; i++)
                if (max < f.f__(points[0][i], functionNumber))
                    max = f.f__(points[0][i], functionNumber);
        } else {
            for (int i = 0; i < points[0].length; i++)
                if (max < f.f_n(points[0][i], functionNumber, n))
                    max = f.f_n(points[0][i], functionNumber, n);
        }
        return max;
    }

    private double getCf(double[][] points, double x) {
        double out = 1;
        for (int i = 0; i < points[0].length; i++) {
            out *= x - points[0][i];
        }
        return Math.abs(out);
    }
}
