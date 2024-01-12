package smartphone.compare;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.awt.*;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.*;

public class PhoneSwingApp extends JFrame {

    private static final Logger LOGGER = Logger.getLogger(PhoneSwingApp.class.getName());

    private DefaultListModel<SmartPhones> phoneListModel;
    private JList<SmartPhones> phoneList;

    List<String> names = new ArrayList<String>();


    public PhoneSwingApp() {
        initializeUI();
    }

    private String displaySmartPhoneInfo(SmartPhones phone) {
        String phoneDetails = "SmartPhone Name: " + phone.getName()+"\n"
        +"Release Year: " + phone.getReleaseYear()+"\n"
        +"User Rating: " + phone.getUserRating()+"\n"
        +"Version: " + phone.getVersion()+"\n"
        +"Software: " + phone.getSoftware()+"\n"
        +"Software Version: " + phone.getSoftwareVersion()+"\n"
        +"Camera: " + phone.getCamera()+"\n"
        +"Screen Size: " + phone.getScreenSize() + " inches"+"\n"
        +"Bluetooth Version: " + phone.getBluetoothVersion()+"\n"
        +"Network: " + phone.getNetwork()+"\n"
        +"WiFi: " + (phone.isWifi() ? "Yes" : "No")+"\n";
        return phoneDetails;
    }
    private void initializeUI() {
        setTitle("Phone Swing Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JButton viewPhoneButton = new JButton("View Phone");
        JButton comparePhonesButton = new JButton("Compare Phones");
        JButton exitButton = new JButton("Exit");

        viewPhoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPhone();
            }
        });

        comparePhonesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comparePhones();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        phoneListModel = new DefaultListModel<SmartPhones>();
        phoneList = new JList<>(phoneListModel);
        phoneList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        mainPanel.add(new JScrollPane(phoneList));
        mainPanel.add(viewPhoneButton);
        mainPanel.add(comparePhonesButton);
        mainPanel.add(exitButton);

        add(mainPanel);
        setLocationRelativeTo(null);

        // Initialize the UI with phone data asynchronously
        new LoadPhoneDataWorker().execute();
    }

    private void viewPhone() {
        SmartPhones selectedPhone = phoneList.getSelectedValue();
        if (selectedPhone != null) {
            // Call your logic to view the phone based on the selected phone object
            JOptionPane.showMessageDialog(null, "This is the selected phone: \n" + displaySmartPhoneInfo(selectedPhone));
        } else {
            JOptionPane.showMessageDialog(null, "No phone selected. Please select a phone.");
        }
    }

    private void comparePhones() {
        int[] selectedIndices = phoneList.getSelectedIndices();

        if (selectedIndices.length == 2) {
            SmartPhones firstPhone = phoneListModel.get(selectedIndices[0]);
            SmartPhones secondPhone = phoneListModel.get(selectedIndices[1]);

            JOptionPane.showMessageDialog(null, "Comparing Phones: " + firstPhone.getName() + " and " + secondPhone.getName()
            +"\n" + displaySmartPhoneInfo(firstPhone) + "---vs---\n" + displaySmartPhoneInfo(secondPhone));
        } else {
            JOptionPane.showMessageDialog(null, "Please select exactly 2 phones to compare.");
        }
    }

    // Asynchronous data retrieval using SwingWorker
    private class LoadPhoneDataWorker extends SwingWorker<List<SmartPhones>, Void> {
        @Override
        protected List<SmartPhones> doInBackground() throws Exception {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<SmartPhones> cr = cb.createQuery(SmartPhones.class);
            Root<SmartPhones> root = cr.from(SmartPhones.class);
            cr.select(root);

            Query<SmartPhones> query = session.createQuery(cr);
            List<SmartPhones> dbPhones = query.getResultList();
            return dbPhones;
        }

        @Override
        protected void done() {
            try {
                List<SmartPhones> phones = get();
                phoneListModel.clear();
                for (SmartPhones phone : phones) {
                    phoneListModel.addElement(phone);
                }
            } catch (InterruptedException | ExecutionException ex) {
                LOGGER.log(Level.SEVERE, "Error while loading phone data", ex);
                JOptionPane.showMessageDialog(null, "An error occurred while loading phone data. Please check logs.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PhoneSwingApp phoneSwingApp = new PhoneSwingApp();
                phoneSwingApp.setVisible(true);
            }
        });
    }
}
