package md.factory;

import md.country.*;

public class CountryFactory {

	public Country getCountry(String countryType) {

		if (countryType == null) {
			return null;
		}
		if (countryType.equalsIgnoreCase("EuropeanCountry")) {
			return new EuropeanCountry();
		}
		if (countryType.equalsIgnoreCase("AsianCountry")) {
			return new AsianCountry();
		}
		if (countryType.equalsIgnoreCase("EuropeanUnionCountry")) {
			return new EuropeanCountry();
		}

		return null;
	}
}
