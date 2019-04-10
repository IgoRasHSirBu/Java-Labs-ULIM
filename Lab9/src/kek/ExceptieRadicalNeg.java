package kek;

public class ExceptieRadicalNeg {


    static double getRez(double real) {

        if (real < 0) {

            throw new ArithmeticException("Radical din numar negativ");

        } else {
            return Math.sqrt(real);
        }
    }
}