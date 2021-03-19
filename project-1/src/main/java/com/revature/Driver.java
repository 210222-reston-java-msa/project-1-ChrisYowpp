package com.revature;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;
import com.revature.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Driver {
  public static void main(String[] args) {
    
    Session ses = HibernateUtil.getSession();
    Transaction tx = ses.beginTransaction();
    
    List<Reimbursement> reimb1 = ReimbursementService.selectAll();
    List<User> ulist = UserService.selectAll();


    tx.commit();

    
    System.out.println(reimb1);
    
    System.out.println(ulist);

  }
  
}
