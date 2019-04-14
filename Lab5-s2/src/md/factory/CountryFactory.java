package md.factory;

import md.country.*;

/**
 * Used for creating specific objects
 * 
 * @author Fanncy
 *
 */
public class CountryFactory {

	/**
	 * 
	 * @param countryType- specifies the object type
	 * @return specified object type
	 */
	public Country getCountry(String countryType) {

		if (countryType == null) {
			return null;
		}
		if (countryType.equalsIgnoreCase("EuropeanCountry") || countryType.equalsIgnoreCase("European Country")
				|| countryType.equalsIgnoreCase("TaraEuropeana") || countryType.equalsIgnoreCase("Tara Europeana")
				|| countryType.equalsIgnoreCase("ȚarăEuropeană") || countryType.equalsIgnoreCase("Țară Europeană")) {
			return new EuropeanCountry();
		}
		if (countryType.equalsIgnoreCase("AsianCountry") || countryType.equalsIgnoreCase("Asian Country")
				|| countryType.equalsIgnoreCase("TaraAsiatica") || countryType.equalsIgnoreCase("Tara Asiatica")
				|| countryType.equalsIgnoreCase("ȚarăAsiatică") || countryType.equalsIgnoreCase("Țară Asiatică")) {
			return new AsianCountry();
		}
		if (countryType.equalsIgnoreCase("EuropeanUnionCountry")
				|| countryType.equalsIgnoreCase("European Union Country")
				|| countryType.equalsIgnoreCase("TaraUniuniiEuropene")
				|| countryType.equalsIgnoreCase("Tara Uniunii Europene")
				|| countryType.equalsIgnoreCase("ȚaraUniuniiEuropene")
				|| countryType.equalsIgnoreCase("Țara Uniunii Europene")) {
			return new EuropeanUnionCountry();
		}
		if (countryType.equalsIgnoreCase("Country") || countryType.equalsIgnoreCase("Tara")
				|| countryType.equalsIgnoreCase("Țară")) {
			return new Country();
		}
		return null;
	}
}
