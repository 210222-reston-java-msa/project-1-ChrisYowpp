package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reimbursement_type")
public class RType {

  @Id
  @Column(name="reimb_type_id")
  private int rtId;

  @Column(name="reimb_type")
  private String rtType;

  public RType() {
  }

  public RType(String rtType) {
    this.rtType = rtType;
  }

  public RType(int rtId, String rtType) {
    this.rtId = rtId;
    this.rtType = rtType;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
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
    return "RType [rtId=" + rtId + ", rtType=" + rtType + "]";
  }

  
}
