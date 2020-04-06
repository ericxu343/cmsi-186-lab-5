import java.lang.Math;

public class PolynomialPod extends Pod {
    public PolynomialPod(String name, double... coefficient) {
        super(name, t -> PolynomialPod.PolynomialFunction(t, coefficient));
    }

    public static double PolynomialFunction(double t, double... coefficient) {
        double value = 0;
        for (int i = 0; i < coefficient.length; i++) {
          value += coefficient[i] * Math.pow(t, i);
        }
        return value;
    }
}
