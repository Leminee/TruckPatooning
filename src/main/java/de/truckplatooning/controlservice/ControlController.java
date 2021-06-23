package de.truckplatooning.controlservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/control")
public class ControlController {

    @Autowired
    private RestTemplate restTemplate;
    private final String BASE_URL = "http://REGISTRATIONSERVICE/api/registration/";


    @PutMapping(path = "/acc/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void acc(@PathVariable int value) {

        restTemplate.put(BASE_URL + "acc/" + value, Truck.class);

    }

   @PutMapping(path = "/brake/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void brake(@PathVariable int value) {

         restTemplate.put(BASE_URL + "br/" + value, Truck.class);
    }

    @PutMapping(path = "/stop", produces = MediaType.APPLICATION_JSON_VALUE)
    public void stop() {

        restTemplate.put(BASE_URL + "stop", Truck.class);
    }


    //methode wird an rabbitmq geschickt
    //regisserver liest die geschickte Nachricht
}
