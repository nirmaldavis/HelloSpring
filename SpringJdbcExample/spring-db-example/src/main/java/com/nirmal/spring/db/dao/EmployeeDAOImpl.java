package com.nirmal.spring.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.nirmal.spring.db.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Employee employee) {

		String query= "INSERT INTO Employee(id, name, role) VALUES (?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getRole());
			int executeUpdateResult = ps.executeUpdate();
			if(executeUpdateResult != 0) {
				System.out.println("Employee saved with id = " + employee.getId());
			}
			else {
				System.out.println("Employee save failed with id = " + employee.getId());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public Employee getById(int id) {

		String query = "select name, role from Employee where id = ?";
		Employee emp = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if( (rs != null) && (rs.next()) ) {
				emp = new Employee(id, rs.getString("name"), rs.getString("role"));
			}
			else {
				System.out.println("No emplyee found with id : " + id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return emp;
	}

	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
