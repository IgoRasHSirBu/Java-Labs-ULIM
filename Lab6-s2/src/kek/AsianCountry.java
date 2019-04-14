package kek;

public class AsianCountry extends Country {

    private double area;
    private String currency;
    private final String CONTINENT = "Asia";

    AsianCountry() {//exemple de constructori
        area = 0.0;
        currency = "Unknown";
        super.setContinent(CONTINENT);
    }

     AsianCountry(String name, double population, String capital, String continent, String government, String leader, double area, String currency) {
        super(name, population, capital, continent, government, leader);
        if (currency.length() >= 3) {
            this.currency = currency.substring(0,3).toUpperCase();
        } else {
            this.currency = "Unknown";
        }
        if (area > 0) {
            this.area = area;
        }
        super.setContinent(CONTINENT);
    }

     AsianCountry(String name, double population, double area, String currency) {
        super(name, population);
        if (currency.length() >= 3) {
            this.currency = currency.substring(0,3).toUpperCase();
        } else {
            this.currency = "Unknown";
        }
        if (area > 0) {
            this.area = area;
        }
        super.setContinent(CONTINENT);
    }

     AsianCountry(String name, double area, String currency) {
        super(name);
        if (currency.length() >= 3) {
            this.currency = currency.substring(0,3).toUpperCase();
        } else {
            this.currency = "Unknown";
        }
        if (area > 0) {
            this.area = area;
        }
        super.setContinent(CONTINENT);
    }

    //setters
    public void setArea(double area) {
        if (area > 0) {
            this.area = area;
        }
    }

    public void setCurrency(String currency) {
        if (currency.length() >= 3) {
            this.currency = currency.substring(0,3).toUpperCase();
        } else {
            this.currency = "Unknown";
        }
    }

    //getters
    public double getArea() {
        return area;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public void showDataOfCountry() {
        super.showDataOfCountry();
        System.out.print("Suprafața: " + this.area +" km\u00B2"+ "\nValuta: " + this.currency +'\n');
    }
}
