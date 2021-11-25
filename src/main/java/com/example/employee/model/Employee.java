package com.example.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Employee {

  @Id
  @GeneratedValue
  private int Id;

  private String fistName;

  private String lastName;

  private String phone;

  private float salary;

  private String gender;

  private Date birthdate;

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

  public String getFistName() {
    return fistName;
  }

  public void setFistName(String fistName) {
    this.fistName = fistName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public float getSalary() {
    return salary;
  }

  public void setSalary(float salary) {
    this.salary = salary;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }

   public Employee(int Id,String fistName, String lastName, String phone, float salary, String gender, Date birthdate) {
    this.Id = Id;
    this.fistName = fistName;
    this.lastName = lastName;
    this.phone = phone;
    this.salary = salary;
    this.gender = gender;
    this.birthdate = birthdate;
  }

  public Employee() {

  }
}
