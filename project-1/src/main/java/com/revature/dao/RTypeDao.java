package com.revature.dao;

import java.util.List;

import com.revature.models.RType;

public interface RTypeDao {
  
  public void insert(RType rt);
  public void update(RType rt);
  public void delete(RType rt);

  public List<RType> selectAll();
  public RType selectById(int id);
  public RType selectByType(String type);

}
