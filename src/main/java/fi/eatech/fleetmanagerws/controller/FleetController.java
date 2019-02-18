package fi.eatech.fleetmanagerws.controller;

import fi.eatech.fleetmanagerws.model.Car;
import fi.eatech.fleetmanagerws.repository.CarRepository;
import fi.eatech.fleetmanagerws.service.CarService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/* 
 * FleetManager controller.
 */
@RequestMapping("/fleet")
@RestController
@EnableSwagger2
public class FleetController {

   @Autowired
   CarService carService;
   
   @ApiOperation(value = "Check that system is up.")
   @GetMapping("/health")
   public ResponseEntity getHealth() {
      return ResponseEntity.ok("System up");
   }
   
   @ApiOperation(value = "Add a new car to the fleet.")
   @PostMapping("/add")
   public Car addCar(@RequestBody Car car) {
      return carService.add(car);
   }
   
   @ApiOperation(value = "Edit existing car of the fleet.")
   @PostMapping("/edit")
   public Car editCar(@RequestBody Car car) {
      return carService.edit(car);
   }
   
   @ApiOperation(value = "Delete a car with given registration from the fleet.")
   @DeleteMapping("/delete/{registration}")
   public Car deleteCar(@PathVariable String registration) {
      return carService.deleteOne(registration);
   }   
   
   @ApiOperation(value = "Get a car with given registration from the fleet.")
   @GetMapping("/find/{registration}")
   public Car findCar(@PathVariable String registration) {
      return carService.find(registration);
   }   
   
   @ApiOperation(value = "Get all cars of the fleet.")
   @GetMapping("/all")
   public List<Car> findAllCars(){
      return carService.findCars();
   }
   
   @ApiOperation(value = "Get cars from the fleet with model year between given years.")
   @GetMapping("/findbymodelyear/{minYear}/{maxYear}")
   public List<Car> findCarsByModelYear(@PathVariable int minYear, @PathVariable int maxYear) {
      return carService.findByModelYear(minYear, maxYear);
   }
   
   @ApiOperation(value = "Get cars from the fleet with certain make.")
   @GetMapping("/findbymake/{make}")
   public List<Car> findCarsByMake(@PathVariable String make) {
      return carService.findAllByMake(make);
   }
   
   @ApiOperation(value = "Get cars from the fleet with certain model.")
   @GetMapping("/findbymodel/{model}")
   public List<Car> findCarsByModel(@PathVariable String model) {
      return carService.findAllByModel(model);
   }
   
}