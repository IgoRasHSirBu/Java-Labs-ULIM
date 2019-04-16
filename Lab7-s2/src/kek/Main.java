package kek;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TimeZone;

/**
 * Provides examples of using ArrayList and LinkedList also Comparator for
 * sorting List
 * 
 * @author Fanncy
 *
 */
public class Main {

	public static void main(String[] args) {

		ArrayList<EuropeanUnionCountry> countryList = new ArrayList<>();

		// creating an instance of calendar
		Calendar calendar = Calendar.getInstance();

		// displaying current date
		System.out.println("----------------------------------------------------");// ss-1-
		System.out.println("Data curentă");
		System.out.println(calendar.getTime());
		System.out.println("Fusul orar: " + calendar.getTimeZone().getDisplayName());
		System.out.println("Anul curent:  " + calendar.get(Calendar.YEAR));
		System.out.println("Luna curentă: " + (calendar.get(Calendar.MONTH) + 1));// 0 = December
		System.out.println("Ziua curentă: " + calendar.get(Calendar.DATE));

		// setting new date
		int year = 1999;
		int month = Calendar.AUGUST;// == 7
		int date = 17;
		// setting new date
		calendar.set(year, month, date);
		System.out.println("----------------------------------------------------");// ss-2-
		System.out.println("Data schimbată");
		System.out.println(calendar.getTime());
		System.out.println("Fusul orar: " + calendar.getTimeZone().getDisplayName());
		System.out.println("Anul schimbat este:  " + calendar.get(Calendar.YEAR));
		System.out.println("Luna schimbată este: " + (calendar.get(Calendar.MONTH) + 1));
		System.out.println("Ziua schimbată este: " + calendar.get(Calendar.DATE));

		calendar.add(Calendar.DATE, 3);
		calendar.add(Calendar.MONTH, 7);
		calendar.add(Calendar.YEAR, 7);
		TimeZone myTimeZone = TimeZone.getTimeZone("UTC");
		calendar.setTimeZone(myTimeZone);// set time zone to UTC
		System.out.println("----------------------------------------------------");// ss-3-
		System.out.println("Data schimbată");
		System.out.println(calendar.getTime());
		System.out.println("Fusul orar schimbat: " + calendar.getTimeZone().getDisplayName());
		System.out.println("Anul schimbat  după 7 ani:  " + calendar.get(Calendar.YEAR));
		System.out.println("Luna schimbată după 7 luni: " + (calendar.get(Calendar.MONTH) + 1)); // 0 = December
		System.out.println("Ziua schimbată după 3 zile: " + calendar.get(Calendar.DATE));

		System.out.println("----------------------------------------------------");// ss-4-
		GregorianCalendar myDate = new GregorianCalendar(1999, Calendar.AUGUST, Calendar.THURSDAY);// my birth date
		calendar.clear();// clear date
		calendar.set(2007, Calendar.MARCH, Calendar.THURSDAY * 4); // set brother birth day
		GregorianCalendar brotherDate = (GregorianCalendar) calendar.clone(); // clone date

		// Format date
		System.out.println("Ziua de naștere a fratelui meu: " + brotherDate.get(Calendar.DATE) + "."
				+ (brotherDate.get(Calendar.MONTH) + 1) + "." + brotherDate.get(Calendar.YEAR));

		SimpleDateFormat formatterDate = new SimpleDateFormat("dd.MM.yyyy");// Format date using a SimpleDateFormat obj
		System.out.println("Ziua mea de naștere: " + formatterDate.format(myDate.getTime()));

		int res = myDate.compareTo(brotherDate);
		switch (res) {
		case 1:
			System.out.println("Fratele meu este mai mare ca mine!");
			break;
		case -1:
			System.out.println("Fratele meu este mai mic ca mine!");
			break;
		case 0:
			System.out.println("Suntem frați Gemeni !!");
		}

		// creating instances of EuropeanUnionCountry
		EuropeanUnionCountry euc1 = new EuropeanUnionCountry("Franța", 66.628, "Paris", "Europa",
				"Republică semi-prezidențială", "Emmanuel Macron", 674.843, "Euro", 1958);
		// adding to an ArrayList
		countryList.add(euc1);

		EuropeanUnionCountry euc2 = new EuropeanUnionCountry("România", 19.64, 238.397, "RON", 2007);
		countryList.add(euc2);

		EuropeanUnionCountry euc3 = new EuropeanUnionCountry("Germania", 225.1, "EUR", 1958);
		countryList.add(euc3);

		// displaying years since joining the EU
		System.out.println("----------------------------------------------------");// ss-5-
		Calendar currentDate = Calendar.getInstance();
		for (EuropeanUnionCountry euroCountry : countryList) {
			System.out.println("Țara: " + euroCountry.getName());
			System.out.println("Ani trecuți din momentul aderarii la UE: "
					+ (currentDate.get(Calendar.YEAR) - euroCountry.getYearMember()) + " ani");
			System.out.println("----------------------------------------------------");
		}

	}
}
