package com.revature.methods;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.models.Reimbursement;
import com.revature.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class ReimbursementDaoImpl implements ReimbursementDao {

  @Override
  public void insert(Reimbursement r) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.save(r);
    tx.commit();
  }

  @Override
  public void update(Reimbursement r) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.update(r);
    tx.commit();
  }

  @Override
  public void delete(Reimbursement r) {
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    ses.delete(r);
    tx.commit();
  }

  @Override
  public List<Reimbursement> selectAll() {
    Session ses = HibernateUtil.getSession();
    return ses.createQuery("from reimbursement", Reimbursement.class).list();
  }

  @Override
  public Reimbursement selectById(int id) {
    Session ses = HibernateUtil.getSession();
    return ses.get(Reimbursement.class, id);
  }

  @Override
  public Reimbursement selectByAmount(int amount) {
    Session ses = HibernateUtil.getSession();
    List<Reimbursement> rList = ses.createQuery("from reimbursement where amount='"+amount+"'", Reimbursement.class).list();
    
    if (rList.isEmpty()) {
      System.out.println("No Reimbursement found for that amount");
      return null;
    }
    return rList.get(0);
  }
  
}
