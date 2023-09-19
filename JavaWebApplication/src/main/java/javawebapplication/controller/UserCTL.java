package javawebapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;
import javawebapplication.bean.UserBean;
import javawebapplication.model.UserModel;
import javawebapplication.utility.DataUtility;
import javawebapplication.utility.ServletUtility;

/**
 * Servlet implementation class UserCTL
 */
@WebServlet(name = "UserCTL", urlPatterns = {"/UserCTL"})
public class UserCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Edit....
		UserModel model = new UserModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0) {
			UserBean bean = null;
			bean = model.FindByPk(id);
			request.setAttribute("bean", bean);
		}
		ServletUtility.forward(JWAView.UserView, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean user = new UserBean();
	    user.setFirstName(request.getParameter("firstName"));
	    user.setLastName(request.getParameter("lastName"));
	    user.setLogin(request.getParameter("login"));
	    user.setPassword(request.getParameter("password"));
	    user.setDob(DataUtility.getDate(request.getParameter("dob")));
	    user.setMobileNo(request.getParameter("mobile"));
	    
	    user.setId(DataUtility.getLong(request.getParameter("id")));
	    
	    System.out.println("ID: " + user.getId());
		if (user.getId() > 0) {
			// To Update the records
			System.out.println("Updating...");
			long i = UserModel.UpdateUser(user);
			if (i > 0) {
				ServletUtility.setSuccessMessage("User Update sucessfully", request);

			} else {
				ServletUtility.setErrorMessage("Not insterted", request);
			}

		} else {
			System.out.println("Adding...");
			long i = UserModel.addUser(user);
			if (i > 0) {
				ServletUtility.setSuccessMessage("User register sucessfully", request);

			} else {
				ServletUtility.setErrorMessage("Not insterted", request);
			}
		}
		
	    ServletUtility.forward(JWAView.UserView, request, response);
	}

}
