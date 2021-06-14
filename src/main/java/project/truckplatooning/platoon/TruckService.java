package project.truckplatooning.platoon;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.Random;

@Service
public class TruckService {

    public static void main(String[] args) {

        Platoon platoon = new Platoon();

        TruckService truckService = new TruckService();
        truckService.createLead();

    }

    public void createLead() {


        Truck truck = new Truck(Platoon.leadTruck,34345 , 453576567L, Platoon.speed, null, new Truck(), TruckRole.LEAD);
        Platoon.leadTruck = truck;

    }

    public Truck addNewTruck(){

        Truck truck;
        Random random = new Random();
        long truckId = random.nextLong();
        int pId = random.nextInt();

        return truck = new Truck(Platoon.leadTruck, pId, truckId, Platoon.speed, new Truck(), new Truck(), TruckRole.FOLLOW);

    }


    public String showMonitor (Model model){

        Platoon platoon = new Platoon();
        platoon.onStart();

        Truck truck = new Truck(TruckRole.FOLLOW);
        Platoon.leadTruck = truck;
        Truck truck1 = new Truck(TruckRole.FOLLOW);
        Truck truck2 = new Truck(TruckRole.FOLLOW);
        Truck truck3 = new Truck(TruckRole.FOLLOW);


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


        model.addAttribute("truck", Arrays.asList(truck, truck1, truck2, truck3));

        return "monitoring";
    }


    public static void updateSpeed () {


    }

    public void closeGap () {

        //TODO

    }
    public void adjustSpeed () {

        //TODO
    }
}
