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

import java.util.List;

/* 
 * FleetManager controller.
 */
@RequestMapping("/fleet")
@RestController
public class FleetController {

   @Autowired
   CarService carService;
   
   @GetMapping("/health")
   public ResponseEntity getHealth() {
      return ResponseEntity.ok("System up");
   }
   
   @PostMapping("/add")
   public Car addCar(@RequestBody Car car) {
      return carService.add(car);
   }
   
   @PostMapping("/edit")
   public Car editCar(@RequestBody Car car) {
      return carService.edit(car);
   }
   
   @DeleteMapping("/delete/{registration}")
   public Car deleteCar(@PathVariable String registration) {
      return carService.deleteOne(registration);
   }   
   
   @GetMapping("/find/{registration}")
   public Car findCar(@PathVariable String registration) {
      return carService.find(registration);
   }   
   
   @GetMapping("/all")
   public List<Car> findAllCars(){
      return carService.findCars();
   }
   
   @GetMapping("/findbymodelyear/{minYear}/{maxYear}")
   public List<Car> findCarsByModelYear(@PathVariable int minYear, @PathVariable int maxYear) {
      return carService.findByModelYear(minYear, maxYear);
   }
   
   @GetMapping("/findbymake/{make}")
   public List<Car> findCarsByMake(@PathVariable String make) {
      return carService.findAllByMake(make);
   }
   
   @GetMapping("/findbymodel/{model}")
   public List<Car> findCarsByModel(@PathVariable String model) {
      return carService.findAllByModel(model);
   }
   
}