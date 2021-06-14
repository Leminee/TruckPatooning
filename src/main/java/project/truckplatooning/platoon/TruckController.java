package project.truckplatooning.platoon;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.truckplatooning.TruckPlatooningApplication;

import java.util.Date;
import java.util.UUID;


@Controller
public class TruckController {

    private final TruckService truckService;

    @Autowired
    private RabbitTemplate template;


    @Autowired
    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }


    @GetMapping("/start")
    public String start(){

        Platoon platoon = new Platoon();
        platoon.onStart();

        return "started";

    }


    @GetMapping("/monitor")
    public String showMonitor(Model model){

        return truckService.showMonitor(model);

    }

   @GetMapping("/speedplus")
    public String getIncreasedSpeed(Model model){

        Platoon.accelerate();


        TruckService truckService = new TruckService();
        truckService.adjustSpeed();

        return showMonitor(model);
    }

    @GetMapping("/speedminus")
    public String getReducedSpeed(Model model){

        Platoon.brake();
        showMonitor(model);

        return showMonitor(model);

    }

    @GetMapping("/stop")
    public String getSpeed(Model model){

        Platoon.stop();
        showMonitor(model);

        return showMonitor(model);

    }

    @PostMapping("/join/{truckId}")
    public String addNewTruck(Model model){

        truckService.showMonitor(model);

        return showMonitor(model);
    }

    @PostMapping("/leave/{truckId}")
    public String removeTruck(Model model){

        showMonitor(model);

        return showMonitor(model);
    }

    @GetMapping("/end")
    public void close(){
        
        System.out.println("Programm wird beendet...");
        Platoon platoon = new Platoon();
        platoon.onEnd();

    }



    @GetMapping("/pub")
    public String publishMessage(@RequestBody TruckNotificator message) {
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(TruckPlatooningApplication.EXCHANGE,
                TruckPlatooningApplication.ROUTING_KEY, message);

        System.out.println("test");

        return "Message Published";
    }

}
