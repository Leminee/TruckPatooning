package project.truckplatooning.service;

import org.springframework.stereotype.Service;
import project.truckplatooning.platoon.Platoon;
import project.truckplatooning.platoon.Truck;
import project.truckplatooning.platoon.TruckRole;
import java.util.List;


@Service
public class TruckService {

    Truck leadTruck = new Truck();

    public Truck createLead() {

        leadTruck.setLeadTruck(Platoon.leadTruck);
        leadTruck.setSpeed(Platoon.speed);
        leadTruck.setTruckRole(TruckRole.LEAD);
        Platoon.leadTruck = leadTruck;

        return leadTruck;
    }


    public List<Truck> createNewTruck(){

        Truck truck1 = new Truck();

        leadTruck.joinPlatoon(truck1);
        leadTruck.setSpeed(Platoon.speed);

        truck1.setLeadTruck(leadTruck);
        truck1.setSpeed(Platoon.speed);
        truck1.setTruckRole(TruckRole.FOLLOW);

        return List.of(leadTruck, truck1);

    }



    public void closeGap() {
        //TODO
    }

    public void adjustSpeed() {
        //TODO
    }
}
