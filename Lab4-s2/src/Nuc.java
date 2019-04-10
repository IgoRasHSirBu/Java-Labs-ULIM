public class Nuc extends Copac {
    private final String fructType;

    public Nuc(){
        fructType = "Nuci";
    }

    @Override
    String getFructType() {
        return fructType;
    }
}
