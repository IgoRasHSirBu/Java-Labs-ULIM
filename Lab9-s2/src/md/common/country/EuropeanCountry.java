package md.common.country;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Used for storing data for a European country object
 *
 * @author Fanncy
 */
public class EuropeanCountry extends Country {
	private static final long serialVersionUID = 1L;
	private double area;
	private String currency;
	private final String CONTINENT = "Europa";

	public EuropeanCountry() {
		area = 0.0;
		currency = "Unknown";
		super.setContinent(CONTINENT);
	}

	public EuropeanCountry(String name, double population, String capital, String continent, String government,
			String leader, double area, String currency) {
		super(name, population, capital, continent, government, leader);
		if (currency.length() >= 3) {
			this.currency = currency.substring(0, 3).toUpperCase();
		} else {
			this.currency = "Unknown";
		}
		if (area > 0) {
			this.area = area;
		} else {
			this.area = 0.0;
		}
		super.setContinent(CONTINENT);
	}

	// setters
	public void setArea(double area) {
		if (area > 0) {
			this.area = area;
		}
	}

	public void setCurrency(String currency) {
		if (currency.length() >= 3) {
			this.currency = currency.substring(0, 3).toUpperCase();
		} else {
			this.currency = "Unknown";
		}
	}

	// getters
	public double getArea() {
		return area;
	}

	public String getCurrency() {
		return currency;
	}

	@Override
	public ArrayList<String> getDataOfCountry() {
		ArrayList<String> dataList = super.getDataOfCountry();
		dataList.addAll(Arrays.asList(Double.toString(this.area), this.currency));
		return dataList;
	}
}
