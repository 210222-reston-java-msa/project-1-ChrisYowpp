package com.revature.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/logger")
public class LoginServlet  extends HttpServlet {
  public static final long serialVersionUID = 1L;

  private static Logger log = Logger.getLogger(DisplayUsersServlet.class);

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    response.sendRedirect("login.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    login(request,response);
  }

  private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    RequestDispatcher rd;

    HttpSession ses = request.getSession();
    


  //   String username = request.getParameter("username");
  //   String password = request.getParameter("password");
    
  //   User u = UserService.selectByUsername(username);

  //   String passFromDB =  u.getuPassword();

  //   if (u.getuPassword().equals(password)) {
  //     switch (u.getuRoleIdFk().getUrId()){

  //     case 1:
  //     rd = request.getRequestDispatcher("Employee.jsp");
  //     rd.forward(request, response);
  //     break;

  //     case 2:
  //     rd = request.getRequestDispatcher("Manager.jsp");
  //     rd.forward(request, response);
  //     break;

  //     default:
  //     rd = request.getRequestDispatcher("home.html");
  //     rd.forward(request, response);
  //     break;
  //     }
  //   }

   }

  
}
