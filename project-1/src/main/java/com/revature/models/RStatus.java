package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reimbursement_status")
public class RStatus {

  @Id
  @Column(name="reimb_status_id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int rsId;

  @Column(name="reimb_status")
  private String rsStatus;

  public RStatus() {
  }

  public RStatus(String rsStatus) {
    this.rsStatus = rsStatus;
  }

  public RStatus(int rsId, String rsStatus) {
    this.rsId = rsId;
    this.rsStatus = rsStatus;
  }

  public int getRsId() {
    return rsId;
  }

  public void setRsId(int rsId) {
    this.rsId = rsId;
  }

  public String getRsStatus() {
    return rsStatus;
  }

  public void setRsStatus(String rsStatus) {
    this.rsStatus = rsStatus;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + rsId;
    result = prime * result + ((rsStatus == null) ? 0 : rsStatus.hashCode());
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
    RStatus other = (RStatus) obj;
    if (rsId != other.rsId)
      return false;
    if (rsStatus == null) {
      if (other.rsStatus != null)
        return false;
    } else if (!rsStatus.equals(other.rsStatus))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "RStatus [rsId=" + rsId + ", rsStatus=" + rsStatus + "]";
  }

  
}
