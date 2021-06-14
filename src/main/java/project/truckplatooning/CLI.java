package project.truckplatooning;


import java.io.IOException;

public class CLI {

    public static void main(String[] args) throws IOException {

     /*   Scanner sc = new Scanner(System.in);

        Truck truck = new Truck();
        truck.setTruckId(0L);
        Truck truck1 = new Truck();
        truck1.setTruckId(1L);
        Truck truck2 = new Truck();
        truck2.setTruckId(2L);
        Truck truck3 = new Truck();
        truck3.setTruckId(3L);

        System.out.println("Aktuelle Geschwindigkeit: " + truck.getSpeed());

        while (true){

            String input = sc.nextLine();

            if (input.length() != 1) {
                System.err.println("Error");
            }

            //j für joinen
            if (input.equalsIgnoreCase("j")) {
                truck.joinPlatoon(truck1);
                System.out.println("Hat sich dem Platoon angeschlossen");
            }

            // l für leave
            if(input.equalsIgnoreCase("l")) {
                truck.leavePlatoon(truck);
                System.out.println("Hat den Platoon verlassen");
            }

            //a für accelerate
            if(input.equalsIgnoreCase("a")) {
                truck.accelerate();
                System.out.println("Hat Geschwindigkeit erhöht");
                System.out.println(truck.getSpeed());
            }

            //b für break
            if(input.equalsIgnoreCase("b")) {
                truck.brake();
                System.out.println("Hat Geschwindigkeit verringert");
                System.out.println(truck.getSpeed());
            }

            //s für stop
            if(input.equalsIgnoreCase("s")) {
                truck.stop();
                System.out.println("Geschwindigkeit nach dem Stoppen :" + truck.getSpeed());
            }

            if(input.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
        }*/

        System.out.println(ProcessHandle.current().pid());
        System.out.println(System.getProperty("os.name"));



    }
}