package md.country;

import java.util.ArrayList;

/**
 * Used for storing data for a European Union country object
 *
 * @author Fanncy
 */
public class EuropeanUnionCountry extends EuropeanCountry {

    private static final long serialVersionUID = 1L;
    private int yearMember;

    public EuropeanUnionCountry() {
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

    // setter
    public void setYearMember(int yearMember) {
        this.yearMember = yearMember;
    }

    // getter
    public int getYearMember() {
        return yearMember;
    }

    @Override
    public ArrayList<String> getDataOfCountry() {
        ArrayList<String> dataList = super.getDataOfCountry();
        dataList.add(Integer.toString(this.yearMember));
        return dataList;
    }
}
