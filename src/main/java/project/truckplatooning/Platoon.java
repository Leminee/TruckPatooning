package project.truckplatooning;

public class Platoon {

    public static Truck leadTruck = null;
    public static int speed = 0;


    public void accelerate() {
        int accelerationValue = 5;
        int maxSpeed = 80;

        if (speed >= maxSpeed) {
            return;
        }
        speed += accelerationValue;
    }

    public  void brake() {
        int brakeValue = 5;

        if (speed <= 0) {
            return;
        }

        speed -= brakeValue;
    }

    public void stop() {
        speed = 0;
    }

    public Platoon(Truck leadTruck) {
        this.leadTruck = leadTruck;
    }
}
