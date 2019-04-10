public class ZiarColor extends Tipografie implements PretColor{


    public ZiarColor() {
        super.pretPagina = 1;
    }

    public ZiarColor(double pretPagina, int numarPagini) {
        if (pretPagina > 0) {
            super.pretPagina = pretPagina;
        }
        if (numarPagini > 0) {
            super.numarPagini = numarPagini;
        }
    }

    @Override
    public double costZiarCuImagine() {
        return (super.numarPagini * super.pretPagina * multipluPretCuImagine * multipluPaginaColor);
    }

    @Override
    public double cost() {
        return (super.numarPagini * super.pretPagina * multipluPaginaColor);
    }

    @Override
    public void setNumarPagini(int numarPagini) {
        super.numarPagini = numarPagini;
    }

    @Override
    public void setPretPagina(double pretPagina) {
        super.pretPagina = pretPagina;
    }

    @Override
    public int getNumarPagini() {
        return super.numarPagini;
    }

    @Override
    public double getPretPagina() {
        return super.getPretPagina();
    }
}
