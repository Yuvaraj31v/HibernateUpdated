package com.ideas2it.util;

import java.time.LocalDate;
import java.time.Period;

public class Validation {

    public static boolean validatePhoneNumber(String phoneNumber) {
 
        String  pattern = "^\\d{10}$";
        return phoneNumber.matches(pattern);
    }

    public static int getExperience(LocalDate employeeDateOfJoin) {
	LocalDate currentDate = LocalDate.now();
        int employeeExperience = Period.between(employeeDateOfJoin, currentDate).getDays();
        return employeeExperience;
    } 
}
