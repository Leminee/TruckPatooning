import java.util.LinkedList;
import java.util.List;

public class Truck  {
    private long truckId;
    private Truck leadTruck;
    private static int speed = 0;
    private Truck truckInFront;
    private Truck truckBehind;
    private final List <Truck> platoon = new LinkedList<>();

    public Truck(long truckId, Truck leadTruck, int speed, Truck truckInFront, Truck truckBehind) {
        this.truckId = truckId;
        this.leadTruck = leadTruck;
        Truck.speed = speed;
        this.truckInFront = truckInFront;
        this.truckBehind = truckBehind;
        platoon.add(new Truck());
    }

    public Truck(long truckId, int speed, Truck truckBehind) {
        this.truckId = truckId;
        Truck.speed = speed;
        this.truckBehind = truckBehind;
        platoon.add(new Truck());
    }

    public Truck() {
    }

    public static void accelerate(){
        int accelerationValue = 5;
        int currentAccelerationValue = 80;

        if(speed >= currentAccelerationValue) {
            return;
        }
        speed += accelerationValue;
    }

    public static void brake(){
        int brakeValue = 5;

        if (speed <= 0) {
            return;
        }

        speed -= brakeValue;
    }

    public static void stop(){
        speed = 0;
    }

    public void joinPlatoon(Truck truck) {
        platoon.add(truck);
    }

    public void leavePlatoon(Truck truck) {
        platoon.remove(truck);
    }

    public long getTruckId() {
        return truckId;
    }

    public Truck getLeadTruck() {
        return leadTruck;
    }

    public int getSpeed() {
        return speed;
    }

    public Truck getTruckInFront() {
        return truckInFront;
    }

    public Truck getTruckBehind() {
        return truckBehind;
    }

    public List<Truck> getPlatoon() {
        return platoon;
    }


}