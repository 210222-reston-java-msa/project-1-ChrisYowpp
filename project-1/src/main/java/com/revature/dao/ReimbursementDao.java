package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {
  
  public void insert(Reimbursement r);
  public void update(Reimbursement r);
  public void delete(Reimbursement r);

  public List<Reimbursement> selectAll();
  public Reimbursement selectById(int id);
  public Reimbursement selectByAmount(int amount);

}
