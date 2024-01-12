package smartphone.compare;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<SmartPhone> phones = loadPhonesFromFile("phones.data");

        if (phones.isEmpty()) {
            System.out.println("No phones loaded. Exiting the application.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            // Displaying the menu
            System.out.println("\nMenu:");
            System.out.println("1. View a Phone");
            System.out.println("2. Compare Phones");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // View a single phone
                    viewSinglePhone(phones);
                    break;
                case 2:
                    // Compare two phones
                    comparePhones(phones);
                    break;
                case 3:
                    // Exit the application
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        } while (choice != 3);
    }

    // Method to display information about a single SmartPhone
    private static void viewSinglePhone(List<SmartPhone> phones) {
        // Print a list of available phone brands
        System.out.println("Available phone brands:");
        for (int i = 0; i < phones.size(); i++) {
            System.out.println((i + 1) + ". " + phones.get(i).getName());
        }

        // Prompt the user to choose a brand by typing the corresponding number
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a phone brand (type the number):");
        int selectedBrandIndex = scanner.nextInt();

        // Validate user input
        if (selectedBrandIndex >= 1 && selectedBrandIndex <= phones.size()) {
            // Get the selected phone based on the user's choice
            SmartPhone selectedPhone = phones.get(selectedBrandIndex - 1);

            // Display information about the selected phone
            System.out.println("You have selected the following phone:");
            StringBuilder result = new StringBuilder();
            displaySmartPhoneInfo(selectedPhone,result);
        } else {
            System.out.println("Invalid selection. Please choose a valid number.");
        }
    }

    // Method to compare two SmartPhones
     public static void comparePhones(List<SmartPhone> phones) {
        // Print a list of available phone brands
        System.out.println("Available phone brands:");
        for (int i = 0; i < phones.size(); i++) {
            System.out.println((i + 1) + ". " + phones.get(i).getName());
        }

        // Prompt the user to choose two phones to compare
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Choose the first phone to compare (type the number):");
        int firstPhoneIndex = scanner.nextInt();
        System.out.println("Choose the second phone to compare (type the number):");
        int secondPhoneIndex = scanner.nextInt();

        // Validate user input
        if (firstPhoneIndex >= 1 && firstPhoneIndex <= phones.size()
                && secondPhoneIndex >= 1 && secondPhoneIndex <= phones.size()
                && firstPhoneIndex != secondPhoneIndex) {

            // Get the selected phones based on the user's choice
            SmartPhone firstPhone = phones.get(firstPhoneIndex - 1);
            SmartPhone secondPhone = phones.get(secondPhoneIndex - 1);

            // Display information about the selected phones
            System.out.println();
            StringBuilder result = new StringBuilder();
            System.out.println("You have selected the following phones for comparison:");
            displaySmartPhoneInfo(firstPhone,result);
            System.out.println("\n---vs---\n");
            displaySmartPhoneInfo(secondPhone,result);
        } else {
            System.out.println("Invalid selection. Please choose two different valid numbers.");
        }
    }

    // Helper method to display information about a SmartPhone
    static void displaySmartPhoneInfo(SmartPhone smartPhone,StringBuilder result) {
        System.out.println("SmartPhone Name: " + smartPhone.getName());
        System.out.println("Release Year: " + smartPhone.getReleaseYear());
        System.out.println("User Rating: " + smartPhone.getUserRating());
        System.out.println("Version: " + smartPhone.getVersion());
        System.out.println("Brand: " + smartPhone.getBrand());
        System.out.println("Software: " + smartPhone.getSoftware());
        System.out.println("Software Version: " + smartPhone.getSoftwareVersion());
        System.out.println("Camera: " + smartPhone.getCamera());
        System.out.println("Screen Size: " + smartPhone.getScreenSize() + " inches");
        System.out.println("Bluetooth Version: " + smartPhone.getBluetoothVersion());
        System.out.println("Network: " + smartPhone.getNetwork());
        System.out.println("WiFi: " + (smartPhone.isWifi() ? "Yes" : "No"));
    }
    // Load phones from a file
     static List<SmartPhone> loadPhonesFromFile(String filename) {
        List<SmartPhone> phones = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] phoneData = line.split(",");
                if (phoneData.length == 12) { // Assuming 13 fields in the data file
                    SmartPhone phone = new SmartPhone(
                            phoneData[0], Integer.parseInt(phoneData[1]),
                            Double.parseDouble(phoneData[2]), phoneData[3],
                            phoneData[4], phoneData[5], phoneData[6],
                            phoneData[7], Double.parseDouble(phoneData[8]),
                            phoneData[9], phoneData[10], Boolean.parseBoolean(phoneData[11])
                    );
                    phones.add(phone);
                } else {
                    System.out.println("Invalid data format in the file: " + filename);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        return phones;
    }
}
