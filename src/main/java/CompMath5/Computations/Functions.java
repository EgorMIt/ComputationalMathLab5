package CompMath5.Computations;

public class Functions {
    public double f(double x, int functionNumber) {
        switch (functionNumber) {
            case (1) -> {
                return Math.sin(x);
            }
            case (2) -> {
                return Math.pow(x, 2) + 3 * x - 2;
            }
            default -> {
                return Math.pow(3, x) - Math.pow(x, 2) + 2 * x;
            }
        }
    }

    public double f_(double x, int functionNumber) {
        switch (functionNumber) {
            case (1) -> {
                return Math.cos(x);
            }
            case (2) -> {
                return 2 * x + 3;
            }
            default -> {
                return Math.pow(3, x) * Math.log(3) - 2 * x + 2;
            }
        }
    }

    public double f__(double x, int functionNumber) {
        switch (functionNumber) {
            case (1) -> {
                return -1 * Math.sin(x);
            }
            case (2) -> {
                return 2;
            }
            default -> {
                return -2 + 3 * Math.log(3);
            }
        }
    }

    public double f_n(double x, int functionNumber, int n) {
        switch (functionNumber) {
            case (1) -> {
                if (n % 2 == 0)
                    return -1 * Math.sin(x);
                else
                    return Math.cos(x);
            }
            case (2) -> {
                return 0;
            }
            default -> {
                return 0;
            }
        }
    }

    public double[][] sortPoints(double[][] points) {
        for (int i = 0; i < points[0].length - 1; i++) {
            for (int j = 0; j < points[0].length - i - 1; j++)
                if (points[0][j] > points[0][j + 1]) {
                    double temp = points[0][j];
                    points[0][j] = points[0][j + 1];
                    points[0][j + 1] = temp;
                    temp = points[1][j];
                    points[1][j] = points[1][j + 1];
                    points[1][j + 1] = temp;
                }
        }
        return points;
    }
}
