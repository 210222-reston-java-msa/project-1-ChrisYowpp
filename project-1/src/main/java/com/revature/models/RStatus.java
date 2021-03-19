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
@Table(name="reimbursement_status")
public class RStatus {

  @Id
  @Column(name="reimb_status_id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int rsId;

  @Column(name="reimb_status")
  private String rsStatus;

  @OneToMany(mappedBy="rStatusIdFk", fetch=FetchType.LAZY)
  private List<Reimbursement> reimbStatusList = new ArrayList<>();

  public RStatus() {
  }

  public RStatus(String rsStatus) {
    this.rsStatus = rsStatus;
  }

  public RStatus(int rsId, String rsStatus) {
    this.rsId = rsId;
    this.rsStatus = rsStatus;
  }

  public RStatus(int rsId, String rsStatus, List<Reimbursement> reimbStatusList) {
    this.rsId = rsId;
    this.rsStatus = rsStatus;
    this.reimbStatusList = reimbStatusList;
  }

  public RStatus(String rsStatus, List<Reimbursement> reimbStatusList) {
    this.rsStatus = rsStatus;
    this.reimbStatusList = reimbStatusList;
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

  public List<Reimbursement> getReimbStatusList() {
    return reimbStatusList;
  }

  public void setReimbStatusList(List<Reimbursement> reimbStatusList) {
    this.reimbStatusList = reimbStatusList;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((reimbStatusList == null) ? 0 : reimbStatusList.hashCode());
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
    if (reimbStatusList == null) {
      if (other.reimbStatusList != null)
        return false;
    } else if (!reimbStatusList.equals(other.reimbStatusList))
      return false;
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
    return "RStatus [reimbStatusList=" + reimbStatusList + ", rsId=" + rsId + ", rsStatus=" + rsStatus + "]";
  }

  
}
