package md.common.country;

import java.util.Comparator;

/**
 * Comparator for population of Country objs
 * 
 * @author Fanncy
 *
 */
public class PopulationComparator implements Comparator<Country> {
	@Override
	public int compare(Country o1, Country o2) {
		if (o1.getPopulation() > o2.getPopulation()) {
			return 1;
		} else if (o1.getPopulation() < o2.getPopulation()) {
			return -1;
		}
		return 0;
	}
}
