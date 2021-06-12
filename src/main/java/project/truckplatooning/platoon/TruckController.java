package project.truckplatooning.platoon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TruckController {

    private final TruckService truckService;

    @Autowired
    public TruckController(TruckService truckService) {
        this.truckService = truckService;
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


    @GetMapping("/start")
    public String start(Model model){

        showMonitor(model);
        Platoon platoon = new Platoon();
        platoon.onStart();

        return showMonitor(model);

    }

    @GetMapping("/end")
    public void close(){

        Platoon platoon = new Platoon();
        platoon.onEnd();

    }

    @GetMapping("/join")
    public String getJoinedTrucks(Model model){

        truckService.showMonitor(model);

        return showMonitor(model);
    }

    @GetMapping("/leave")
    public String getLeavedTrucks(Model model){

        Truck truck = new Truck();
        truck.leavePlatoon(truck);

        showMonitor(model);

        return showMonitor(model);
    }

    @PostMapping("/addspeed")
    public void registerNewTruck(@RequestBody int index) {

        truckService.createTruck(index);

    }



}
