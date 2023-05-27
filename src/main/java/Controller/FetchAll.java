package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Empdao;

@WebServlet("/f")
public class FetchAll extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Empdao dao = new Empdao();
		req.setAttribute("list", dao.fetch());
		req.getRequestDispatcher("FetchAll.jsp").include(req, res);
		req.getRequestDispatcher("signup.html").include(req,res);
	}

}