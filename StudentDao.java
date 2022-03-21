package com.alomindia.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.alomindia.model.Student;

public class StudentDao {
	
	Connection conn;
	
	public StudentDao() throws ClassNotFoundException, SQLException, IOException {
	/*	Class.forName("com.mysql.jdbc.Driver");
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sazzaddb","root","root");
	**/
		conn = MyConnction.getConnection();
	}
	public int addRecord(Student st) throws SQLException {
		String sqlc = "insert into employee values(?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sqlc);
		pst.setInt(1, st.getStRoll());
		pst.setString(2, st.getStName());
		pst.setDouble(3, st.getStFees());
		return pst.executeUpdate();
		
		
		
	}
	
	
}
