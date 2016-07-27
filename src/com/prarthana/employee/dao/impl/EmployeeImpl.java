/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.employee.dao.impl;

import com.prarthana.employee.dao.EmployeeDAO;
import com.prarthana.employee.obj.Employee;

/**
 *
 * @author Pavilion G4
 */
public class EmployeeImpl implements EmployeeDAO{
    private int counter=0;
    private Employee[] employeeList=new Employee[5];

    @Override
    public boolean insert(Employee e) {
        if(counter==employeeList.length){
            return false;
        }
      employeeList[counter]=e;
      counter++;
        return true;
        
    }

    @Override
    public boolean delete(int id) {
        for(int i=0;i<employeeList.length;i++){
        Employee s=employeeList[i]; 
        if(s!=null && s.getId()==id){
            employeeList[i]=null;
            return true;
        }
        
        }
        return false;
        
    }

    @Override
    public Employee getById(int id) {
        for(int i=0;i<employeeList.length;i++){
        Employee s=employeeList[i]; 
        if(s!=null && s.getId()==id){
            
            return s;
        }
        
        }
        return null;
        
    }

    @Override
    public Employee[] getAll() {
        return employeeList;
        
    }
    
}
