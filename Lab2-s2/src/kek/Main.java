package kek;

public class Main {

	public static void main(String[] args) {// :3

		Country c = new Country("Rusia", 144.5);
		c.showDataOfCountry();// ScreenShot0
		System.out.println();

		EuropeanUnionCountry uec = new EuropeanUnionCountry();// default
		uec.showDataOfCountry();// ScreenShot1
		System.out.println();

		EuropeanCountry ec1 = new EuropeanCountry("Moldova", 3.35, "Chișinău", "Europa", "Republică parlamentară",
				"Igor Dodon", 33.846, "MDL");
		ec1.showDataOfCountry();// ScreenShot2
		System.out.println();

		EuropeanCountry ec2 = new EuropeanCountry("Austria", "Euro");
		ec2.showDataOfCountry();// ScreenShot3
		System.out.println();

		EuropeanCountry ec3 = new EuropeanCountry("Ucraina", 603.628, "UAH");
		ec3.showDataOfCountry();// ScreenShot4
		System.out.println();

		EuropeanUnionCountry euc1 = new EuropeanUnionCountry("Franța", 66.628, "Paris", "Europa",
				"Republică semi-prezidențială", "Emmanuel Macron", 674.843, "Euro", 1958);
		euc1.showDataOfCountry();// ScreenShot5
		System.out.println();

		EuropeanUnionCountry euc2 = new EuropeanUnionCountry("România", 19.64, 238.397, "RON", 2007);
		euc2.showDataOfCountry();// ScreenShot6
		System.out.println();

		EuropeanUnionCountry euc3 = new EuropeanUnionCountry("Germania", 225.1, "EUR", 1958);
		euc3.showDataOfCountry();// ScreenShot7
		System.out.println();

		AsianCountry asc1 = new AsianCountry("Japonia", 377.973, "Yen");
		asc1.showDataOfCountry();// ScreenShot8

	}
}
