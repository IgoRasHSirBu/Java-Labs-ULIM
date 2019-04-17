package md.country;

import java.io.Serializable;

/**
 * Used for storing data for a specific country object
 *
 * @author Fanncy
 */
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private double population;
    private String capital;
    private String continent;
    private String government;
    private String leader;

    // Constructors
    public Country() {
        this.name = this.capital = this.continent = this.government = this.leader = "Unknown";
    }

    public Country(String name, double population, String capital, String continent, String government, String leader) {
        if (name.length() >= 3) {
            this.name = name.substring(0, 1).toUpperCase() + name.substring(1, 3);
        } else {
            this.name = "Unknown";
        }
        if (population > 0) {
            this.population = population;
        } else {
            System.out.println("Unknown Population!");
        }
        if (capital.length() < 3) {
            this.capital = "Unknown Capital";
        } else {
            this.capital = capital;
        }
        if (continent.length() < 3) {
            this.continent = "Unknown Continent";
        } else {
            this.continent = continent;
        }
        if (government.length() < 3) {
            this.government = "Unknown Government";
        } else {
            this.government = government;
        }
        if (leader.length() < 3) {
            this.leader = "Unknown Leader";
        } else {
            this.leader = leader;
        }
    }

    // setters
    public void setName(String name) {
        if (name.length() > 3) {
            this.name = name.substring(0, 1).toUpperCase() + name.substring(1, 3);
        } else {
            this.name = name.substring(0, 1).toUpperCase();
        }
    }

    public void setPopulation(double population) {
        if (population > 0) {
            this.population = population;
        } else {
            System.out.println("Unknown Population!");
        }
    }

    public void setCapital(String capital) {
        if (capital.length() < 3) {
            this.capital = "Unknown Capital";
        } else {
            this.capital = capital;
        }
    }

    public void setContinent(String continent) {
        if (continent.length() < 3) {
            this.continent = "Unknown Continent";
        } else {
            this.continent = continent;
        }
    }

    public void setGovernment(String government) {
        if (government.length() < 3) {
            this.government = "Unknown Government";
        } else {
            this.government = government;
        }
    }

    public void setLeader(String leader) {
        if (leader.length() < 3) {
            this.leader = "Unknown Leader";
        } else {
            this.leader = leader;
        }
    }

    // getters
    public String getName() {
        return this.name;
    }

    public double getPopulation() {
        return this.population;
    }

    public String getCapital() {
        return this.capital;
    }

    public String getContinent() {
        return this.continent;
    }

    public String getGovernment() {
        return this.government;
    }

    public String getLeader() {
        return this.leader;
    }

    // afiseaza toate datele
    public void showDataOfCountry() {
        System.out.print("Țara: " + this.name + "\nContinentul: " + this.continent + "\nCapitala: " + this.capital
                + "\nConducător " + this.leader + "\nFormă de guvernare: " + this.government + "\nPopulație: "
                + this.population + " Mln\n");
    }
}
