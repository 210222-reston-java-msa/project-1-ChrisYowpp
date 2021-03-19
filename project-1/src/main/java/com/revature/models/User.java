package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.revature.methods.UserSerializer;

@JsonSerialize(using=UserSerializer.class)
@Cacheable
@Entity
@Table(name="users")
public class User {
  
 @Id
 @Column(name="users_id")
 @GeneratedValue(strategy=GenerationType.AUTO)
 private int uId;
 
 @Column(name="username", unique=true, nullable=false)
 private String uUsername;

 @Column(name="password")
 private String uPassword;

 @Column(name="first_name")
 private String uFirstName;

 @Column(name="last_name")
 private String uLastName;

 @Column(name="email")
 private String uEmail;

 @OneToMany(mappedBy="rAuthorFk", fetch = FetchType.LAZY)
 private List<Reimbursement> reimbList = new ArrayList<>();

 @OneToMany(mappedBy="rResolverFk", fetch=FetchType.LAZY)
 private List<Reimbursement> reimbResolverList = new ArrayList<>();

 @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
 @JoinColumn(name="role_id_fk")
 private URole uRoleIdFk;

 public User() {
}

public User(int uId, String uUsername, String uPassword, String uFirstName, String uLastName, String uEmail,
    List<Reimbursement> reimbList, List<Reimbursement> reimbResolverList, URole uRoleIdFk) {
  this.uId = uId;
  this.uUsername = uUsername;
  this.uPassword = uPassword;
  this.uFirstName = uFirstName;
  this.uLastName = uLastName;
  this.uEmail = uEmail;
  this.reimbList = reimbList;
  this.reimbResolverList = reimbResolverList;
  this.uRoleIdFk = uRoleIdFk;
}

public User(String uUsername, String uPassword, String uFirstName, String uLastName, String uEmail,
    List<Reimbursement> reimbList, List<Reimbursement> reimbResolverList, URole uRoleIdFk) {
  this.uUsername = uUsername;
  this.uPassword = uPassword;
  this.uFirstName = uFirstName;
  this.uLastName = uLastName;
  this.uEmail = uEmail;
  this.reimbList = reimbList;
  this.reimbResolverList = reimbResolverList;
  this.uRoleIdFk = uRoleIdFk;
}

public User(String uUsername, String uPassword, String uFirstName, String uLastName, String uEmail, URole uRoleIdFk) {
  this.uUsername = uUsername;
  this.uPassword = uPassword;
  this.uFirstName = uFirstName;
  this.uLastName = uLastName;
  this.uEmail = uEmail;
  this.uRoleIdFk = uRoleIdFk;
}

public int getuId() {
  return uId;
}

public void setuId(int uId) {
  this.uId = uId;
}

public String getuUsername() {
  return uUsername;
}

public void setuUsername(String uUsername) {
  this.uUsername = uUsername;
}

public String getuPassword() {
  return uPassword;
}

public void setuPassword(String uPassword) {
  this.uPassword = uPassword;
}

public String getuFirstName() {
  return uFirstName;
}

public void setuFirstName(String uFirstName) {
  this.uFirstName = uFirstName;
}

public String getuLastName() {
  return uLastName;
}

public void setuLastName(String uLastName) {
  this.uLastName = uLastName;
}

public String getuEmail() {
  return uEmail;
}

public void setuEmail(String uEmail) {
  this.uEmail = uEmail;
}

public List<Reimbursement> getReimbList() {
  return reimbList;
}

public void setReimbList(List<Reimbursement> reimbList) {
  this.reimbList = reimbList;
}

public List<Reimbursement> getReimbResolverList() {
  return reimbResolverList;
}

public void setReimbResolverList(List<Reimbursement> reimbResolverList) {
  this.reimbResolverList = reimbResolverList;
}

public URole getuRoleIdFk() {
  return uRoleIdFk;
}

public void setuRoleIdFk(URole uRoleIdFk) {
  this.uRoleIdFk = uRoleIdFk;
}

@Override
public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + ((reimbList == null) ? 0 : reimbList.hashCode());
  result = prime * result + ((reimbResolverList == null) ? 0 : reimbResolverList.hashCode());
  result = prime * result + ((uEmail == null) ? 0 : uEmail.hashCode());
  result = prime * result + ((uFirstName == null) ? 0 : uFirstName.hashCode());
  result = prime * result + uId;
  result = prime * result + ((uLastName == null) ? 0 : uLastName.hashCode());
  result = prime * result + ((uPassword == null) ? 0 : uPassword.hashCode());
  result = prime * result + ((uUsername == null) ? 0 : uUsername.hashCode());
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
  User other = (User) obj;
  if (reimbList == null) {
    if (other.reimbList != null)
      return false;
  } else if (!reimbList.equals(other.reimbList))
    return false;
  if (reimbResolverList == null) {
    if (other.reimbResolverList != null)
      return false;
  } else if (!reimbResolverList.equals(other.reimbResolverList))
    return false;
  if (uEmail == null) {
    if (other.uEmail != null)
      return false;
  } else if (!uEmail.equals(other.uEmail))
    return false;
  if (uFirstName == null) {
    if (other.uFirstName != null)
      return false;
  } else if (!uFirstName.equals(other.uFirstName))
    return false;
  if (uId != other.uId)
    return false;
  if (uLastName == null) {
    if (other.uLastName != null)
      return false;
  } else if (!uLastName.equals(other.uLastName))
    return false;
  if (uPassword == null) {
    if (other.uPassword != null)
      return false;
  } else if (!uPassword.equals(other.uPassword))
    return false;
  if (uUsername == null) {
    if (other.uUsername != null)
      return false;
  } else if (!uUsername.equals(other.uUsername))
    return false;
  return true;
}

@Override
public String toString() {
  return "User [reimbList=" + reimbList + ", reimbResolverList=" + reimbResolverList + ", uEmail=" + uEmail
      + ", uFirstName=" + uFirstName + ", uId=" + uId + ", uLastName=" + uLastName + ", uPassword=" + uPassword
      + ", uUsername=" + uUsername + "]";
}





}