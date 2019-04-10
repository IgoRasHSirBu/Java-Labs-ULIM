import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        CopacFactory copacFactory = new CopacFactory();
        Copac copacDeCires = copacFactory.getCopac("Cires");

        try {//Exemplu de exceptie (proprie)
            copacDeCires.setHeight(10.4);
            copacDeCires.setAge(-2);

        } catch (NegativePropertyException npe1) {
            System.out.println(npe1.getMessage());
        } catch (Exception e){
            System.out.println("Excepție necunoscută!");
        }

        ArrayList<Copac> copacArrayList = new ArrayList<>();
        copacArrayList.add(copacFactory.getCopac("Mar"));
        copacArrayList.add(copacFactory.getCopac("Cires"));
        copacArrayList.add(copacFactory.getCopac("Nuc"));

        try {//Exemplu de exceptie (index)
            for (int i = 0; i < copacArrayList.size(); i++) {
                System.out.println("Copacul " + (i + 1) + " " + copacArrayList.get(i).getFructType());
            }
            System.out.println("Copacul " + (4) + " " + copacArrayList.get(4).getFructType());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("!Excepție indexul nu este corect! " + e.getMessage());
        } catch (Exception e){
            System.out.println("Excepție necunoscută!");
        }

        try {//Exemplu de exceptie (null)
            Copac copacDeRosii = copacFactory.getCopac("Rosii");
            System.out.println(copacDeRosii.getFructType());//Referinta la un obiect null

        } catch (NullPointerException npe) {
            System.out.println("!Exceptie nu este asa tip de copac! " + npe.getMessage());
        }catch (Exception e){
            System.out.println("Excepție necunoscută!");
        }


    }
}
