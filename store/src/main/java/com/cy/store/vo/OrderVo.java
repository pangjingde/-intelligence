package com.cy.store.vo;

import java.io.Serializable;
import java.util.Date;

public class OrderVo implements Serializable {
    private Integer uid;
    private Integer pid;
    private Integer oid;
    private Long price;
    private Integer num;
    private String title;
    private Long realPrice;
    private String image;
    private String recvName;
    private Date createdTime;
    private Integer status;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Long realPrice) {
        this.realPrice = realPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderVo)) return false;

        OrderVo orderVo = (OrderVo) o;

        if (getUid() != null ? !getUid().equals(orderVo.getUid()) : orderVo.getUid() != null) return false;
        if (getPid() != null ? !getPid().equals(orderVo.getPid()) : orderVo.getPid() != null) return false;
        if (getOid() != null ? !getOid().equals(orderVo.getOid()) : orderVo.getOid() != null) return false;
        if (getPrice() != null ? !getPrice().equals(orderVo.getPrice()) : orderVo.getPrice() != null) return false;
        if (getNum() != null ? !getNum().equals(orderVo.getNum()) : orderVo.getNum() != null) return false;
        if (getTitle() != null ? !getTitle().equals(orderVo.getTitle()) : orderVo.getTitle() != null) return false;
        if (getRealPrice() != null ? !getRealPrice().equals(orderVo.getRealPrice()) : orderVo.getRealPrice() != null)
            return false;
        if (getImage() != null ? !getImage().equals(orderVo.getImage()) : orderVo.getImage() != null) return false;
        if (getRecvName() != null ? !getRecvName().equals(orderVo.getRecvName()) : orderVo.getRecvName() != null)
            return false;
        if (getCreatedTime() != null ? !getCreatedTime().equals(orderVo.getCreatedTime()) : orderVo.getCreatedTime() != null)
            return false;
        return getStatus() != null ? getStatus().equals(orderVo.getStatus()) : orderVo.getStatus() == null;
    }

    @Override
    public int hashCode() {
        int result = getUid() != null ? getUid().hashCode() : 0;
        result = 31 * result + (getPid() != null ? getPid().hashCode() : 0);
        result = 31 * result + (getOid() != null ? getOid().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getNum() != null ? getNum().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getRealPrice() != null ? getRealPrice().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        result = 31 * result + (getRecvName() != null ? getRecvName().hashCode() : 0);
        result = 31 * result + (getCreatedTime() != null ? getCreatedTime().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "uid=" + uid +
                ", pid=" + pid +
                ", oid=" + oid +
                ", price=" + price +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", realPrice=" + realPrice +
                ", image='" + image + '\'' +
                ", recvName='" + recvName + '\'' +
                ", createdTime=" + createdTime +
                ", status=" + status +
                '}';
    }
}
