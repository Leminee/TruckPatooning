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

        List<Truck> platoon =  new LinkedList<>();

        Truck truck = new Truck();
        Truck truck1 = new Truck();
        Truck truck2 = new Truck();
        Truck truck3 = new Truck();

        truck.setTruckId(1);
        truck.setTruckInFront(Platoon.leadTruck);
        truck.setTruckBehind(truck1);
        truck.setSpeed(Platoon.speed);

        truck1.setTruckId(2);
        truck1.setTruckInFront(truck);
        truck1.setTruckBehind(truck2);
        truck1.setSpeed(Platoon.speed);


        truck2.setTruckId(3);
        truck2.setTruckInFront(truck1);
        truck.setTruckBehind(truck3);
        truck2.setSpeed(Platoon.speed);

        truck3.setTruckId(4);
        truck3.setTruckInFront(truck1);
        truck3.setTruckBehind(truck3);
        truck3.setSpeed(Platoon.speed);

        model.addAttribute(truck);
        model.addAttribute(truck1);
        model.addAttribute(truck2);
        model.addAttribute(truck3);

        platoon.add(truck);
        platoon.add(truck1);
        platoon.add(truck2);
        platoon.add(truck3);

        model.addAllAttributes(platoon);


        return "monitoring";

    }
}
