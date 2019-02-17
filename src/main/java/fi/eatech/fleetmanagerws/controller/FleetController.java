package fi.eatech.fleetmanagerws.controller;

import fi.eatech.fleetmanagerws.model.Car;
import fi.eatech.fleetmanagerws.repository.CarRepository;

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

@RequestMapping("/fleet")
@RestController
public class FleetController {

   @Autowired
   CarRepository carRepository;
   
   @GetMapping("/health")
   public ResponseEntity getHealth() {
      return ResponseEntity.ok("System up");
   }
   
   @PostMapping("/add")
   public Car addCar(@RequestBody Car car) {
      if(car.getRegistration() != null)
         return carRepository.save(car);
      else
         return car;
   }
   
   @PostMapping("/edit")
   public Car editCar(@RequestBody Car car) {
      return carRepository.save(car);
   }
   
   @DeleteMapping("/delete/{registration}")
   public Car deleteCar(@PathVariable String registration) {
      Car toDelete = carRepository.findOne(registration);
      carRepository.delete(registration);
      return toDelete;
   }   
   
   @GetMapping("/find/{registration}")
   public Car findCar(@PathVariable String registration) {
      return carRepository.findOne(registration);
   }   
   
   @GetMapping("/all")
   public List<Car> findAllCars(){
      return carRepository.findAll();
   }
   
   @GetMapping("/findbymodelyear/{minYear}/{maxYear}")
   public List<Car> findCarsByModelYear(@PathVariable int minYear, @PathVariable int maxYear) {
      return carRepository.findByYearBetween(minYear, maxYear);
   }
   
   @GetMapping("/findbymake/{make}")
   public List<Car> findCarsByMake(@PathVariable String make) {
      return carRepository.findByMake(make);
   }
   
   @GetMapping("/findbymodel/{model}")
   public List<Car> findCarsByModel(@PathVariable String model) {
      return carRepository.findByModel(model);
   }

}