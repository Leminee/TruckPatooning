package de.truckplatooning.controlservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;

@Controller
public class Control {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL ="http://REGISTRATIONSERVICE/api/registration/";

    @GetMapping
    public String showController() {

        return "controller";

    }

    @PostMapping("/acc")
    public String accelerate(HttpServletRequest request) {

        int value = Integer.parseInt(request.getParameter("acc-value"));

        restTemplate.put(BASE_URL + "acc/" + value, Truck.class);
        return "controller";

    }

    @PostMapping("/brake")
    public String brake(HttpServletRequest request) {

        int value = Integer.parseInt(request.getParameter("br-value"));
        restTemplate.put(BASE_URL + "br/" + value, Truck.class);

        return "controller";

    }

    @PostMapping("/stop")
    public String brake() {

        restTemplate.put(BASE_URL + "stop", Truck.class);

        return "controller";

    }
}
