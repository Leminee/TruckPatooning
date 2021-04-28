
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (String s : args) {
            System.out.println(s);
        }

        Truck truckBehind = new Truck();
        Truck leadTruck = new Truck(14334L, 60, truckBehind);
        Truck truckInFront = new Truck();
        Truck truck = new Truck(24434L, leadTruck, 60, truckInFront, truckBehind);


        while (true) {

            String l = sc.nextLine();
            if (l.equalsIgnoreCase("l")) {
                truck.leavePlatoon(truck);
                System.out.println("LKW mit der ID " + truck.getTruckId() + " hat den Zug verlassen");
                return;
            }

            String s = sc.nextLine();
            if (s.equalsIgnoreCase("s")) {
                Truck.stop();
                System.out.println("Geschwindigkeit " + truck.getSpeed() + " km/h");
                System.out.println("LKW hat angehalten");
                return;
            }


            String j = sc.nextLine();

            if (j.equalsIgnoreCase("j")) {
                leadTruck.joinPlatoon(truck);
            }

            String a = sc.nextLine();
            if (a.equalsIgnoreCase("a")) {

                if (leadTruck.getSpeed() >= 80) {
                    System.err.println("Maximale Geschwindigkeit von " + leadTruck.getSpeed() + " erreicht!");
                }
                Truck.accelerate();
                System.out.println("Geschwindigkeit " + truck.getSpeed() + " km/h");
            }

            String b = sc.nextLine();

            if (b.equalsIgnoreCase("b")) {
                Truck.brake();
                System.out.println("Geschwindigkeit " + truck.getSpeed() + " km/h");
            }
        }
    }
}
