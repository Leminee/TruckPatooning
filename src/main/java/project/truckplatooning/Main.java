package project.truckplatooning;

public class Main {

    public static void main(String[] args) {

        Truck truck = new Truck();
        truck.setTruckId(0L);
        Truck truck1 = new Truck();
        truck1.setTruckId(1L);
        Truck truck2 = new Truck();
        truck2.setTruckId(2L);
        Truck truck3 = new Truck();
        truck3.setTruckId(3L);

        truck.joinPlatoon(truck1);
        truck1.joinPlatoon(truck2);
        truck2.joinPlatoon(truck3);


        System.out.println("ID erster Truck " + truck.getTruckId() + ", ID Nachfolger des ersten Trucks "  + truck.getTruckBehind().getTruckId());
        System.out.println("ID erster Truck " + truck1.getTruckId() + ", ID Nachfolger des zweiten Trucks "  + truck1.getTruckBehind().getTruckId() + ", ID Vorgänger des zweiten Trucks " + truck1.getTruckInFront().getTruckId());
        System.out.println("ID erster Truck " + truck2.getTruckId() + ", ID Nachfolger des dritten Truck "  + truck2.getTruckBehind().getTruckId() + ", ID Vorgänger des dritten Trucks " + truck2.getTruckInFront().getTruckId());



    }
}