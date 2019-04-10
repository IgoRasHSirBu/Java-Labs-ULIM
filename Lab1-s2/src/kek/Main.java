package kek;

public class Main {

    public static void main(String[] args) {

        Country cn1 = new Country();
        cn1.setName("China");
        cn1.setPopulation(1418.023);
        cn1.showDataOfCountry(); //SrCEENSHOOT_1
        Country cn2 = new Country("moldova", 3.55, "Chișinău", "Europa", "Parlament","Președinte");
        cn2.showDataOfCountry(); //SCreenSHOOT_2
        Country cn3 = new Country("România", 19.64, "București", "Europa", "nu","eu");
        cn3.showDataOfCountry(); //ScreenShoot_3
        Country cn4 = new Country("Rusia", 144.5);
        cn4.showDataOfCountry(); //screenshoot_4
        cn4.setPopulation(-24.2);// Unknown Population / va ramane valoarea veche
        Country cn5 = new Country("ukraina");//Prima litera va fi upCase
        cn5.setPopulation(42.5);
        cn5.showDataOfCountry(); //screenshoot_5

        Country cn6 = new Country();
        cn6.setName("india");
        cn6.setGovernment("pr");// va fi setat Unknown Government
        cn6.showDataOfCountry();

        System.out.println("Suma populațiiei țărilor:\n" + cn1.getName() + " Populație: " + cn1.getPopulation()
                + '\n' + cn2.getName() + " Populație: " + cn2.getPopulation()
                + '\n' + cn3.getName() + " Populație: " + cn3.getPopulation()
                + '\n' + cn4.getName() + " Populație: " + cn4.getPopulation()
                + '\n' + cn5.getName() + " Populație: " + cn5.getPopulation()
                + "\neste egală cu " + ( cn1.getPopulation() + cn2.getPopulation() + cn3.getPopulation() + cn4.getPopulation() + cn5.getPopulation()) +" Mln");
    }
}
