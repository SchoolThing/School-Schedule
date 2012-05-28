package serverPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private User user = new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		try {
			user.setUserName(request.getParameter("Username"));
			user.setPassword(request.getParameter("Password"));
			user = UserDAO.login(user);

			if (user.isValid()) {
				HttpSession session = request.getSession(true);
				response.sendRedirect("mainPage.jsp"); // logged-in page
			} else
				response.sendRedirect("error.jsp"); // error page 
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}
