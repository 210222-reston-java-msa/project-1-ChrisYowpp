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
@Table(name="reimbursement_type")
public class RType {

  @Id
  @Column(name="reimb_type_id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int rtId;

  @Column(name="reimb_type")
  private String rtType;

  @OneToMany(mappedBy="rTypeIdFk", fetch=FetchType.LAZY)
  private List<Reimbursement> reimbTypeList = new ArrayList<>();

  public RType() {
  }

  public RType(String rtType) {
    this.rtType = rtType;
  }

  public RType(int rtId, String rtType) {
    this.rtId = rtId;
    this.rtType = rtType;
  }

  public RType(int rtId, String rtType, List<Reimbursement> reimbTypeList) {
    this.rtId = rtId;
    this.rtType = rtType;
    this.reimbTypeList = reimbTypeList;
  }

  public RType(String rtType, List<Reimbursement> reimbTypeList) {
    this.rtType = rtType;
    this.reimbTypeList = reimbTypeList;
  }

  public int getRtId() {
    return rtId;
  }

  public void setRtId(int rtId) {
    this.rtId = rtId;
  }

  public String getRtType() {
    return rtType;
  }

  public void setRtType(String rtType) {
    this.rtType = rtType;
  }

  public List<Reimbursement> getReimbTypeList() {
    return reimbTypeList;
  }

  public void setReimbTypeList(List<Reimbursement> reimbTypeList) {
    this.reimbTypeList = reimbTypeList;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((reimbTypeList == null) ? 0 : reimbTypeList.hashCode());
    result = prime * result + rtId;
    result = prime * result + ((rtType == null) ? 0 : rtType.hashCode());
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
    RType other = (RType) obj;
    if (reimbTypeList == null) {
      if (other.reimbTypeList != null)
        return false;
    } else if (!reimbTypeList.equals(other.reimbTypeList))
      return false;
    if (rtId != other.rtId)
      return false;
    if (rtType == null) {
      if (other.rtType != null)
        return false;
    } else if (!rtType.equals(other.rtType))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "RType [reimbTypeList=" + reimbTypeList + ", rtId=" + rtId + ", rtType=" + rtType + "]";
  }

 
}
