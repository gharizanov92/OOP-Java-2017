/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Georgi
 */
public class Query {
    public static Employee[] and(Employee[] employees, SearchCriteria[] criteria) {
        int index = 0;
        // matching employees can have at most employees.length items
        final Employee[] matchingEmployees = new Employee[employees.length];
        
        for (Employee employee : employees) {
            boolean matches = true;
            
            for (SearchCriteria searchCriteria : criteria) {
                matches = matches && searchCriteria.matches(employee);
            }
            
            if (matches) {
                matchingEmployees[index++] = employee;
            }
        }
        
        // return a copy of matchingEmployees 
        // truncating it to have a lenght equal to index
        return Arrays.copyOf(matchingEmployees, index);
    }
}
