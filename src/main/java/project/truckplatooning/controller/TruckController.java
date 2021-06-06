package project.truckplatooning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.truckplatooning.Platoon;
import project.truckplatooning.Truck;

import java.util.Arrays;
import java.util.Random;


@Controller
public class TruckController {

    @GetMapping("/monitor")
    public String monitor(Model model){
        Random random = new Random();

        Truck truck = new Truck();
        Platoon.leadTruck = truck;
        Truck truck1 = new Truck();
        Truck truck2 = new Truck();
        Truck truck3 = new Truck();


        truck.setTruckId(76886078887L);
        truck.setLeadTruck(truck);
        truck.setSpeed(truck.getSpeed() + random.nextInt(10));
        truck.joinPlatoon(truck1);

        truck1.setTruckId(67867876533L);
        truck1.setLeadTruck(truck);
        truck1.setSpeed(truck1.getSpeed() + random.nextInt(3));
        truck1.joinPlatoon(truck2);

        truck2.setTruckId(3788788332L);
        truck1.setLeadTruck(truck);
        truck2.setSpeed(truck2.getSpeed() + random.nextInt(3));
        truck2.joinPlatoon(truck3);

        truck3.setTruckId(4678873223L);
        truck1.setLeadTruck(truck);
        truck3.setSpeed(truck3.getSpeed() + random.nextInt(3));

        model.addAttribute("truck", Arrays.asList(truck, truck1,truck2,truck3));

        return "monitoring";

    }
}
