package fi.eatech.fleetmanagerws.model;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/* 
 * Represents a car of the fleet.
 */
@Entity
public class Car {
   
   /* Attributes. */
   
   private String make;
   private String model;
   @Id
   private String registration;
   private int year;
   @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
   @Temporal(TemporalType.DATE)
   private Date inspection;
   private int size;
   private int power;

   /* Constructor. */
   
   public Car() {  }

   /* Accessors. */
   
   public String getMake() {
      return make;
   }

   public void setMake(String make) {
      this.make = make;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }
   
   public String getRegistration() {
      return registration;
   }

   public void setRegistration(String registration) {
      this.registration = registration;
   }

   public int getYear(){
      return year;
   }

   public void setYear(int year){
      this.year = year;
   }

   public Date getInspection(){
      return inspection;
   }

   public void setInspection(Date inspection){
      this.inspection = inspection;
   }

   public int getSize(){
      return size;
   }

   public void setSize(int size){
      this.size = size;
   }

   public int getPower(){
      return power;
   }

   public void setPower(int power){
      this.power = power;
   }
   
}