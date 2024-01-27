package com.example.controller;

import com.example.model.SmartPhones;
import com.example.service.PhoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PhoneController {

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/phones")
    public String getAllPhones(Model model) {
        List<SmartPhones> phones = phoneService.getAllPhones();
        model.addAttribute("phones", phones);
        return "phone-view";
    }

    @GetMapping("/phones/compare/{selectedName}/{comparisonName}")
    public String compareSelectedPhones(
            @PathVariable String selectedName,
            @PathVariable String comparisonName,
            Model model
    ) {
        SmartPhones selectedPhone = phoneService.getAllPhones().stream()
                .filter(phone -> phone.getName().equals(selectedName))
                .findFirst()
                .orElse(null);

        SmartPhones comparisonPhone = phoneService.getAllPhones().stream()
                .filter(phone -> phone.getName().equals(comparisonName))
                .findFirst()
                .orElse(null);

        List<SmartPhones> allPhones = phoneService.getAllPhones();
        model.addAttribute("selectedPhone", selectedPhone);
        model.addAttribute("comparisonPhone", comparisonPhone);
        model.addAttribute("allPhones", allPhones);

        return "phone-compare";
    }
}
