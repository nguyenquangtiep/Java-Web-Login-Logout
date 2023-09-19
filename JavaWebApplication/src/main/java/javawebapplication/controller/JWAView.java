package javawebapplication.controller;

public interface JWAView {

	public String APP_CONTEXT = "/JavaWebApplication";
	public String PAGE_FOLDER = "/jsp";
	
	public String LoginView = PAGE_FOLDER + "/LoginView.jsp";
	public String UserView = PAGE_FOLDER + "/UserView.jsp";
	public String UserViewList = PAGE_FOLDER + "/UserViewList.jsp";
	public String WelcomeView = PAGE_FOLDER + "/WelcomeView.jsp";
	public String UploadImageView = PAGE_FOLDER + "/UploadImageView.jsp";
	
	public String LoginCTL = APP_CONTEXT + "/LoginCTL";
	public String UserCTL = APP_CONTEXT + "/UserCTL";
	public String WelcomeCTL = APP_CONTEXT + "/WelcomeCTL";
	public String UserListCTL = APP_CONTEXT + "/UserListCTL";
	public String UploadImageCTL = APP_CONTEXT + "/UploadImage";
}
