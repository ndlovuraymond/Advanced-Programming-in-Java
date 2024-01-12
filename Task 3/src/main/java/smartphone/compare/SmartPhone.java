package smartphone.compare;

public class SmartPhone extends Phone {
    private String software;
    private String softwareVersion;
    private String camera;
    private double screenSize;
    private String bluetoothVersion;
    private String network;
    private boolean wifi;

    // Constructor
    public SmartPhone(String name, int releaseYear, double userRating, String version, String brand,
                      String software, String softwareVersion, String camera, double screenSize,
                      String bluetoothVersion, String network, boolean wifi) {
        super(name, releaseYear, userRating, version, brand);
        this.software = software;
        this.softwareVersion = softwareVersion;
        this.camera = camera;
        this.screenSize = screenSize;
        this.bluetoothVersion = bluetoothVersion;
        this.network = network;
        this.wifi = wifi;
    }

    public static void main(String[] args) {
        // Creating an instance of SmartPhone
        SmartPhone mySmartPhone = new SmartPhone("ExampleSmartPhone", 2023, 4.8,
                "v2.0", "SmartBrand", "Android", "10.0", "Dual Camera", 6.0,
                "Bluetooth 5.0", "4G LTE", true);

        // Displaying information about the smartphone
        System.out.println("SmartPhone Name: " + mySmartPhone.getName());
        System.out.println("Release Year: " + mySmartPhone.getReleaseYear());
        System.out.println("User Rating: " + mySmartPhone.getUserRating());
        System.out.println("Version: " + mySmartPhone.getVersion());
        System.out.println("Brand: " + mySmartPhone.getBrand());
        System.out.println("Software: " + mySmartPhone.getSoftware());
        System.out.println("Software Version: " + mySmartPhone.getSoftwareVersion());
        System.out.println("Camera: " + mySmartPhone.getCamera());
        System.out.println("Screen Size: " + mySmartPhone.getScreenSize() + " inches");
        System.out.println("Bluetooth Version: " + mySmartPhone.getBluetoothVersion());
        System.out.println("Network: " + mySmartPhone.getNetwork());
        System.out.println("WiFi: " + (mySmartPhone.isWifi() ? "Yes" : "No"));
    }

    // Getters and Setters for additional variables
    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getBluetoothVersion() {
        return bluetoothVersion;
    }

    public void setBluetoothVersion(String bluetoothVersion) {
        this.bluetoothVersion = bluetoothVersion;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }
}
