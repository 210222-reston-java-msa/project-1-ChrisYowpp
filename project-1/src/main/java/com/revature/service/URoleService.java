package com.revature.service;

import com.revature.dao.URoleDao;
import com.revature.methods.URoleDaoImpl;
import com.revature.models.URole;

public class URoleService {
  public static URoleDao urDao = new URoleDaoImpl();

  public static void insert(URole ur) {
    urDao.insert(ur);
  }

  public static URole selectById(int id) {
    return urDao.selectById(id);
  }
}
