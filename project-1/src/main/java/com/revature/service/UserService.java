package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.methods.UserDaoImpl;
import com.revature.models.User;

public class UserService {
  public static UserDao uDao = new UserDaoImpl();

  public static void insert(User u) {
    uDao.insert(u);
  }

  public static void update(User u) {
    uDao.update(u);
  }

  public static void delete(User u) {
    uDao.delete(u);
  }

  public static List<User> selectAll() {
    return uDao.selectAll();
  }

  public static User selectByUsername(String username) {
    List<User> all = uDao.selectAll();

    for (User u : all) {
      if (u.getuUsername().equals(username)) {
        return u;
      }
    }
    return null;
  }

  public static User confirmLogin(String username, String password) {
    User u = selectByUsername(username);
    if (u == null) {
      return null;
    }

    if (u.getuPassword().equals(password)) {
      return u;
    } else {
      return null;
    }
  }
}
