package project.truckplatooning.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.truckplatooning.Platoon;
import project.truckplatooning.Truck;

import java.util.Arrays;


@Controller
public class TruckController {

    @GetMapping("/monitor")
    public String showMonitor(Model model){

        Platoon platoon = new Platoon();
        platoon.onStart();



        Truck truck = new Truck();
        Platoon.leadTruck = truck;
        Truck truck1 = new Truck();
        Truck truck2 = new Truck();
        Truck truck3 = new Truck();



        truck.setTruckId(7688607L);
        truck.setLeadTruck(truck);
        truck.setSpeed(truck.getSpeed());
        truck.joinPlatoon(truck1);


        truck1.setTruckId(6786787L);
        truck1.setLeadTruck(truck);
        truck1.setSpeed(truck1.getSpeed());
        truck1.joinPlatoon(truck2);


        truck2.setTruckId(3788788788L);
        truck2.setLeadTruck(truck);
        truck2.setSpeed(truck2.getSpeed());
        truck2.joinPlatoon(truck3);


        truck3.setTruckId(4678L);
        truck3.setLeadTruck(truck);
        truck3.setSpeed(truck3.getSpeed());


        model.addAttribute("truck", Arrays.asList(truck, truck1,truck2,truck3));

        return "monitoring";

    }

    @GetMapping("/speedplus")
    public String getIncreasedSpeed(Model model){

        Platoon.leadTruck.accelerate();
        showMonitor(model);

        return "monitoring";

    }

    @GetMapping("/speedminus")
    public String getReducedSpeed(Model model){

        Platoon.leadTruck.brake();
        showMonitor(model);

        return "monitoring";

    }

    @GetMapping("/stop")
    public String getSpeed(Model model){

        Platoon.leadTruck.stop();
        showMonitor(model);

        return "monitoring";

    }


    @GetMapping("/start")
    public String start(Model model){

        showMonitor(model);
        Platoon platoon = new Platoon();
        platoon.onStart();

        return "monitoring";

    }

    @GetMapping("/end")
    public void close(){

        Platoon platoon = new Platoon();
        platoon.onEnd();

    }

    @GetMapping("/join")
    public String getJoinedTrucks(Model model){

        Platoon platoon = new Platoon();
        platoon.onStart();



        Truck truck = new Truck();
        Platoon.leadTruck = truck;
        Truck truck1 = new Truck();
        Truck truck2 = new Truck();
        Truck truck3 = new Truck();
        Truck truck4 = new Truck();


        truck.setTruckId(7688607L);
        truck.setLeadTruck(Platoon.leadTruck);
        truck.setSpeed(truck.getSpeed());
        truck.joinPlatoon(truck1);


        truck1.setTruckId(6786787L);
        truck1.setLeadTruck(Platoon.leadTruck);
        truck1.setSpeed(truck1.getSpeed());
        truck1.joinPlatoon(truck2);


        truck2.setTruckId(3788788788L);
        truck2.setLeadTruck(Platoon.leadTruck);
        truck2.setSpeed(truck2.getSpeed());
        truck2.joinPlatoon(truck3);

        truck3.setTruckId(4678L);
        truck3.setLeadTruck(Platoon.leadTruck);
        truck3.setSpeed(truck3.getSpeed());
        truck3.joinPlatoon(truck4);


        truck4.setTruckId(33445L);
        truck4.setLeadTruck(Platoon.leadTruck);
        truck4.setSpeed(Platoon.speed);

        model.addAttribute("truck", Arrays.asList(truck, truck1,truck2,truck3,truck4));

        return "monitoring";
    }

    @GetMapping("/leave")
    public String getLeavedTrucks(Model model){

        Truck truck = new Truck();
        truck.leavePlatoon(truck);

        showMonitor(model);

        return "monitoring";
    }
}
