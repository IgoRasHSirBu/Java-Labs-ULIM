public class Cires extends Copac {
    private final String fructType;

    public Cires(){
        fructType = "Cireșe";
    }

    @Override
    String getFructType() {
        return fructType;
    }
}
