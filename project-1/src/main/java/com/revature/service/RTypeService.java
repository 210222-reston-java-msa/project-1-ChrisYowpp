package com.revature.service;

import com.revature.dao.RTypeDao;
import com.revature.methods.RTypeDaoImpl;
import com.revature.models.RType;

public class RTypeService {
  public static RTypeDao rtDao = new RTypeDaoImpl();

  public static void insert(RType rt) {
    rtDao.insert(rt);
  }
}
