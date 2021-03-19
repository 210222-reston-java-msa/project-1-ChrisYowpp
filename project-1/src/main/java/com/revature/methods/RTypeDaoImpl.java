package com.revature.methods;

import java.util.List;

import com.revature.dao.RTypeDao;
import com.revature.models.RType;
import com.revature.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RTypeDaoImpl implements RTypeDao{

  @Override
  public void insert(RType rt) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.save(rt);
    tx.commit();
  }

  @Override
  public void update(RType rt) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.update(rt);
    tx.commit();
  }

  @Override
  public void delete(RType rt) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.delete(rt);
    tx.commit();
  }

  @Override
  public List<RType> selectAll() {
    Session ses = HibernateUtil.getSession();
    return ses.createQuery("from RType", RType.class).list();
  }

  @Override
  public RType selectById(int id) {
    Session ses = HibernateUtil.getSession();
    return ses.get(RType.class, id);
  }

  @Override
  public RType selectByType(String type) {
    Session ses = HibernateUtil.getSession();
    List<RType> rtList = ses.createQuery("from User where type='"+type+"'", RType.class).list();
    
    if (rtList.isEmpty()) {
      System.out.println("No Reimbursement Type found with that name");
      return null;
    }
    return rtList.get(0);
  }
  
}
