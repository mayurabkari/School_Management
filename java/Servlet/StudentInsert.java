package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Student;
import Entity.Teacher;

@WebServlet("/Studentadd")
public class StudentInsert extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	      String name=req.getParameter("name");
	      String mobile=req.getParameter("mobile");
	      String branch=req.getParameter("branch");
	      
	     long mobile1=Long.parseLong(mobile);
	      
	       Student s=new Student();
	       s.setName(name);
	       s.setMobile(mobile1);
	       s.setBranch(branch);
	       
	      
	        EntityManagerFactory emf=Persistence.createEntityManagerFactory("mayur");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			et.begin();
			em.persist(s);
			et.commit();
			
			PrintWriter pw=resp.getWriter();
			pw.print("Student Details Inserted Successfully!");
			pw.print("Thank you!");
			
			
			RequestDispatcher rd=req.getRequestDispatcher("StudentCRUD.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
			
		
	}
}
