package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reimbursement")
public class Reimbursement {
  
  @Id
  @Column(name="reimb_id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int rId;

  @Column(name="reimb_amount")
  private int rAmount;

  @Column(name="reimb_description")
  private String rDescription;

  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  @JoinColumn(name="author_fk")
  private User rAuthorFk;

  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  @JoinColumn(name="resolver_fk")
  private User rResolverFk;

  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  @JoinColumn(name="status_id_fk")
  private RStatus rStatusIdFk;

  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
  @JoinColumn(name="type_id_fk")
  private RType rTypeIdFk;

  public Reimbursement() {
  }

  public Reimbursement(int rAmount, String rDescription, User rAuthorFk, User rResolverFk, RStatus rStatusIdFk,
      RType rTypeIdFk) {
    this.rAmount = rAmount;
    this.rDescription = rDescription;
    this.rAuthorFk = rAuthorFk;
    this.rResolverFk = rResolverFk;
    this.rStatusIdFk = rStatusIdFk;
    this.rTypeIdFk = rTypeIdFk;
  }

  public Reimbursement(int rId, int rAmount, String rDescription, User rAuthorFk, User rResolverFk, RStatus rStatusIdFk,
      RType rTypeIdFk) {
    this.rId = rId;
    this.rAmount = rAmount;
    this.rDescription = rDescription;
    this.rAuthorFk = rAuthorFk;
    this.rResolverFk = rResolverFk;
    this.rStatusIdFk = rStatusIdFk;
    this.rTypeIdFk = rTypeIdFk;
  }

  public int getrId() {
    return rId;
  }

  public void setrId(int rId) {
    this.rId = rId;
  }

  public int getrAmount() {
    return rAmount;
  }

  public void setrAmount(int rAmount) {
    this.rAmount = rAmount;
  }

  public String getrDescription() {
    return rDescription;
  }

  public void setrDescription(String rDescription) {
    this.rDescription = rDescription;
  }

  public User getrAuthorFk() {
    return rAuthorFk;
  }

  public void setrAuthorFk(User rAuthorFk) {
    this.rAuthorFk = rAuthorFk;
  }

  public User getrResolverFk() {
    return rResolverFk;
  }

  public void setrResolverFk(User rResolverFk) {
    this.rResolverFk = rResolverFk;
  }

  public RStatus getrStatusIdFk() {
    return rStatusIdFk;
  }

  public void setrStatusIdFk(RStatus rStatusIdFk) {
    this.rStatusIdFk = rStatusIdFk;
  }

  public RType getrTypeIdFk() {
    return rTypeIdFk;
  }

  public void setrTypeIdFk(RType rTypeIdFk) {
    this.rTypeIdFk = rTypeIdFk;
  }


  @Override
  public String toString() {
    return "Reimbursement [rAmount=" + rAmount + ", rDescription=" + rDescription + ", rId=" + rId + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + rAmount;
    result = prime * result + ((rDescription == null) ? 0 : rDescription.hashCode());
    result = prime * result + rId;
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
    Reimbursement other = (Reimbursement) obj;
    if (rAmount != other.rAmount)
      return false;
    if (rDescription == null) {
      if (other.rDescription != null)
        return false;
    } else if (!rDescription.equals(other.rDescription))
      return false;
    if (rId != other.rId)
      return false;
    return true;
  }


  
  
}
