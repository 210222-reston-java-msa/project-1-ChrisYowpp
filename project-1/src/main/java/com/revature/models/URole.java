package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

  public URole() {
  }

  public URole(String urRole) {
    this.urRole = urRole;
  }

  public URole(int urId, String urRole) {
    this.urId = urId;
    this.urRole = urRole;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
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
    return "URole [urId=" + urId + ", urRole=" + urRole + "]";
  }

  
}
