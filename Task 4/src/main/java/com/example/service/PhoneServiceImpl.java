package com.example.service;

import com.example.model.SmartPhones;
import com.example.model.Brand;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    private final List<SmartPhones> phoneList = new ArrayList<>();

    public PhoneServiceImpl() {
        // Initialize with some dummy data
        Brand samsung = new Brand("Samsung");
        Brand apple = new Brand("Apple");
        Brand oneplus = new Brand("OnePlus");
        Brand vivo = new Brand("Vivo");

        // Add 6 Samsung phones
        phoneList.add(new SmartPhones("Galaxy S21", 2021, 4.8, "v1.0", samsung,
                "One UI", "2.1", "Triple Camera", 6.2,
                "Bluetooth 5.0", "5G", true));

        phoneList.add(new SmartPhones("Galaxy Note 20", 2020, 4.7, "v2.0", samsung,
                "One UI", "2.5", "Quad Camera", 6.7,
                "Bluetooth 5.1", "5G", true));

        phoneList.add(new SmartPhones("Galaxy S22 Ultra", 2022, 4.8, "v1.0", samsung,
                "One UI", "2.1", "Triple Camera", 6.5,
                "Bluetooth 5.0", "5G", true));

        phoneList.add(new SmartPhones("Galaxy Note 10", 2017, 4.7, "v2.0", samsung,
                "One UI", "2.5", "Double Camera", 6.7,
                "Bluetooth 5.1", "5G", true));

        phoneList.add(new SmartPhones("Galaxy S4", 2013, 4.8, "v1.0", samsung,
                "One UI", "2.1", "Single Camera", 5.0,
                "Bluetooth 4.0", "4G", true));

        phoneList.add(new SmartPhones("Galaxy Note 5", 2015, 4.7, "v2.0", samsung,
                "One UI", "2.5", "Single Camera", 5.7,
                "Bluetooth 5.1", "5G", true));

        // Add 2 Apple phones
        phoneList.add(new SmartPhones("iPhone 13 Pro", 2021, 4.9, "v14.0", apple,
                "iOS", "14.0.1", "Triple Camera", 6.1,
                "Bluetooth 5.0", "4G", true));

        phoneList.add(new SmartPhones("iPhone 12", 2020, 4.7, "v13.0", apple,
                "iOS", "13.5", "Dual Camera", 6.1,
                "Bluetooth 5.0", "5G", true));

        // Add 2 OnePlus phones
        phoneList.add(new SmartPhones("OnePlus 9 Pro", 2021, 4.8, "OxygenOS 11", oneplus,
                "Android", "11", "Quad Camera", 6.7,
                "Bluetooth 5.2", "5G", true));

        phoneList.add(new SmartPhones("OnePlus 8T", 2020, 4.6, "OxygenOS 11", oneplus,
                "Android", "11", "Quad Camera", 6.55,
                "Bluetooth 5.1", "5G", true));

        // Add 2 Vivo phones
        phoneList.add(new SmartPhones("Vivo X60 Pro", 2021, 4.5, "Funtouch OS 11", vivo,
                "Android", "11", "Quad Camera", 6.56,
                "Bluetooth 5.1", "5G", true));

        phoneList.add(new SmartPhones("Vivo V21e", 2021, 4.3, "Funtouch OS 11", vivo,
                "Android", "11", "Dual Camera", 6.44,
                "Bluetooth 5.0", "4G", true));
        // Add more phones as needed
    }

    @Override
    public List<SmartPhones> getAllPhones() {
        return phoneList;
    }
}
