package fi.eatech.fleetmanagerws.model;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Entity
public class Car {
   
   @Id
   private String registration;
   private String make;
   private String model;
   private int year;
   private int size;
   private int power;
   @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
   @Temporal(TemporalType.DATE)
   private Date inspection;

   public Car() {  }

   public String getRegistration() {
      return registration;
   }

   public void setRegistration(String registration) {
      this.registration = registration;
   }

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

   public int getYear(){
      return year;
   }

   public void setYear(int year){
      this.year = year;
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

   public Date getInspection(){
      return inspection;
   }

   public void setInspection(Date inspection){
      this.inspection = inspection;
   }

   @Override
   public String toString() {
     return "Car{" +
             "registration=" + registration +
             ", make='" + make + '\'' +
             ", model='" + model + '\'' +
             ", year='" + year + '\'' +
             ", size ='" + size + '\'' +
             ", power ='" + power + '\'' +
             ", inspection ='" + inspection + '\'' +
             "}\n";
   }
   
}