package com.lixu.jie_you_ba.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Store {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String name;

    private String type;

    private String phone;

    private String address;

    @JsonProperty("bus_stop")
    private String busStop;

    @JsonProperty("bus_stop_distance")
    private String busStopDistance;

    @JsonProperty("subway_station")
    private String subwayStation;

    @JsonProperty("subway_station_distance")
    private String subwayStationDistance;

    @JsonProperty("sale_amount")
    private Integer saleAmount;

    @JsonProperty("delivery_time")
    private String deliveryTime;

    @JsonProperty("delivery_type")
    private String deliveryType;

    @JsonProperty("delivery_init_price")
    private String deliveryInitPrice;

    @JsonProperty("delivery_cost")
    private String deliveryCost;

    @JsonProperty("wifi_name")
    private String wifiName;

    @JsonProperty("wifi_password")
    private String wifiPassword;

    private String description;

    @JsonProperty("open_time")
    private String openTime;

    @JsonProperty("create_person")
    private String createPerson;

    @JsonProperty("create_time")
    private Date createTime;

    @JsonProperty("update_person")
    private String updatePerson;

    @JsonProperty("update_time")
    private Date updateTime;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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