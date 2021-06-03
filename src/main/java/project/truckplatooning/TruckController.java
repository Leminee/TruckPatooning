package project.truckplatooning;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Random;


@Controller
public class TruckController {

    @GetMapping("/monitor")
    public String getPlatoon(Model model){
        Random random = new Random();


        Truck truck = new Truck();
        Truck truck1 = new Truck();
        Truck truck2 = new Truck();
        Truck truck3 = new Truck();


        truck.setTruckId(76886);
        truck.setSpeed(Platoon.speed + random.nextInt(10));
        truck.joinPlatoon(truck1);

        truck1.setTruckId(67867);
        truck1.setSpeed(Platoon.speed + random.nextInt(6));
        truck1.joinPlatoon(truck2);


        truck2.setTruckId(37887);
        truck2.setSpeed(Platoon.speed + random.nextInt(4));
        truck2.joinPlatoon(truck3);


        truck3.setTruckId(46788);
        truck3.setSpeed(Platoon.speed + random.nextInt(2));


        model.addAttribute("truck", Arrays.asList(truck, truck1,truck2,truck3));


        return "monitoring";

    }
}
