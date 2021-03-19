package com.revature.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.methods.Setup;
import com.revature.models.URole;
import com.revature.models.User;
import com.revature.service.ReimbursementService;
import com.revature.service.URoleService;
import com.revature.service.UserService;

import org.apache.log4j.Logger;

@WebServlet("/register")
public class RegServlet extends HttpServlet {

  private static Logger log = Logger.getLogger(RegServlet.class);

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.sendRedirect("reg.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    register(request, response);
  }

  private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    URole regRole = URoleService.selectById(1);

    User u = new User();
    u.setuUsername(username);
    u.setuPassword(password);
    u.setuFirstName(firstName);
    u.setuLastName(lastName);
    u.setuRoleIdFk(regRole);
    u.setuEmail(email);
    
    UserService.insert(u);

    RequestDispatcher rd = request.getRequestDispatcher("reg.html");
    rd.forward(request, response);
    
  }
}
  
  

