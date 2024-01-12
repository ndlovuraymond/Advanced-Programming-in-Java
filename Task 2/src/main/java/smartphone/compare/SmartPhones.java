package smartphone.compare;

import jakarta.persistence.*;

@Entity(name = "SmartPhones")
@Table(name = "SmartPhones")
public class SmartPhones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "user_rating")
    private double userRating;

    @Column(name = "version")
    private String version;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "software")
    private String software;

    @Column(name = "software_version")
    private String softwareVersion;

    @Column(name = "camera")
    private String camera;

    @Column(name = "screen_size")
    private double screenSize;

    @Column(name = "bluetooth_version")
    private String bluetoothVersion;

    @Column(name = "network")
    private String network;

    @Column(name = "wifi")
    private boolean wifi;

    public SmartPhones(){}
    public SmartPhones(String name, int releaseYear, double userRating, String version, Brand brand,
                       String software, String softwareVersion, String camera, double screenSize,
                       String bluetoothVersion, String network, boolean wifi) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.userRating = userRating;
        this.version = version;
        this.brand = brand;
        this.software = software;
        this.softwareVersion = softwareVersion;
        this.camera = camera;
        this.screenSize = screenSize;
        this.bluetoothVersion = bluetoothVersion;
        this.network = network;
        this.wifi = wifi;
    }
    // toString method for easy printing
    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseYear=" + releaseYear +
                ", userRating=" + userRating +
                ", version='" + version + '\'' +
                ", brand=" + brand +
                ", software='" + software + '\'' +
                ", softwareVersion='" + softwareVersion + '\'' +
                ", camera='" + camera + '\'' +
                ", screenSize=" + screenSize +
                ", bluetoothVersion='" + bluetoothVersion + '\'' +
                ", network='" + network + '\'' +
                ", wifi=" + wifi +
                '}';
    }

    public void setSoftwareVersion(String softwareversion) {
        this.softwareVersion = softwareversion;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSoftwareVersion() {
        return this.softwareVersion;
    }

    public String getSoftware() {
        return this.software;
    }

    public String getCamera() {
        return this.camera;
    }

    public double getScreenSize() {
        return this.screenSize;
    }

    public String getBluetoothVersion() {
        return this.bluetoothVersion;
    }

    public boolean isWifi() {
        return this.wifi;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public double getUserRating() {
        return this.userRating;
    }

    public String getVersion() {
        return this.version;
    }

    public String getNetwork() {
        return this.network;
    }
}

