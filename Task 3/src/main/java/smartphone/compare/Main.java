package smartphone.compare;

import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // Perform operations based on the menu
        int choice;
        do {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<SmartPhones> cr = cb.createQuery(SmartPhones.class);
            Root<SmartPhones> root = cr.from(SmartPhones.class);
            cr.select(root);

            Query<SmartPhones> query = session.createQuery(cr);
            List<SmartPhones> results = query.getResultList();

            printMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    getPhones();
                    viewPhone(session);
                    break;
                case 2:
                    getPhones();
                    comparePhones(session);
                    break;
                case 3:
                    getPhones();
                    deletePhone(session);
                    break;
                case 4:
                    getPhones();
                    updateSoftwareVersion(session);
                    break;
                case 5:
                    addPhone(session);
                    break;
                case 6:
                    importToDatabase(session);
                    break;
                case 7:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 7);
    }

    // Helper method to display information about a SmartPhone
    static void displaySmartPhoneInfo(SmartPhones phone) {
        System.out.println("SmartPhone Name: " + phone.getName());
        System.out.println("Release Year: " + phone.getReleaseYear());
        System.out.println("User Rating: " + phone.getUserRating());
        System.out.println("Version: " + phone.getVersion());
        System.out.println("Software: " + phone.getSoftware());
        System.out.println("Software Version: " + phone.getSoftwareVersion());
        System.out.println("Camera: " + phone.getCamera());
        System.out.println("Screen Size: " + phone.getScreenSize() + " inches");
        System.out.println("Bluetooth Version: " + phone.getBluetoothVersion());
        System.out.println("Network: " + phone.getNetwork());
        System.out.println("WiFi: " + (phone.isWifi() ? "Yes" : "No"));
    }

    private static void getPhones() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<SmartPhones> cr = cb.createQuery(SmartPhones.class);
        Root<SmartPhones> root = cr.from(SmartPhones.class);
        cr.select(root);

        Query<SmartPhones> query = session.createQuery(cr);
        List<SmartPhones> results = query.getResultList();
        // Initializing any variable to 0
        int i = 0;
        // If variable value is lesser than
        // value indicating size of List
        while (i < results.size()) {
            // Print element of list
            SmartPhones phone = results.get(i);
            System.out.println((i+1)+". "+phone.getName());
            // Increase variable count by 1
            i++;
        }
    }
    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. View a Phone");
        System.out.println("2. Compare Two Phones");
        System.out.println("3. Delete a Phone");
        System.out.println("4. Update Software Version");
        System.out.println("5. Add a Phone");
        System.out.println("6. Import phones from first task");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    static void viewPhone(Session session) {
        System.out.print("Enter the ID of the phone you want to view: ");
        Scanner scanner = new Scanner(System.in);
        int phoneId = scanner.nextInt();

        session.beginTransaction();
            List<SmartPhones> smartphones = session.createQuery("from SmartPhones", SmartPhones.class).list();

          try {
              SmartPhones smartphone = smartphones.get(phoneId - 1);
              if (smartphone != null) {
                  System.out.println("Phone details:");
                  displaySmartPhoneInfo(smartphone);
              } else {
                  System.out.println("Phone not found.");
              }
          } catch (Exception e) {
              System.out.println("Error Device Out of Index");
              session.close();
          }
    }

    private static void comparePhones(Session session) {
        System.out.print("Enter the ID of the first phone: ");
        Scanner scanner = new Scanner(System.in);
        int firstPhoneId = scanner.nextInt();

        System.out.print("Enter the ID of the second phone: ");
        int secondPhoneId = scanner.nextInt();

        session.beginTransaction();
        List<SmartPhones> smartphones = session.createQuery("from SmartPhones", SmartPhones.class).list();

        try {
            SmartPhones firstPhone = smartphones.get(firstPhoneId - 1);
            SmartPhones secondPhone = smartphones.get(secondPhoneId - 1);

            if (firstPhone != null && secondPhone != null) {
                System.out.println("Comparison:");
                System.out.println("Phone 1 details:");
                displaySmartPhoneInfo(firstPhone);
                System.out.println("Phone 2 details:");
                displaySmartPhoneInfo(secondPhone);
            } else {
                System.out.println("One or both phones not found.");
            }
        } catch (Exception e) {
            System.out.println("Error Device Out of Index");
            session.close();
        }
    }

    private static void deletePhone(Session session) {
        System.out.print("Enter the ID of the phone you want to delete: ");
        Scanner scanner = new Scanner(System.in);
        int phoneId = scanner.nextInt();

        session.beginTransaction();
        List<SmartPhones> smartphones = session.createQuery("from SmartPhones", SmartPhones.class).list();

        try {
            SmartPhones smartphone = smartphones.get(phoneId - 1);
            if (smartphone != null) {
                session.remove(smartphone);
                session.getTransaction().commit();
                System.out.println("Phone deleted successfully.");
            } else {
                System.out.println("Phone not found.");
            }
        } catch (Exception e) {
            System.out.println("Error Device Out of Index");
            session.close();
        }

    }

    private static void updateSoftwareVersion(Session session) {
        System.out.print("Enter the ID of the phone you want to update: ");
        Scanner scanner = new Scanner(System.in);
        int phoneId = scanner.nextInt();

        session.beginTransaction();
        List<SmartPhones> smartphones = session.createQuery("from SmartPhones", SmartPhones.class).list();

        try {
            SmartPhones smartphone = smartphones.get(phoneId - 1);
            if (smartphone != null) {
                System.out.print("Enter the new software version: ");
                String newSoftwareVersion = scanner.next();

                smartphone.setSoftwareVersion(newSoftwareVersion);
                session.getTransaction().commit();

                System.out.println("Software version updated successfully.");
            } else {
                System.out.println("Phone not found.");
            }
        } catch (Exception e) {
            System.out.println("Error Device Out of Index");
            session.close();
        }
    }

    static void addPhone(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the name of the new phone: ");
            String name = scanner.nextLine();

            System.out.print("Enter the release year of the new phone: ");
            int releaseYear = scanner.nextInt();

            System.out.print("Enter the user rating of the new phone: ");
            double userRating = scanner.nextDouble();

            System.out.print("Enter the version of the new phone: ");
            String version = scanner.next();

            System.out.print("Enter the screen size of the new phone: ");
            double screenSize = scanner.nextDouble();

            System.out.print("Enter the software of the new phone: ");
            String software = scanner.next();

            System.out.print("Enter the software version of the new phone: ");
            String softwareVersion = scanner.next();

            System.out.print("Enter the camera details of the new phone: ");
            String camera = scanner.next();

            String bluetoothVersion = "Bluetooth 5.2";
            String network = "1";
            boolean wifi = true;
            Brand brand = null;
            if (brand == null) {
                SmartPhones newPhone = new SmartPhones(name, releaseYear, userRating, version, brand, software,
                        softwareVersion, camera, screenSize, bluetoothVersion, network, wifi);

                session.beginTransaction();
                session.save(newPhone);
                session.getTransaction().commit();

                System.out.println("Phone added successfully.");
            }
        } catch (Exception e) {
            System.out.println("Failed to add phone please enter correct data:)");
            session.close();
        }
    }

    private static void importToDatabase(Session session) {
        List<SmartPhone> phones = loadPhonesFromFile("phones.data");
        for (int i = 0; i < phones.size(); i++) {
            SmartPhone currentPhone = phones.get(i);
            String name = currentPhone.getName();
            int releaseYear = currentPhone.getReleaseYear();
            double userRating = currentPhone.getUserRating();
            String version = currentPhone.getVersion();
            double screenSize = currentPhone.getScreenSize();
            String software = currentPhone.getSoftware();
            String softwareVersion = currentPhone.getSoftwareVersion();
            String camera = currentPhone.getCamera();
            String bluetoothVersion = currentPhone.getBluetoothVersion();
            String network = currentPhone.getNetwork();
            boolean wifi = currentPhone.isWifi();
            Brand brand = null;

            SmartPhones newPhone = new SmartPhones(name, releaseYear, userRating, version, brand, software,
                    softwareVersion, camera, screenSize, bluetoothVersion, network, wifi);

            session.beginTransaction();
            session.save(newPhone);
            session.getTransaction().commit();

            System.out.println("Phone added successfully.");
        }
    }
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
