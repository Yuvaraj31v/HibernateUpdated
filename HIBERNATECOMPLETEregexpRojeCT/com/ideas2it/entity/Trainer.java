package com.ideas2it.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;


@NamedQueries(  
    {  
        @NamedQuery(  
        name  = "findTrainer",  
        query = "from Trainer e where e.isActive =:isActive"  
        ),

	@NamedQuery(  
        name  = "findTrainerById",  
        query = "from Trainer e where e.isActive =:isActive AND e.employeeId = :employeeId"   
        )
         
    }  
)  
@Entity
@Table(name ="Trainers")

public class Trainer extends Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="trainers")
    @SequenceGenerator(
	    name = "trainers",
	    sequenceName = "trainer_sequence")	    
    private long id;
     
    private String employeeId;

    private String employeeFirstName;

    private String employeeLastName;

    private long employeePhoneNumber;

    private LocalDate employeeDateOfBirth;

    private LocalDate employeeDateOfJoin;

    private String employeeEmailId;

    private int isActive = 1; 
  
    @ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.EAGER)  
    @JoinTable(name = "trainee_trainer",   
    joinColumns = { @JoinColumn(name = "Trainer_id") },   
    inverseJoinColumns = { @JoinColumn(name = "Trainee_id") }) 
    private List<Trainee> trainees;

    public void setTrainee(List<Trainee> trainee ) {
	this.trainees= trainee;
    }

    public List<Trainee> getTrainee() {
	return trainees;
    }

    public void setIsActive(int value) {
	this.isActive = value;
    }

    public void setId(String id) {
	this.employeeId = id;
    }   

    public String getId() {
	return employeeId;
    }

    public void setFirstName(String firstName) {
	this.employeeFirstName = firstName;
    }

    public String getFirstName() {
	return employeeFirstName;
    }

    public void setLastName(String lastName) {
	this.employeeLastName = lastName;
    }

    public String getLastName() {
	return employeeLastName;
    }

    public void setPhoneNumber(long phoneNumber) {
	this.employeePhoneNumber = phoneNumber;
    }

    public long getPhoneNumber() {
	return employeePhoneNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
	this.employeeDateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
	return  employeeDateOfBirth ;
    }

    public void setDateOfJoin(LocalDate dateOfJoin) {
	this.employeeDateOfJoin = dateOfJoin;
    }

     public LocalDate getDateOfJoin() {
	return  employeeDateOfJoin;
    }

    public void setEmailId(String emailId) {
	this.employeeEmailId = emailId;
    }

    public String getEmailId() {
	return  employeeEmailId;
    }

}