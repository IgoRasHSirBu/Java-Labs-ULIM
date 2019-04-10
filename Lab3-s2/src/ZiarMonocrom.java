public class ZiarMonocrom extends Tipografie {

    public ZiarMonocrom() {
        super.pretPagina = 1;//setare pret implicit
    }

    public ZiarMonocrom(double pretPagina, int numarPagini){
        if (pretPagina > 0) {
            super.pretPagina = pretPagina;
        }
        if (numarPagini > 0) {
            super.numarPagini = numarPagini;
        }
    }

    @Override
    public double costZiarCuImagine() {
        return (this.cost() * multipluPretCuImagine);
    }

    @Override
    public double cost() {
        return (super.pretPagina * super.numarPagini);
    }
}
