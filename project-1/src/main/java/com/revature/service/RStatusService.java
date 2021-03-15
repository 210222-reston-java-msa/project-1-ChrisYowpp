package com.revature.service;

import com.revature.dao.RStatusDao;
import com.revature.methods.RStatusDaoImpl;
import com.revature.models.RStatus;

public class RStatusService {
  public static RStatusDao rsDao = new RStatusDaoImpl();

  public static void insert(RStatus rs) {
    rsDao.insert(rs);
  }
}
