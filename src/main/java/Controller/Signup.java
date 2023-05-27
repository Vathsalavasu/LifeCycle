package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Empdao;
import Dto.Empdetails;

@WebServlet("/signup")

public class Signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Empdetails emp = new Empdetails();
		emp.setName(req.getParameter("name"));
		emp.setEmpid(Integer.parseInt(req.getParameter("eid")));
		emp.setMobile(Long.parseLong(req.getParameter("phone")));

		Empdao dao = new Empdao();
		dao.save(emp);

		res.getWriter().print("<h1> Data Saved Succesfully</h1>");
		req.getRequestDispatcher("Signup.html").include(req, res);
	}

}
