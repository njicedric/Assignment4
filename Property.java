

/**
 * Represents a rental property
 */
public class Property {
    private String propertyName, city, owner;
    private double rentAmount;
    private Plot plot;

    public Property(String name, String city, double rent, String owner) {
        this(name, city, rent, owner, 0, 0, 1, 1);
    }

    public Property(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        this.propertyName = name;
        this.city = city;
        this.rentAmount = rent;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property other) {
        this.propertyName = other.propertyName;
        this.city = other.city;
        this.rentAmount = other.rentAmount;
        this.owner = other.owner;
        this.plot = new Plot(other.plot);
    }

    public String getPropertyName() { return propertyName; }
    public String getCity() { return city; }
    public double getRentAmount() { return rentAmount; }
    public String getOwner() { return owner; }
    public Plot getPlot() { return plot; }

    public void setPropertyName(String name) { this.propertyName = name; }
    public void setCity(String city) { this.city = city; }
    public void setRentAmount(double rent) { this.rentAmount = rent; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setPlot(Plot plot) { this.plot = plot; }

    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}