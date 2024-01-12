package smartphone.compare;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class Tests {

    @Test
    public void testLoadPhonesFromFile() {
        List<SmartPhone> phones = Main.loadPhonesFromFile("phones.data");

        Assertions.assertNotNull(phones);
        Assertions.assertFalse(phones.isEmpty());

        // Assuming there are at least two phones in the file
        SmartPhone phone1 = phones.get(0);
        SmartPhone phone2 = phones.get(1);

        Assertions.assertNotNull(phone1);
        Assertions.assertNotNull(phone2);

        Assertions.assertNotEquals(phone1, phone2);
    }

    @Test
    public void testComparePhones() {
        List<SmartPhone> phones = Main.loadPhonesFromFile("phones.data");

        Assertions.assertNotNull(phones);
        Assertions.assertFalse(phones.isEmpty());

        // Assuming there are at least two phones in the file
        SmartPhone phone1 = phones.get(0);
        SmartPhone phone2 = phones.get(1);

        Assertions.assertNotNull(phone1);
        Assertions.assertNotNull(phone2);

        String expectedComparison =
                        "SmartPhone Name: Samsung Galaxy S21\n" +
                        "Release Year: 2021\n" +
                        "User Rating: 4.7\n" +
                        "Version: v1.0\n" +
                        "Brand: Samsung\n" +
                        "Software: Android\n" +
                        "Software Version: 11.0\n" +
                        "Camera: Triple Camera\n" +
                        "Screen Size: 6.2 inches\n" +
                        "Bluetooth Version: Bluetooth 5.1\n" +
                        "Network: 5G\n" +
                        "WiFi: Yes\n" +
                        "\n" +
                        "---vs---\n" +
                        "\n" +
                        "SmartPhone Name: Apple iPhone 13\n" +
                        "Release Year: 2021\n" +
                        "User Rating: 4.9\n" +
                        "Version: v14.0\n" +
                        "Brand: Apple\n" +
                        "Software: iOS\n" +
                        "Software Version: 15.0\n" +
                        "Camera: Dual Camera\n" +
                        "Screen Size: 6.1 inches\n" +
                        "Bluetooth Version: Bluetooth 5.0\n" +
                        "Network: 5G\n" +
                        "WiFi: Yes\n";

        Assertions.assertEquals(expectedComparison, getComparisonResult(phone1, phone2));
    }

    // Helper method to get the comparison result as a string
    private String getComparisonResult(SmartPhone phone1, SmartPhone phone2) {
        StringBuilder result = new StringBuilder();
        result.append("SmartPhone Name: ").append(phone1.getName()).append("\n");
        result.append("Release Year: ").append(phone1.getReleaseYear()).append("\n");
        result.append("User Rating: ").append(phone1.getUserRating()).append("\n");
        result.append("Version: ").append(phone1.getVersion()).append("\n");
        result.append("Brand: ").append(phone1.getBrand()).append("\n");
        result.append("Software: ").append(phone1.getSoftware()).append("\n");
        result.append("Software Version: ").append(phone1.getSoftwareVersion()).append("\n");
        result.append("Camera: ").append(phone1.getCamera()).append("\n");
        result.append("Screen Size: ").append(phone1.getScreenSize()).append(" inches").append("\n");
        result.append("Bluetooth Version: ").append(phone1.getBluetoothVersion()).append("\n");
        result.append("Network: ").append(phone1.getNetwork()).append("\n");
        result.append("WiFi: ").append(phone1.isWifi() ? "Yes" : "No").append("\n");
        result.append("\n---vs---\n\n");
        result.append("SmartPhone Name: ").append(phone2.getName()).append("\n");
        result.append("Release Year: ").append(phone2.getReleaseYear()).append("\n");
        result.append("User Rating: ").append(phone2.getUserRating()).append("\n");
        result.append("Version: ").append(phone2.getVersion()).append("\n");
        result.append("Brand: ").append(phone2.getBrand()).append("\n");
        result.append("Software: ").append(phone2.getSoftware()).append("\n");
        result.append("Software Version: ").append(phone2.getSoftwareVersion()).append("\n");
        result.append("Camera: ").append(phone2.getCamera()).append("\n");
        result.append("Screen Size: ").append(phone2.getScreenSize()).append(" inches").append("\n");
        result.append("Bluetooth Version: ").append(phone2.getBluetoothVersion()).append("\n");
        result.append("Network: ").append(phone2.getNetwork()).append("\n");
        result.append("WiFi: ").append(phone2.isWifi() ? "Yes" : "No").append("\n");
        System.out.print(result);
        return result.toString();
    }
}

