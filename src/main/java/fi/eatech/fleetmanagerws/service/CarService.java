package fi.eatech.fleetmanagerws.service;

import fi.eatech.fleetmanagerws.model.Car;
import fi.eatech.fleetmanagerws.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

/* 
 * Service for given methods.
 */
@Service
public class CarService {
   
   @Autowired
   CarRepository carRepository;
   
   /* 
    * Adds a new car to database if given registration number 
    * is not null and if there is not already a car in the 
    * database with given registration number. 
    */
   public Car add(Car car) {
      if(car.getRegistration() != null && find(car.getRegistration()) == null)
         return carRepository.save(car);
      else
         return null;
   }
   
   /* Edits existing car. */
   public Car edit(Car car) {
      return carRepository.save(car);
   }
   
   /* 
    * Deletes existing car from the database. 
    * Returns null if there wasn't a car in the database with
    * the given registration number.
    */
   public Car deleteOne(String registration) {
      Car toDelete = carRepository.findOne(registration);
      if (toDelete != null)
         carRepository.delete(registration);
      return toDelete;
   }   
   
   /* 
    * Returns a car from the database with the given registration. 
    */
   public Car find(String registration) {
      return carRepository.findOne(registration);
   }   
   
   /* Returns a list of all the cars in the database. */
   public List<Car> findCars(){
      return carRepository.findAll();
   }
   
   /* 
    * Returns a list of all the cars in the database which
    * have a model year between given parametres. 
    */
   public List<Car> findByModelYear(int minYear, int maxYear) {
      return carRepository.findByYearBetween(minYear, maxYear);
   }
   
   /* 
    * Returns a list of all the cars in the database
    * with certain make.
    */
   public List<Car> findAllByMake(String make) {
      return carRepository.findByMake(make);
   }
   
   /* 
    * Returns a list of all the cars in the database
    * with certain model. 
    */
   public List<Car> findAllByModel(String model) {
      return carRepository.findByModel(model);
   }
   
   /* 
    * Loads cars from CSV file into the database. 
    */
   @PostConstruct
   public void loadFromCSV() {
      /* File name of the CSV file. */
      String fileName = "car.csv";
      
      try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
         String [] nextLine = reader.readNext();
         
         while ((nextLine = reader.readNext()) != null) {
            Car car = new Car();
            
            car.setMake(nextLine[0]);
            car.setModel(nextLine[1]);
            car.setRegistration(nextLine[2]);
            car.setYear(Integer.parseInt(nextLine[3]));
            car.setSize(Integer.parseInt(nextLine[5]));
            car.setPower(Integer.parseInt(nextLine[6]));
            Date inspection = new SimpleDateFormat("yyyy-MM-dd").parse(nextLine[4]);  
            car.setInspection(inspection);
            
            carRepository.save(car);
         }
      }
      catch (FileNotFoundException f) {
      }
      catch (IOException i) {
      }
      catch (ParseException p) {
      }
      catch (NumberFormatException n) {
      }
   }
   
}