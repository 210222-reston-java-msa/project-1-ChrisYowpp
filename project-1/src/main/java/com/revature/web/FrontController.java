package com.revature.web;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.methods.Setup;
import com.revature.service.UserService;
import com.revature.util.RequestHelper;

public class FrontController extends HttpServlet {
  public static final long serialVersionUID = 1L;

  public FrontController() {
    super();
    //Setup.initialValues();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    // we will rewrite the URL's 
    final String URI = request.getRequestURI().replace("/project-1/", "");

    switch(URI) {
      case "login":
        RequestHelper.processLogin(request, response);
        break;

      case "logout":
        RequestHelper.processLogout(request, response);
        break;
      
      //  case "reimb":
      //    RequestHelper.processReimbursement(request, response);
      //    break;

      // case "users":
      //   RequestHelper.processUsers(request, response);
      //   break;

      case "error":
        RequestHelper.processError(request, response);
        break;

      }
    
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
    doGet(request, response);
  }
}