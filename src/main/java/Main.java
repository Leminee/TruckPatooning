public class Main {

    public static void main(String[] args) {

        for (String s : args) {
            System.out.println(s);
        }

        Truck truck = new Truck();
        truck.brake();
        truck.stop();
        truck.accelerate();
        System.out.println(truck.getSpeed());

    }
}
