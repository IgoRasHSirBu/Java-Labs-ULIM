package kek;

public class ImpartitorIntregi {

    private int nr1, nr2;

    ImpartitorIntregi(int p1, int p2) {

        this.nr1 = p1;
        this.nr2 = p2;

    }

    int getImpartire(){

        try {
            return (this.nr1 / this.nr2);
        } catch (ArithmeticException exc) {

            throw new ArithmeticException("Exceptie! impartire la zero! Clasa ImpartitorIntregi");

        }
    }
}