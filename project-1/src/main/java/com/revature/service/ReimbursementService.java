package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.methods.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;
import com.revature.util.HibernateUtil;

import org.hibernate.Session;

public class ReimbursementService {

  private static ReimbursementDao rDao = new ReimbursementDaoImpl();
  private static Reimbursement reimb = new Reimbursement();
  
  public static void insert (Reimbursement r) {
    rDao.insert(r);
  }

  public static List<Reimbursement> selectAll() {
    return rDao.selectAll();
  }

  public static void reimbManip() {
    Session ses = HibernateUtil.getSession();
    ses.beginTransaction();
    reimb = ses.get(Reimbursement.class, 1);
    System.out.println("Reimbursement retrieved is" + reimb.getrAmount());
  }
}
