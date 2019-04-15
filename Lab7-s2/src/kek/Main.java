package kek;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Provides examples of using ArrayList and LinkedList also Comparator for
 * sorting List
 * 
 * @author Fanncy
 *
 */
public class Main {

	public static void main(String[] args) {

		ArrayList<Country> countryList = new ArrayList<>();
		LinkedList<Country> countryLink = new LinkedList<>();
		PopulationComparator popComparator = new PopulationComparator();
		Iterator<Country> iterator;

		Country c = new Country("Rusia", 144.5);
		countryList.add(c);

		countryList.add(new EuropeanUnionCountry());

		EuropeanCountry ec1 = new EuropeanCountry("Moldova", 3.35, "Chișinău", "Europa", "Republică parlamentară",
				"Igor Dodon", 33.846, "MDL");
		countryList.add(ec1);

		EuropeanCountry ec2 = new EuropeanCountry("Austria", "Euro");
		countryList.add(ec2);

		EuropeanCountry ec3 = new EuropeanCountry("Ucraina", 603.628, "UAH");
		countryList.add(ec3);

		EuropeanUnionCountry euc1 = new EuropeanUnionCountry("Franța", 66.628, "Paris", "Europa",
				"Republică semi-prezidențială", "Emmanuel Macron", 674.843, "Euro", 1958);
		countryList.add(euc1);

		EuropeanUnionCountry euc2 = new EuropeanUnionCountry("România", 19.64, 238.397, "RON", 2007);
		countryList.add(euc2);

		EuropeanUnionCountry euc3 = new EuropeanUnionCountry("Germania", 225.1, "EUR", 1958);
		countryList.add(euc3);

		AsianCountry asc1 = new AsianCountry("Japonia", 377.973, "Yen");
		countryList.add(asc1);

	}
}
