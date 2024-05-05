package master.servlet.coordi;

import jakarta.servlet.ServletException;  
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import master.dao.factory.coordi.OraFactory;
import master.dao.imp.coordi.ResponsableDaoImp;

import java.io.IOException;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int id;
		ResponsableDaoImp r=OraFactory.getResponsableDao();
		if(r.checkLogin(email,password)) { 
			id=r.getById(email);
			request.setAttribute("id",id);
			this.getServletContext().getRequestDispatcher("/WEB-INF/coordi/home.jsp").forward(request, response);
		}else {
			request.setAttribute("failed","email/password is incorrect ");
			this.getServletContext().getRequestDispatcher("/coordi/LoginCoordi.jsp").forward(request, response);
		}
	}
	

}
