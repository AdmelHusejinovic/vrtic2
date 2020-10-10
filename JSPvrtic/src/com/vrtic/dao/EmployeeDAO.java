package com.vrtic.dao;

import java.util.List;

import com.vrtic.model.Employee;


public interface EmployeeDAO {
	
	List<Employee> get();
	
	Employee get(int id);
	
	boolean save(Employee employee);
	
	boolean delete(int id);
	
	boolean update(Employee employee);
}