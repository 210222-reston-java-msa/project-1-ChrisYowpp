package com.revature.methods;

import java.util.List;

import com.revature.dao.RStatusDao;
import com.revature.models.RStatus;
import com.revature.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RStatusDaoImpl implements RStatusDao{

  @Override
  public void insert(RStatus rs) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.save(rs);
    tx.commit();
  }

  @Override
  public void update(RStatus rs) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.update(rs);
    tx.commit();
  }

  @Override
  public void delete(RStatus rs) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.delete(rs);
    tx.commit();
  }

  @Override
  public List<RStatus> selectAll() {
    Session ses = HibernateUtil.getSession();
    return ses.createQuery("from RStatus", RStatus.class).list();
  }

  @Override
  public RStatus selectById(int id) {
    Session ses = HibernateUtil.getSession();
    return ses.get(RStatus.class, id);
  }

  @Override
  public RStatus selectByStatus(String status) {
    Session ses = HibernateUtil.getSession();
    List<RStatus> rsList = ses.createQuery("from RStatus where status='"+status+"'",RStatus.class).list();

    if (rsList.isEmpty()) {
      System.out.println("No Reimbursement status found");
      return null;
    }
    return rsList.get(0);
  }
  
}
