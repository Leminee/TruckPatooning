package project.truckplatooning.platoon;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.Collections;


@Service
public class TruckService {

    Truck truck = new Truck();


    public Truck createLead() {

        truck.setTruckId(66666666L);
        truck.setLeadTruck(Platoon.leadTruck);
        truck.setSpeed(Platoon.speed);
        truck.setTruckRole(TruckRole.LEAD);
        Platoon.leadTruck = truck;

        return truck;

    }

    public String showLead(Model model){

        model.addAttribute("truck", Collections.singletonList(createLead()));

        return "monitoring";
    }

    public String showMonitor(Model model){

        Platoon.leadTruck = truck;
        truck.setSpeed(Platoon.speed);

        Truck truck1 = new Truck();
        Truck truck2 = new Truck();

        truck.joinPlatoon(truck1);

        truck1.setTruckId(434554L);
        truck1.setLeadTruck(truck);
        truck1.setSpeed(Platoon.speed);
        truck1.setTruckRole(TruckRole.FOLLOW);
        truck1.joinPlatoon(truck2);

        truck2.setTruckId(78984554L);
        truck2.setLeadTruck(truck);
        truck2.setSpeed(Platoon.speed);
        truck2.setTruckRole(TruckRole.FOLLOW);


        model.addAttribute("truck", Arrays.asList(truck, truck1, truck2));

        return "monitoring";
    }



    public static void updateSpeed() {

        //TODO

    }

    public void closeGap() {

        //TODO

    }
    public void adjustSpeed() {

        //TODO
    }
}
