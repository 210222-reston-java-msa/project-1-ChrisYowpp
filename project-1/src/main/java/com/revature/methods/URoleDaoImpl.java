package com.revature.methods;

import java.util.List;

import com.revature.dao.URoleDao;
import com.revature.models.URole;
import com.revature.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class URoleDaoImpl implements URoleDao{

  @Override
  public void insert(URole ur) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.save(ur);
    tx.commit();
  }

  @Override
  public void update(URole ur) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.update(ur);
    tx.commit();
  }

  @Override
  public void delete(URole ur) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.delete(ur);
    tx.commit();
  }

  @Override
  public List<URole> selectAll() {
    Session ses = HibernateUtil.getSession();
    return ses.createQuery("from user_role", URole.class).list();
  }

  @Override
  public URole selectById(int id) {
    Session ses = HibernateUtil.getSession();
    return ses.get(URole.class, id);
  }

  @Override
  public URole selectByRole(String role) {
    Session ses = HibernateUtil.getSession();
    List<URole> urList = ses.createQuery("from user_role where role='"+role+"'", URole.class).list();
    
    if(urList.isEmpty()) {
      System.out.println("No URole found with that role");
      return null;
    }
    return urList.get(0);
  }
  
}
