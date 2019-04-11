package com.lixu.jie_you_ba.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Order {

    //在订单详情页面需要返回该订单的菜单
    private List<FoodSale> foodSaleList;

    public List<FoodSale> getFoodSaleList() {
        return foodSaleList;
    }

    public void setFoodSaleList(List<FoodSale> foodSaleList) {
        this.foodSaleList = foodSaleList;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long storeId;

    private Float deliveryCost;

    private Float totalCost;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long couponId;

    private Float payCost;

    private String payType;

    private String remark;

    private String orderName;

    private String orderPhone;

    private String orderAddress;

    private String deliveryName;

    private String deliveryPhone;

    private Integer status;

    private String createPerson;

    @JsonFormat(pattern="yyyy.MM.dd HH:mm",timezone = "GMT+8")
    private Date createTime;

    private String updatePerson;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Float getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Float deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Float getPayCost() {
        return payCost;
    }

    public void setPayCost(Float payCost) {
        this.payCost = payCost;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone == null ? null : orderPhone.trim();
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress == null ? null : orderAddress.trim();
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName == null ? null : deliveryName.trim();
    }

    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    public void setDeliveryPhone(String deliveryPhone) {
        this.deliveryPhone = deliveryPhone == null ? null : deliveryPhone.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson == null ? null : updatePerson.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}