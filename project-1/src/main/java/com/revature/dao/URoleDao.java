package com.revature.dao;

import java.util.List;

import com.revature.models.URole;

public interface URoleDao {

  public void insert(URole ur);
  public void update(URole ur);
  public void delete(URole ur);

  public List<URole> selectAll();
  public URole selectById(int id);
  public URole selectByRole(String role);
  
}
