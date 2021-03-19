package com.revature.methods;

import com.revature.models.RStatus;
import com.revature.models.RType;
import com.revature.models.Reimbursement;
import com.revature.models.URole;
import com.revature.models.User;
import com.revature.service.RStatusService;
import com.revature.service.RTypeService;
import com.revature.service.ReimbursementService;
import com.revature.service.URoleService;
import com.revature.service.UserService;

public class Setup {
  public static void initialValues() {
    URole ur1 = new URole("Employee");
    URole ur2 = new URole("Manager");
    
    URoleService.insert(ur1);
    URoleService.insert(ur2);

    User u1 = new User("Batman", "batz123", "Bruce", "Wayne", "Bwayne@gmail.com", ur2);
    User u2 = new User("Spiderman", "spidey123", "Peter", "Parker", "Spidey@gmail.com", ur1);

    UserService.insert(u1);
    UserService.insert(u2);

    RType rt1 = new RType("LODGING");
    RType rt2 = new RType("TRAVEL");
    RType rt3 = new RType("FOOD");
    RType rt4 = new RType("OTHER");

    RTypeService.insert(rt1);
    RTypeService.insert(rt2);
    RTypeService.insert(rt3);
    RTypeService.insert(rt4);

    RStatus rs1 = new RStatus("Pending");
    RStatus rs2 = new RStatus("Approved");
    RStatus rs3 = new RStatus("Denied");

    RStatusService.insert(rs1);
    RStatusService.insert(rs2);
    RStatusService.insert(rs3);

    Reimbursement r1 = new Reimbursement(2000, "fees", u2, u1, rs1, rt1);
    Reimbursement r2 = new Reimbursement(3500, "fees", u2, u1, rs2, rt2);
    Reimbursement r3 = new Reimbursement(5500, "fees", u2, u1, rs3, rt4);

    ReimbursementService.insert(r1);
    ReimbursementService.insert(r2);
    ReimbursementService.insert(r3);
    

  }
}
