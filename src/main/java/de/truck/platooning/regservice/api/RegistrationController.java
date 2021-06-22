package de.truck.platooning.regservice.api;

import de.truck.platooning.regservice.service.TruckService;
import de.truck.platooning.regservice.domain.Truck;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/registration")
public class RegistrationController {


    private final TruckService truckService;


    public RegistrationController(TruckService truckService) {
        this.truckService = truckService;
    }


    @PostMapping(path ="/add")
    public void add(Truck truck){

        truckService.addTruck(truck);
    }

    @PostMapping(path ="/add/{position}")
    public void addIn(@PathVariable int position, Truck truck){

        truckService.addTruckPosition(position, truck);
    }

    @PutMapping(path ="/acc/{value}")
    public void increaseSpeed(@PathVariable int value){

        truckService.accelerate(value);
    }

    @PutMapping(path ="/br/{value}")
    public void reduceSpeed(@PathVariable int value){

        truckService.brake(value);
    }

    @PutMapping(path ="/stop")
    public void reduceSpeed(){

        truckService.stop();
    }

    @DeleteMapping(path ="/rm/{position}")
    public void remove(@PathVariable int position){

        truckService.removeTruck(position);
    }

    @GetMapping(path = "/trucks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Truck> getAllTrucks(){

        return truckService.getAllTrucks();
    }

    @GetMapping(path= "/position/{position}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Truck getByPosition(@PathVariable int position){

        return truckService.getTruckByPosition(position);

    }

    @GetMapping(path= "/amount", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getAmount(){

        return truckService.getSize();
    }

}
