package com.lixu.jie_you_ba.entity;

import java.util.Date;

public class Store {
    private Long id;

    private String name;

    private String phone;

    private String address;

    private String busStop;

    private String busStopDistance;

    private String subwayStation;

    private String subwayStationDistance;

    private Integer saleAmount;

    private String deliveryTime;

    private String deliveryType;

    private String deliveryInitPrice;

    private String deliveryCost;

    private String wifiName;

    private String wifiPassword;

    private String description;

    private String openTime;

    private Date operateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBusStop() {
        return busStop;
    }

    public void setBusStop(String busStop) {
        this.busStop = busStop == null ? null : busStop.trim();
    }

    public String getBusStopDistance() {
        return busStopDistance;
    }

    public void setBusStopDistance(String busStopDistance) {
        this.busStopDistance = busStopDistance == null ? null : busStopDistance.trim();
    }

    public String getSubwayStation() {
        return subwayStation;
    }

    public void setSubwayStation(String subwayStation) {
        this.subwayStation = subwayStation == null ? null : subwayStation.trim();
    }

    public String getSubwayStationDistance() {
        return subwayStationDistance;
    }

    public void setSubwayStationDistance(String subwayStationDistance) {
        this.subwayStationDistance = subwayStationDistance == null ? null : subwayStationDistance.trim();
    }

    public Integer getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime == null ? null : deliveryTime.trim();
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType == null ? null : deliveryType.trim();
    }

    public String getDeliveryInitPrice() {
        return deliveryInitPrice;
    }

    public void setDeliveryInitPrice(String deliveryInitPrice) {
        this.deliveryInitPrice = deliveryInitPrice == null ? null : deliveryInitPrice.trim();
    }

    public String getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(String deliveryCost) {
        this.deliveryCost = deliveryCost == null ? null : deliveryCost.trim();
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName == null ? null : wifiName.trim();
    }

    public String getWifiPassword() {
        return wifiPassword;
    }

    public void setWifiPassword(String wifiPassword) {
        this.wifiPassword = wifiPassword == null ? null : wifiPassword.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime == null ? null : openTime.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}