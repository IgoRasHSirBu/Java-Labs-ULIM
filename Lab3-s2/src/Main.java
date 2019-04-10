public class Main {

    public static void main(String[] args) {

        Tipografie[] tipograf = new Tipografie[4];// cream un array cu 4 elemente

        tipograf[0] = new ZiarMonocrom();//demonstram polimorfismul
        tipograf[1] = new ZiarColor();
        tipograf[2] = new ZiarMonocrom();
        tipograf[3] = new ZiarColor();

        tipograf[0].setNumarPagini(10);//mono
        tipograf[1].setNumarPagini(10);//color
        tipograf[2].setPretPagina(2);//mono
        tipograf[2].setNumarPagini(10);
        tipograf[3].setPretPagina(2);//color //se seteaza ca pentru o pagina monocroma*color(4)
        tipograf[3].setNumarPagini(10);

        for (int i = 0; i < tipograf.length; i++) { //ScreenShot-1
            System.out.print("Costul Ziarului ");
            if(tipograf[i] instanceof ZiarMonocrom){
                System.out.print("monocrom ");
            } else {
                System.out.print("color ");
            }
            System.out.println(+ (i + 1) + " \t\t\t\t" + tipograf[i].cost() + " lei");

            System.out.print("Costul Ziarului ");
            if(tipograf[i] instanceof ZiarMonocrom){
                System.out.print("monocrom ");
            } else {
                System.out.print("color ");
            }
            System.out.println((i + 1) + " \tcu img \t\t" + tipograf[i].costZiarCuImagine() + " lei");
        }

        System.out.println("\n\n\n\n");

        PretColor tipColor = new ZiarColor();//crearea unei referinte de tip Color
        ((ZiarColor) tipColor).setNumarPagini(5); //ScreenShot-2
        System.out.println("Costul Ziarului tipColor "+ ((ZiarColor) tipColor).costZiarCuImagine()+ " lei");


        Tipografie ziarMonoReducere = new ZiarMonocrom(){ //crearea unei clase anonime cu reducere pentru imagine
            double pretReducereMultiplu = 2.0;

            @Override
            public double costZiarCuImagine() {
                return (this.cost() * multipluPretCuImagine / pretReducereMultiplu);
            }

            @Override
            public double cost() {
                return (super.pretPagina * super.numarPagini);
            }
        };


        System.out.println("\n\n\n\n");
        ziarMonoReducere.setNumarPagini(10);
        System.out.println("Costul Ziarului monocrom cu reducere la imagine "+ ziarMonoReducere.costZiarCuImagine() + " lei");
    }
}
