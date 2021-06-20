package project.truckplatooning.platoon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import project.truckplatooning.service.TruckService;

import java.util.Collections;
import java.util.List;


@Controller
public class TruckController  {

    private final TruckService truckService;


    @Autowired
    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @Autowired
    private RestTemplate restTemplate;

    /*@Autowired
    private WebClient.Builder webClientBuilder;*/


    @RequestMapping("/")
    public String getHomePage(){

        return "monitoring";
    }



    @RequestMapping("/start")
    public String getStartedProgram(Model model){

        startProgram();

        model.addAttribute("truck", Collections.singletonList(truckService.createLead()));

        return "monitoring";
    }

    @RequestMapping("/monitor")
    public String showMonitor(Model model){

        List<Truck> truckList = truckService.createNewTruck();

        model.addAttribute("truck", truckList);

        return "monitoring";

    }

    @RequestMapping("/join")
    public String getStatusAfterJoining(Model model){

        List<Truck> truckList = truckService.createNewTruck();

        model.addAttribute("truck", truckList);

        return "monitoring";
    }

    @PostMapping("/leave/{truckId}")
    public void leavePlatoon(Model model){


    }

   @RequestMapping("/speedplus")
    public String getIncreasedSpeed(Model model){

        Platoon.accelerate();

       System.out.println("LKW hat gebremst");
       System.out.println("Aktuelle Geschwindigkeit: " + Platoon.speed);

        truckService.adjustSpeed();

        return showMonitor(model);
    }

    @RequestMapping("/speedminus")
    public String getReducedSpeed(Model model){

        Platoon.brake();

        System.out.println("LKW hat gebremst");
        System.out.println("Aktuelle Geschwindigkeit: " + Platoon.speed);

        truckService.adjustSpeed();

        return showMonitor(model);

    }

    @RequestMapping("/stop")
    public String getSpeedAfterStop(Model model){

        System.out.println("LKW hat gestoppt");
        System.out.println("Aktuelle Geschwindigkeit: " + Platoon.speed);

        Platoon.stop();
        truckService.adjustSpeed();

        return showMonitor(model);

    }


    public void startProgram() {

        Platoon platoon = new Platoon();
        platoon.onStart();
    }

    @RequestMapping("/end")
    public void close(){
        
        System.out.println("Programm wird beendet...");
        Platoon platoon = new Platoon();
        platoon.onEnd();

    }

}
