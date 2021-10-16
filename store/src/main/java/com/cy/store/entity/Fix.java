package com.cy.store.entity;

import java.io.Serializable;

public class Fix extends BaseEntity implements Serializable {
    private  Integer fid;
    private String name;
    private String address;
    private  String phone;
    private  String reason;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fix)) return false;
        if (!super.equals(o)) return false;

        Fix fix = (Fix) o;

        if (getFid() != null ? !getFid().equals(fix.getFid()) : fix.getFid() != null) return false;
        if (getName() != null ? !getName().equals(fix.getName()) : fix.getName() != null) return false;
        if (getAddress() != null ? !getAddress().equals(fix.getAddress()) : fix.getAddress() != null) return false;
        if (getPhone() != null ? !getPhone().equals(fix.getPhone()) : fix.getPhone() != null) return false;
        return getReason() != null ? getReason().equals(fix.getReason()) : fix.getReason() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getFid() != null ? getFid().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getReason() != null ? getReason().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Fix{" +
                "fid=" + fid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
