package com.revature.dao;

import java.util.List;

import com.revature.models.RStatus;

public interface RStatusDao {

  public void insert(RStatus rs);
  public void update(RStatus rs);
  public void delete(RStatus rs);

  public List<RStatus> selectAll();
  public RStatus selectById(int id);
  public RStatus selectByStatus(String status);
  
}
