package de.truckplatooning;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/status")
public class MonitoringController {

    @Autowired
    private final RestTemplate restTemplate;

    private final EurekaClient eurekaClient;
    private final String BASE_URL = "http://REGISTRATIONSERVICE/api/registration/";

    public MonitoringController(RestTemplate restTemplate, EurekaClient eurekaClient) {
        this.restTemplate = restTemplate;
        this.eurekaClient = eurekaClient;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Truck[] getTrucks(){

        return restTemplate.getForObject(BASE_URL +"trucks", Truck[].class);

    }

    @GetMapping(path = "/position/{position}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Truck getStatusByPosition(@PathVariable int position) {

        return restTemplate.getForObject(BASE_URL +"position/" + position, Truck.class);

    }

    @GetMapping(path = "/platoon", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPlatoon() {
        String object = restTemplate.getForObject(BASE_URL + "amount", String.class);
        return "Anzahl der LKWs im Platoon: " + object;

    }

    @GetMapping(path = "/clients", produces= MediaType.APPLICATION_JSON_VALUE)
    public Applications getApp() {

        return eurekaClient.getApplications();
    }

}
