package smartphone.compare;

public class Phone implements Device {
    private String name;
    private int releaseYear;
    private double userRating;
    private String version;
    private String brand;

    // Constructor
    public Phone(String name, int releaseYear, double userRating, String version, String brand) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.userRating = userRating;
        this.version = version;
        this.brand = brand;
    }

    // Implementing methods from the Device interface
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public double getUserRating() {
        return userRating;
    }

    @Override
    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    // Additional methods or constructor if needed
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Example usage
    public static void main(String[] args) {
        // Creating an instance of Phone
        Phone myPhone = new Phone("ExamplePhone", 2022, 4.5, "v1.0", "ExampleBrand");

        // Displaying information about the phone
        System.out.println("Phone Name: " + myPhone.getName());
        System.out.println("Release Year: " + myPhone.getReleaseYear());
        System.out.println("User Rating: " + myPhone.getUserRating());
        System.out.println("Version: " + myPhone.getVersion());
        System.out.println("Brand: " + myPhone.getBrand());
    }
}

