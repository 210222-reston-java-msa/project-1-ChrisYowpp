package com.revature.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginCredentials;
import com.revature.models.User;
import com.revature.service.UserService;

import org.apache.log4j.Logger;

public class RequestHelper {
  private static Logger log = Logger.getLogger(RequestHelper.class);
  private static ObjectMapper om = new ObjectMapper();
  
  public static void processLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
    BufferedReader reader = req.getReader();
    StringBuilder sb = new StringBuilder();
    String line = reader.readLine();

    while (line != null) {
      sb.append(line);
      line = reader.readLine();
    }

    String body = sb.toString();
    log.info(body);

    LoginCredentials loginAttempt = om.readValue(body, LoginCredentials.class);
    String loginUsername = loginAttempt.getUsername();
    String loginPassword = loginAttempt.getPassword();

    log.info("User attempted to login with the username: " + loginUsername + ", and the password: " + loginPassword);

    User uConfirm = UserService.confirmLogin(loginUsername, loginPassword);

    if (uConfirm != null) {
      HttpSession session = req.getSession();
      session.setAttribute("username", loginUsername);

      PrintWriter pw = res.getWriter();
      res.setContentType("application/json");
      pw.println(om.writeValueAsString(uConfirm));
      log.info(loginUsername + "has successfully logged in"); 
    } else {
      log.info(loginUsername + " has failed to log in");
      res.setStatus(204);
    }
  }

  public static void processLogout(HttpServletRequest req, HttpServletResponse res) {
    HttpSession session = req.getSession(false);
    log.info("Processing logout");
    if (session != null) {
      String logoutUsername = (String) session.getAttribute("username");
      log.info(logoutUsername + " has logged out ");
      session.invalidate();
    }
    res.setStatus(200);
  }

  public static void processUsers(HttpServletRequest req, HttpServletResponse res) throws IOException {
    log.info(UserService.selectAll());
    res.setContentType("application/json");
    List<User> allUsers = UserService.selectAll();
    String json = om.writeValueAsString(allUsers);
    PrintWriter pw = res.getWriter();
    pw.println(json);
  }

  public static void processError(HttpServletRequest req, HttpServletResponse res) throws IOException {
    try {
      req.getRequestDispatcher("error.html").forward(req, res);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }
}
