package com.revature.methods;

import com.revature.models.URole;
import com.revature.models.User;

public class Menus {
  
  public static int setMenuType(User u){
    URole ur =  u.getuRoleIdFk();
    int menuInt = 1;
    if (ur.getUrId() == 2){
      menuInt = 2;
    } else if (ur.getUrId() == 1) {
      menuInt = 1;
    }
  return menuInt;
  }
    
  }
