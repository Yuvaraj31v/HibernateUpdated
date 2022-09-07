package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.entity.Employee;
import com.ideas2it.entity.Trainee;
import com.ideas2it.entity.Trainer;

public interface IEmployeeDao<T extends Employee> {


    /**
     *used to insert Employee into List
     *@param emp {@link T} the employee object
     *@return {@link void}
     */
    public void insertEmployee(T employee);

    /** Retrive list of  All trainers    
     * @return {@link List} of {@link Trainer}
     */ 
    public List<T> retrieveAllEmployees();

     /**
     * Retrive list of  All Employees  
     * @param emp {@link T} the employee object  
     * @return {@link List} of {@link T}
     */   

    public T retrieveEmployeeById(String employeeId);

    /**
     * update  Employee with his id  
     * @param employeeId {@link String} id of employee 
     * @param  mobileNumber{@long} mobile number of employee  
     * @return {@link void} 
     */   
    public void updateEmployee(T employee);

}  
