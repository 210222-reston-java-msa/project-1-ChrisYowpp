package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class URole {

  @Id
  @Column(name="user_role_id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int urId;

  @Column(name="user_role")
  private String urRole;

  @OneToMany(mappedBy="uRoleIdFk", fetch=FetchType.LAZY)
  private List<User> uRoleList = new ArrayList<>();

  public URole() {
  }

  public URole(String urRole) {
    this.urRole = urRole;
  }

  public URole(int urId, String urRole) {
    this.urId = urId;
    this.urRole = urRole;
  }

  public URole(int urId, String urRole, List<User> uRoleList) {
    this.urId = urId;
    this.urRole = urRole;
    this.uRoleList = uRoleList;
  }

  public URole(String urRole, List<User> uRoleList) {
    this.urRole = urRole;
    this.uRoleList = uRoleList;
  }

  public int getUrId() {
    return urId;
  }

  public void setUrId(int urId) {
    this.urId = urId;
  }

  public String getUrRole() {
    return urRole;
  }

  public void setUrRole(String urRole) {
    this.urRole = urRole;
  }

  public List<User> getuRoleList() {
    return uRoleList;
  }

  public void setuRoleList(List<User> uRoleList) {
    this.uRoleList = uRoleList;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((uRoleList == null) ? 0 : uRoleList.hashCode());
    result = prime * result + urId;
    result = prime * result + ((urRole == null) ? 0 : urRole.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    URole other = (URole) obj;
    if (uRoleList == null) {
      if (other.uRoleList != null)
        return false;
    } else if (!uRoleList.equals(other.uRoleList))
      return false;
    if (urId != other.urId)
      return false;
    if (urRole == null) {
      if (other.urRole != null)
        return false;
    } else if (!urRole.equals(other.urRole))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "URole [uRoleList=" + uRoleList + ", urId=" + urId + ", urRole=" + urRole + "]";
  }


}
