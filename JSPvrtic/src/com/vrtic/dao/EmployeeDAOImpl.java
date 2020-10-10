package com.vrtic.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.vrtic.model.Employee;
import com.vrtic.util.DBConnectionUtil;


public class EmployeeDAOImpl implements EmployeeDAO {
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	
	@Override
	public List<Employee> get() {
		
		List<Employee> list = null;
		Employee employee = null;
		
		try {
			
			list = new ArrayList<Employee>();
			String sql = "SELECT * FROM employees";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("ime") + " "+ resultSet.getString("prezime"));
				employee.setDepartment(resultSet.getString("OJ"));
				employee.setDob(resultSet.getString("datumRodjenja"));
				list.add(employee);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Employee get(int id) {
		Employee employee = null;
		try {
			employee = new Employee();
			String sql = "SELECT * FROM employees where id="+id;
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("ime")+ " "+ resultSet.getString("prezime"));
				employee.setDepartment(resultSet.getString("OJ"));
				employee.setDob(resultSet.getString("datumRodjenja"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public boolean save(Employee e) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO employees(ime, OJ, datumRodjenja)VALUES"
					+ "('"+e.getName()+"', '"+e.getDepartment()+"', '"+e.getDob()+"')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM employees where id="+id;
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Employee employee) {
		boolean flag = false;
		try {
			String sql = "UPDATE employees SET ime = '"+employee.getName()+"', "
					+ "department = '"+employee.getDepartment()+"', dob = '"+employee.getDob()+"' where id="+employee.getId();
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}