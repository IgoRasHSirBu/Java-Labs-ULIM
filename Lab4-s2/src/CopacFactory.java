public class CopacFactory {

    public Copac getCopac(String typeCopac) {

        if (typeCopac == null) {
            return null;
        }
        if (typeCopac.equalsIgnoreCase("CIRES")) {
            return new Cires();
        }
        if (typeCopac.equalsIgnoreCase("MAR")) {
            return new Mar();
        }
        if (typeCopac.equalsIgnoreCase("NUC")) {
            return new Nuc();
        }

        return null;
    }
}
