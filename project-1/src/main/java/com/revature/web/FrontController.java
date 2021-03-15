package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.methods.Setup;
import com.revature.util.RequestHelper;

public class FrontController extends HttpServlet {
  public static final long serialVersionUID = 1L;

  public FrontController() {
    super();
    //Setup.initialValues();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    final String URI = req.getRequestURI().replace("/project-1/", "");

    switch(URI) {
      case "login":
        RequestHelper.processLogin(req, res);
        break;

      case "logout":
        RequestHelper.processLogout(req, res);
        break;

      case "users":
        RequestHelper.processUsers(req, res);
        break;
      
      case "error":
        RequestHelper.processError(req, res);
        break;
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    System.out.println("In doPost");
    System.out.println("\n About to Select All");
    System.out.println();
  }
}
