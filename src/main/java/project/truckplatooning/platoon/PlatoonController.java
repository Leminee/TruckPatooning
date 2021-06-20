package project.truckplatooning.platoon;


import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PlatoonController {

    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    private final EurekaClient eurekaClient;

    @Autowired
    private ServletWebServerApplicationContext server;

    public PlatoonController(RestTemplate restTemplate, EurekaClient eurekaClient) {
        this.restTemplate = restTemplate;
        this.eurekaClient = eurekaClient;
    }


    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String returnString() {
        String obj = restTemplate.getForObject("http://REGISTRATIONSERVICE/hello", String.class);
        return "gepeicherte Person: " + obj;


    }

    @GetMapping(path = "/app", produces= MediaType.APPLICATION_JSON_VALUE)
    public Applications getApp() {
        return eurekaClient.getApplications();
    }

    @GetMapping("/server-port")
    public String serverPort() {

        return "Port " + server.getWebServer().getPort();
    }


}
