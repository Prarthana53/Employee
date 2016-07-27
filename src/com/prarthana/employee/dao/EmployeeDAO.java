/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.employee.dao;

import com.prarthana.employee.obj.Employee;

/**
 *
 * @author Pavilion G4
 */
public interface EmployeeDAO {
    boolean insert(Employee e);
    boolean delete(int id);
    Employee getById(int id);
    Employee[] getAll();
    
}
