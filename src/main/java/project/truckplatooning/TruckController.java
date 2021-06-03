package project.truckplatooning;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.List;


@Controller
public class TruckController {

    @GetMapping("/")
    public String getPlatoon(Model model){

        final List<Truck> platoon =  new LinkedList<>();

        Truck truck = new Truck();
        Truck truck1 = new Truck();
        Truck truck2 = new Truck();
        Truck truck3 = new Truck();

        truck.setTruckId(1);
        truck.setTruckInFront(truck);
        truck.setTruckBehind(truck1);
        truck.setSpeed(60);
        model.addAttribute(truck);


        truck1.setTruckId(2);
        truck1.setTruckInFront(truck);
        truck1.setTruckBehind(truck2);
        truck1.setSpeed(60);
        model.addAttribute(truck1);

        truck2.setTruckId(3);
        truck2.setTruckInFront(truck1);
        truck.setTruckBehind(truck3);
        truck2.setSpeed(60);
        model.addAttribute(truck2);

        truck3.setTruckId(4);
        truck3.setTruckInFront(truck1);
        truck3.setTruckBehind(truck3);
        truck3.setSpeed(60);
        model.addAttribute(truck3);

        platoon.add(truck);
        platoon.add(truck1);
        platoon.add(truck2);
        platoon.add(truck3);

        model.addAttribute(platoon);


        return "monitoring";


    }
}
