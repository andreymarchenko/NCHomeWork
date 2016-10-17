import java.util.Arrays;

/**
 * Created by Andrey on 17.10.2016.
 */
public class MyPolinomial {
    private double[] coeffs;

    public MyPolinomial(double[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return this.coeffs.length - 1;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.coeffs.length; i++) {
            if (this.coeffs[i] != 0) {
                if (i == 0)
                    s += this.coeffs[i] + "x^" + (this.coeffs.length - 1 - i) + " +";
                else if (i != 0 && i != this.coeffs.length - 1)
                    s += " " + this.coeffs[i] + "x^" + (this.coeffs.length - 1 - i) + " +";
                else s += " " + this.coeffs[i];
            } else continue;
        }

        return s;
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < this.coeffs.length; i++) {
            result += Math.pow(x, this.coeffs.length - i - 1) * this.coeffs[i];
        }
        return result;
    }

    public MyPolinomial add(MyPolinomial polinomial) {
        double[] coeffs = new double[Math.max(this.coeffs.length, polinomial.coeffs.length)];
        MyPolinomial result = new MyPolinomial(coeffs);
        int countDifference = this.coeffs.length - polinomial.coeffs.length;
        if (countDifference < 0) {
            for (int i = 0; i < coeffs.length; i++) {
                if (i < Math.abs(countDifference)) result.coeffs[i] = polinomial.coeffs[i];
                else result.coeffs[i] = this.coeffs[i - Math.abs(countDifference)] + polinomial.coeffs[i];
            }
        }
        if (countDifference > 0) {
            for (int i = 0; i < coeffs.length; i++) {
                if (i < countDifference) result.coeffs[i] = this.coeffs[i];
                else result.coeffs[i] = this.coeffs[i] + polinomial.coeffs[i - countDifference];
            }
        } else if (countDifference == 0) {
            for (int i = 0; i < coeffs.length; i++) {
                result.coeffs[i] = this.coeffs[i] + polinomial.coeffs[i];
            }
        }
        return result;
    }

    public MyPolinomial multiply(MyPolinomial polinomial) {
        double[] coeffs = new double[Math.max(this.coeffs.length, polinomial.coeffs.length)];
        MyPolinomial result = new MyPolinomial(coeffs);
        int countDifference = this.coeffs.length - polinomial.coeffs.length;
        if (countDifference < 0) {
            for (int i = 0; i < coeffs.length; i++) {
                if (i < Math.abs(countDifference)) result.coeffs[i] = 0;
                else result.coeffs[i] = this.coeffs[i - Math.abs(countDifference)] * polinomial.coeffs[i];
            }
        }
        if (countDifference > 0) {
            for (int i = 0; i < coeffs.length; i++) {
                if (i < countDifference) result.coeffs[i] = 0;
                else result.coeffs[i] = this.coeffs[i] * polinomial.coeffs[i - countDifference];
            }
        } else if (countDifference == 0) {
            for (int i = 0; i < coeffs.length; i++) {
                result.coeffs[i] = this.coeffs[i] * polinomial.coeffs[i];
            }
        }

        return result;
    }

}
