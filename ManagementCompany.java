

/**
 * Manages multiple properties
 */
/**
 * Manages properties with validation and reporting
 */
public class ManagementCompany {
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    private String name, taxID;
    private Property[] properties;
    private double mgmFeePer;
    private Plot plot;
    private int numberOfProperties;

    public ManagementCompany() {
        this("", "", 0, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(ManagementCompany other) {
        this(other.name, other.taxID, other.mgmFeePer, other.plot.getX(), other.plot.getY(), other.plot.getWidth(), other.plot.getDepth());
    }

    public int addProperty(Property property) {
        if (isPropertiesFull()) return -1;
        if (property == null) return -2;
        if (!plot.encompasses(property.getPlot())) return -3;
        for (Property p : properties)
            if (p != null && p.getPlot().overlaps(property.getPlot())) return -4;
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] == null) {
                properties[i] = new Property(property);
                numberOfProperties++;
                return i;
            }
        }
        return -1;
    }

    public void removeLastProperty() {
        for (int i = MAX_PROPERTY - 1; i >= 0; i--) {
            if (properties[i] != null) {
                properties[i] = null;
                numberOfProperties--;
                break;
            }
        }
    }

    public boolean isPropertiesFull() { return numberOfProperties >= MAX_PROPERTY; }
    public int getPropertiesCount() { return numberOfProperties; }
    public double getTotalRent() {
        double total = 0;
        for (Property p : properties) if (p != null) total += p.getRentAmount();
        return total;
    }

    public Property getHighestRentProperty() {
        int maxIndex = -1;
        double maxRent = 0;
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null && properties[i].getRentAmount() > maxRent) {
                maxRent = properties[i].getRentAmount();
                maxIndex = i;
            }
        }
        return maxIndex != -1 ? properties[maxIndex] : null;
    }

    public boolean isMangementFeeValid() { return mgmFeePer >= 0 && mgmFeePer <= 100; }

    // Getters and setters for name, taxID, etc.
    public String getName() { return name; }
    public String getTaxID() { return taxID; }
    public Property[] getProperties() { return properties; }
    public double getMgmFeePer() { return mgmFeePer; }
    public Plot getPlot() { return plot; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
        sb.append("______________________________________________________\n");
        for (Property p : properties) if (p != null) sb.append(p).append("\n");
        sb.append("______________________________________________________\n");
        sb.append("\n total management Fee: ").append(getTotalRent() * mgmFeePer / 100);
        return sb.toString();
    }
}