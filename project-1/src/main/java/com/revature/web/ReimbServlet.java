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

import com.revature.models.Reimbursement;
import com.revature.service.ReimbursementService;

import org.apache.log4j.Logger;

@WebServlet("/reimb")
public class ReimbServlet extends HttpServlet {
  public static final long serialVersionUID = 1L;
  
  private static Logger log = Logger.getLogger(ReimbServlet.class);

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
    displayReimbursementsWSession(request, response);
    response.sendRedirect("reimb.jsp");

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    doGet(request, response);
  }

  // private void displayReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

  //   Gson gson = new Gson();
  //   PrintWriter pw = response.getWriter();
  //   pw.print(gson.toJson(UserService.selectAll().toString()));
  // }

  // private void displayReimbursementsWSession(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
  //   HttpSession ses = request.getSession();
  // }

  private void displayReimbursementsWSession(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    List<Reimbursement> rlist = new ArrayList<>();
    rlist = ReimbursementService.selectAll();
    HttpSession ses = request.getSession();
    ses.setAttribute("rlist", rlist);

  }
}
