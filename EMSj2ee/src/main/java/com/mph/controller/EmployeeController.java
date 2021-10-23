package com.mph.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mph.dao.EmployeeDao;
import com.mph.dao.EmployeeDaoimpl;
import com.mph.model.Employee;

@WebServlet(name="EmployeeController",urlPatterns= {"/EC"})
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     EmployeeDao dao;
     RequestDispatcher rd;
   
    public EmployeeController() {
        dao=new EmployeeDaoimpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	   System.out.println("from doget()");
	   PrintWriter out=response.getWriter();
	   response.setContentType("text/html");
		out.println("Hello All");
		out.println("<html>");
		out.println("<head><title>Hello Page</title>");
		out.println("</head>");
		out.println("<body>");
		
		
		
		
		String action = request.getParameter("action");

		switch (action) {
		case "LIST": {
			listEmployee(request, response);
			break;
		}
		case "DELETE": {
			deleteEmployee(request, response);
			break;
		}
		case "EDIT": {
			editEmployee(request, response);
			break;
		}
		case "UPDATE": {
			updateEmployee(request, response);
			break;
		}
		}

		out.println("</body>");
		out.println("</html>");

	}

	
	private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rd = request.getRequestDispatcher("employee-edit.jsp");
		rd.forward(request, response);
		
	}


	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee=new Employee();
		employee.setEmno(Integer.parseInt(request.getParameter("eid")));
	    employee.setEmname(request.getParameter("ename")); 
	    employee.setDept(request.getParameter("dept"));
		if (dao.update(employee))
		{
			request.setAttribute("NOTIFICATION", "Employee updated Successfully :)" );
			listEmployee(request, response);
		}
		
	}


	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee=new Employee();
	  	int eeid=Integer.parseInt(request.getParameter("eid"));
		if (dao.delete(eeid))
		{
			request.setAttribute("NOTIFICATION", "Employee Deleted Successfully :)" );
			listEmployee(request, response);
		}
		
	}


	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		 
		List<Employee> emplist= dao.getAllEmployees();
		System.out.println("Emp list from contr " + emplist);
		request.setAttribute("allemp", emplist);
		rd = request.getRequestDispatcher("employee-list.jsp");
		rd.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee=new Employee();
	  	employee.setEmno(Integer.parseInt(request.getParameter("eid")));
	    employee.setEmname(request.getParameter("ename")); 
	    employee.setDept(request.getParameter("dept"));
	    System.out.println(employee);
	    
	    if(dao.save(employee) )
	    {
	    	request.setAttribute("NOTIFICATION","Employee added successfully");
	    	listEmployee(request,response);
	    }
	    
	}

}
