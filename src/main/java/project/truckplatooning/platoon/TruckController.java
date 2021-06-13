package project.truckplatooning.platoon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TruckController {

    private final TruckService truckService;

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




    @PostMapping("/join")
    public String getJoinedTrucks(Model model){

        truckService.showMonitor(model);

        return showMonitor(model);
    }

    @DeleteMapping("/leave")
    public String getLeavedTrucks(Model model){

        showMonitor(model);

        return showMonitor(model);
    }

    @GetMapping("/end")
    public void close(){
        
        System.out.println("Programm wird beendet...");
        Platoon platoon = new Platoon();
        platoon.onEnd();

    }


}
