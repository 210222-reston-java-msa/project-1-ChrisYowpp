package com.revature.service;

import com.revature.dao.ReimbursementDao;
import com.revature.methods.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;

public class ReimbursementService {
  public static ReimbursementDao rDao = new ReimbursementDaoImpl();
  
  public static void insert (Reimbursement r) {
    rDao.insert(r);
  }
}
