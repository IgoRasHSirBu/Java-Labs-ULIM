package md.main;

import md.country.AsianCountry;
import md.country.Country;
import md.country.EuropeanCountry;
import md.file.FisierTari;

import java.util.ArrayList;


/**
 * @author Fanncy
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<String> dataCountry = new Country().getDataOfCountry();

        for (String s : dataCountry) {
            System.out.println(s);
        }

        dataCountry = new EuropeanCountry().getDataOfCountry();

        for (String s : dataCountry) {
            System.out.println(s);
        }

        dataCountry = new AsianCountry().getDataOfCountry();

        for (String s : dataCountry) {
            System.out.println(s);
        }

    }
}