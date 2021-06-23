package de.truckplatooning;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Controller
public class Monitoring {

    private final RestTemplate restTemplate;

    public Monitoring(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/monitor")
    public String getStatus(Model model) {

        String BASE_URL = "http://REGISTRATIONSERVICE/api/registration/";
        model.addAttribute("truck", restTemplate.getForObject(BASE_URL + "trucks", Truck[].class));

        return "monitor";
    }
}
