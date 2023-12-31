package javawebapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jakarta.servlet.annotation.WebServlet;
import javawebapplication.bean.UserBean;
import javawebapplication.model.UserModel;
import javawebapplication.utility.ServletUtility;

/**
 * Servlet implementation class LoginCTL
 */
@WebServlet(name = "LoginCTL", urlPatterns = {"/LoginCTL"})
public class LoginCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		String op = request.getParameter("operation");
		try {
			if (op != null && op.equalsIgnoreCase("logout")) {
				session.invalidate();
				ServletUtility.setSuccessMessage("Logout Successfully", request);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		ServletUtility.forward(JWAView.LoginView, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean user = new UserBean();
		String login = request.getParameter("login");
		String pwd = request.getParameter("password");
		HttpSession session=request.getSession(true);

		user = UserModel.UserLogin(login, pwd);
		if (user != null) {
			// ServletUtility.setSuccessMessage(request.getParameter("login")+ " is login
			// successfully", request);
			//Set attribute for session
			session.setAttribute("user", user.getFirstName());
			ServletUtility.redirect(JWAView.WelcomeCTL, request, response);
		} else {
			ServletUtility.setErrorMessage("Invalid User", request);
			ServletUtility.forward(JWAView.LoginView, request, response);
		}
	}

}
