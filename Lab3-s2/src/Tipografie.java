public abstract class Tipografie implements  PaginiCuImagini{
    int numarPagini;
    double pretPagina;//lei

    public abstract double cost();

    public void setNumarPagini(int numarPagini) {
        if(numarPagini > 0 ){
            this.numarPagini = numarPagini;
        }
    }

    public void setPretPagina(double pretPagina) {
        if (pretPagina > 0 ) {
            this.pretPagina = pretPagina;
        }
    }

    public int getNumarPagini() {
        return this.numarPagini;
    }

    public double getPretPagina() {
        return this.pretPagina;
    }
}
