package com.mph.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mph.model.Employee;
import com.mph.util.DBConnection;

public class EmployeeDaoimpl implements EmployeeDao {
      Connection connection;
      Statement  statement;
      PreparedStatement preparedStatement;
	  ResultSet resultSet;
	  List<Employee> emplist;
	  Employee employee;
      @Override
	public List<Employee> getAllEmployees() {
		
    	emplist=new ArrayList<Employee>();
		connection = DBConnection.getMyDbConnection();
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select * from mphemp");
			while(resultSet.next())
			{
				employee=new Employee();
				employee.setEmno(resultSet.getInt("emno"));
				employee.setEmname(resultSet.getString("emname"));
				employee.setDept(resultSet.getString("dept"));
				emplist.add(employee);
			}
			System.out.println("emp list from dao");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
    	return emplist;
	}

	@Override
	public Employee getEmployee(int eno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Employee emp) {
		boolean flag=false;
		connection = DBConnection.getMyDbConnection();
		try {
			preparedStatement=connection.prepareStatement("insert into mphemp(emno,emname,dept) values(?,?,?)");
			preparedStatement.setInt(1,emp.getEmno());
			preparedStatement.setString(2,emp.getEmname());
			preparedStatement.setString(3,emp.getDept());
			
	         int noofrows=preparedStatement.executeUpdate();
	         System.out.println(noofrows +" inserted in DB successfully");
	         flag=true;
			}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean update(Employee emp) {
		boolean flag=false;
		connection=DBConnection.getMyDbConnection();
		try {
			preparedStatement=connection.prepareStatement("update mphemp set emname='"+emp.getEmname()+"',dept='"+emp.getDept()+"' where emno="+emp.getEmno());
			//preparedStatement.setString(1,emp.getEmname());
			//preparedStatement.setString(2,emp.getDept());
			int noofrows=preparedStatement.executeUpdate();
			System.out.println(emp.getEmno()+" updated in DB successfully");
	         flag=true;
		    
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	

	@Override
	public boolean delete(int eno) {
		boolean flag=false;
		connection = DBConnection.getMyDbConnection();
		try {
			preparedStatement=connection.prepareStatement("delete from mphemp where emno="+eno);
			
	         int noofrows=preparedStatement.executeUpdate();
	         System.out.println(noofrows +" deleted in DB successfully");
	         flag=true;
			}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}

}
