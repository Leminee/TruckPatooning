import java.util.LinkedList;
import java.util.List;

public class Truck implements Monitoring{
    private long truckId;
    private Truck leadTruck;
    private int speed = 0;
    private Truck truckInFront;
    private Truck truckBehind;
    private final List<Truck> platoon = new LinkedList<>();

    public Truck(long truckId, Truck leadTruck, int speed, Truck truckInFront, Truck truckBehind) {
        this.truckId = truckId;
        this.leadTruck = leadTruck;
        this.speed = speed;
        this.truckInFront = truckInFront;
        this.truckBehind = truckBehind;
        platoon.add(new Truck());
    }

    public Truck() {

    }

    public int accelerate(){
        if(speed >= 80) {
            return 80;
        }
        speed += 10;
        return speed;
    }

    public int brake(){

        if (speed <= 0) {
            return 0;
        }
        speed -= 5;
        return speed;
    }

    public int stop(){
        return speed = 0;

    }

    public void join(Truck truck) {
        platoon.add(truck);

    }

    public void leave(Truck truck) {
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
}