package com.alomindia;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alomindia.dao.StudentDao;
import com.alomindia.model.Student;

public class AddPage extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("stName");
		Integer roll = Integer.parseInt(req.getParameter("stRoll"));
		Double fees = Double.parseDouble(req.getParameter("stFees"));
		
		Student student = new Student();
		student.setStName(name);
		student.setStRoll(roll);
		student.setStFees(fees);
		
		try {
			StudentDao stDao = new StudentDao();
			int x = stDao.addRecord(student);
			out.println("<h1>"+x+"Your Data has been Updated!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
