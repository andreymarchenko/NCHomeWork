/**
 * Created by Andrey on 16.10.2016.
 */
public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {

    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" + real + "+" + imag + "i)";
    }

    public boolean isReal() {
        if (this.real >= 0.0 && this.imag == 0.0) return true;
        else return false;
    }

    public boolean isImaginary() {
        if (this.imag >= 0.0 && this.real == 0.0) return true;
        else return false;
    }

    public boolean equals(double real, double imag) {
        if (this.real == real && this.imag == imag) return true;
        else return false;
    }

    public boolean equals(MyComplex complex) {
        if (this == complex) return true;
        else return false;
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
    }

    public double argument() {
        if ((this.real > 0.0 && this.imag > 0.0) || (this.real > 0.0 && this.imag < 0.0))
            return Math.atan(imag / real);
        if (this.real < 0.0 && this.imag > 0.0)
            return Math.PI + Math.atan(imag / real);
        else if (this.real < 0.0 && this.imag < 0.0)
            return -Math.PI + Math.atan(imag / real);
        else return 0.0;
    }

    public MyComplex add(MyComplex complex) {
        this.real += complex.real;
        this.imag += complex.imag;
        return this;
    }

    public MyComplex addNew(MyComplex rightComplex) {
        MyComplex complex = new MyComplex(this.real + rightComplex.real, this.imag + rightComplex.imag);
        return complex;
    }

    public MyComplex subtract(MyComplex complex) {
        this.real -= complex.real;
        this.imag -= complex.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex rightComplex) {
        MyComplex complex = new MyComplex(this.real - rightComplex.real, this.imag - rightComplex.imag);
        return complex;
    }

    public MyComplex multiply(MyComplex rightComplex) {
        double real = this.real * rightComplex.real - this.imag * rightComplex.imag;
        double imag = this.real * rightComplex.imag + this.imag * rightComplex.real;
        this.real = real;
        this.imag = imag;
        return this;
    }

    public MyComplex devide(MyComplex rightComplex) {
        double rightComplexScale = Math.pow(rightComplex.real,2) + Math.pow(rightComplex.imag,2);
        MyComplex complex = this.multiply(new MyComplex(rightComplex.real / rightComplexScale,
                -rightComplex.imag / rightComplexScale));
        this.real = complex.real;
        this.imag = complex.imag;
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(this.real, -this.imag);
    }
}
