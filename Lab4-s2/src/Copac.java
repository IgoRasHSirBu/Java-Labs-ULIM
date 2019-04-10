abstract public class Copac {
    private int age;
    private double height;

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) throws NegativePropertyException {
        if (age < 0) {
            throw new NegativePropertyException("An negativ!");
        }
        this.age = age;
    }

    protected double getHeight() {
        return height;
    }

    protected void setHeight(double height) throws NegativePropertyException {
        if (height < 0) {
            throw new NegativePropertyException("Înălțime negativă!");
        }
        this.height = height;
    }

    abstract String getFructType();

}
