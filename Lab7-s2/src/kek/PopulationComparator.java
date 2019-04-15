package kek;

import java.util.Comparator;

/**
 * Compare 2 countries by population
 * 
 * @author Fanncy
 *
 */
public class PopulationComparator implements Comparator<Country> {

	@Override
	public int compare(Country country1, Country country2) {
		if (country1.getPopulation() == country2.getPopulation()) {
			return 0;
		}
		if (country1.getPopulation() > country2.getPopulation()) {
			return 1;
		} else
			return -1;
	}

}
