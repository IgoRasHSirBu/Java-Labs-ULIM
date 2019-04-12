package md.country;

public class EuropeanUnionCountry extends EuropeanCountry {

	private int yearMember;

	public EuropeanUnionCountry() {// exemple de constructori
		yearMember = 0;
	}

	public EuropeanUnionCountry(String name, double population, String capital, String continent, String government,
			String leader, double area, String currency, int yearMember) {
		super(name, population, capital, continent, government, leader, area, currency);
		if (yearMember > 1957) {
			this.yearMember = yearMember;
		} else {
			this.yearMember = 0;
		}
	}

	public EuropeanUnionCountry(String name, double population, double area, String currency, int yearMember) {
		super(name, population, area, currency);
		if (yearMember > 1957) {
			this.yearMember = yearMember;
		} else {
			this.yearMember = 0;
		}
	}

	public EuropeanUnionCountry(String name, double area, String currency, int yearMember) {
		super(name, area, currency);
		if (yearMember > 1957) {
			this.yearMember = yearMember;
		} else {
			this.yearMember = 0;
		}
	}

	public EuropeanUnionCountry(double area, String currency, int yearMember) {
		super(area, currency);
		if (yearMember > 1957) {
			this.yearMember = yearMember;
		} else {
			this.yearMember = 0;
		}
	}

	public EuropeanUnionCountry(String name, int yearMember) {
		super(name);
		if (yearMember > 1957) {
			this.yearMember = yearMember;
		} else {
			this.yearMember = 0;
		}
	}

	public EuropeanUnionCountry(int yearMember) {
		if (yearMember > 1957) {
			this.yearMember = yearMember;
		} else {
			this.yearMember = 0;
		}
	}

	// setter
	public void setYearMember(int yearMember) {
		this.yearMember = yearMember;
	}

	// getter
	public int getYearMember() {
		return yearMember;
	}

	@Override
	public void showDataOfCountry() {
		super.showDataOfCountry();
		System.out.print("Aderare la UE " + this.yearMember + '\n');
	}
}
