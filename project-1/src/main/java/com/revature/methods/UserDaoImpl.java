package com.revature.methods;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDaoImpl implements UserDao {

  @Override
  public void insert(User u) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.save(u);
    tx.commit();
  }

  @Override
  public void update(User u) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.update(u);
    tx.commit();
  }

  @Override
  public void delete(User u) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.delete(u);
    tx.commit();
  }

  @Override
  public List<User> selectAll() {
    Session ses = HibernateUtil.getSession();
    return ses.createQuery("from user", User.class).list();
  }

  @Override
  public User selectById(int id) {
    Session ses = HibernateUtil.getSession();
    return ses.get(User.class, id);
  }

  @Override
  public User selectByName(String name) {
    Session ses = HibernateUtil.getSession();
    List<User> uList = ses.createQuery("from user where name='"+name+"'", User.class).list();

    if (uList.isEmpty()) {
      System.out.println("No User found with that name");
      return null;
    }

    return uList.get(0);
  }
  
}
