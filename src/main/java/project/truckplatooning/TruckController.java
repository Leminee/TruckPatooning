package project.truckplatooning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TruckController {

    @GetMapping("/infos")
    public List<Truck> getTruckInfo(List <Truck> truck) {
        truck = new ArrayList<>();

        Truck truck2 = new Truck();
        truck2.setTruckId(334L);

        truck.add(truck2);

        truck.get(0).setTruckId(2334545L);
        truck.get(0).setTruckBehind(truck2);

        return truck;

    }
}
