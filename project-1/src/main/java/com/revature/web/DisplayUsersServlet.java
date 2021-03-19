package com.revature.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.User;
import com.revature.service.UserService;

import org.apache.log4j.Logger;

@WebServlet("/display")
public class DisplayUsersServlet extends HttpServlet {
  public static final long serialVersionUID = 1L;

  private static Logger log = Logger.getLogger(DisplayUsersServlet.class);

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    //displayUsers(request, response);

    displayUsersWSession(request, response); 

    // setAtTest(request, response);

    response.sendRedirect("users.jsp");
    
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    doGet(request, response);
  }

  // private void grabUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

  //   HttpSession ses;
  //   ses = request.getSession();

  //   User u = (User) UserService.selectAll();

  //   List<User> ulist =UserService.selectAll();

  //   UserTable userTable = new UserTable();

  //   for (int i = 0; i < ulist.size(); i++){ 

  //    u = ulist.get(i);

  //    userTable.setUtUsername(u.getuUsername());
  //    userTable.setUtFirstName(u.getuFirstName());
  //    userTable.setUtLastName(u.getuLastName());
  //    userTable.setUtEmail(u.getuEmail());

  //    ses.setAttribute ("currentU", userTable);

     
  //   }
    

    

  //   ulist.add(u);

  //   request.setAttribute("userslist", ulist);
    
  //   // Session ses = HibernateUtil.getSession();
    

  //   // System.out.println(user);
    

  // }

  // private void displayUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
  //   Gson gson = new Gson();
  //   PrintWriter pw = response.getWriter();

  //   pw.print(gson.toJson(UserService.selectAll().toString()));
    

    
  //     // response.setContentType("text/html");

      
  //     // u = UserService.selectAll();
  //     // PrintWriter pw = response.getWriter();

  //     // pw.println("<html><body><table><tr><td>Username</td><td>First Name</td><td>Last Name</td>Email</td></tr></table></body></html>");

  //     // while(rs.next) {
  //     //   pw.println("<tr><td>"+rs.getString(1)+"</tr></td>""<tr><td>"+rs.getString(2)+"</tr></td>""<tr><td>"+rs.getString(3)+"</tr></td>""<tr><td>"+rs.getString(4)+"</tr></td>");
  //     // }

  //     // request.setAttribute("userslist", u);
  //     // response.sendRedirect("users.jsp");



  //   // User u = (User) UserService.selectAll();

  //   // User user = new User();
    
  //   //  user.setuId(u.getuId());
  //   //  user.setuUsername(u.getuUsername());
  //   //  user.setuPassword(u.getuPassword());
  //   //  user.setuFirstName(u.getuFirstName());
  //   //  user.setuLastName(u.getuLastName());
  //   //  user.setuEmail(u.getuEmail());

  //   // List<User> ulist =UserService.selectAll();

  //   // ulist.add(u);

  //   // request.setAttribute("userslist", ulist);
    
  //   // Session ses = HibernateUtil.getSession();
    

  //   // System.out.println(user);
    
  // }

  private void displayUsersWSession(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    List<User> ulist = new ArrayList<>();
    ulist = UserService.selectAll();
    HttpSession ses = request.getSession();
    ses.setAttribute("ulist", ulist);
  }

  // private void setAtTest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
  //   int y = 1;
  //   HttpSession ses = request.getSession();
  //   ses.setAttribute("testing", y);
  // }

}
