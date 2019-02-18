package fi.eatech.fleetmanagerws.repository;

import fi.eatech.fleetmanagerws.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/* 
 * Car repository
 * - with methods for finding cars by modelyear, make and model.
 *
 */
@Repository
public interface CarRepository extends JpaRepository<Car, String> {

   List<Car> findByYearBetween(int minYear, int maxYear);
   List<Car> findByMake(String make);
   List<Car> findByModel(String model);

}