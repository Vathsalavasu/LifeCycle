package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Empdao;
import Dto.Empdetails;

@WebServlet("/search")
public class Searchbyname extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		Empdao dao = new Empdao();
		Empdetails emp;
		emp = dao.fetch(name);
		if (emp == null) {
			res.getWriter().print("<h1>Invalid name</h1>");
//			 req.getRequestDispatcher("Signup.html").include(req, res);//
		} else if (emp.getName().equals(name)) {
			res.getWriter().print("<div>");
			res.getWriter()
					.print("<table border='1'>" + "<tr>" + "<th>id</th>" + "<th>name</th>" + "<th>mobile</th>"
							+ "<th>Edit</th>" + "<th>delete</th>" + "</tr>" + "<tr>" + "<th>" + emp.getEmpid() + "</th>"
							+ "<th>" + emp.getName() + "</th>" + "<th>" + emp.getMobile() + "</th>"
							+ "<th><button>edit</button></th>" + "<th><button>Delete</button></th>" + "</tr>");
			res.getWriter().print("</table></div>");
			 req.getRequestDispatcher("Signup.html").include(req, res);
		}
	}

}
