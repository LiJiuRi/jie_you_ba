package com.lixu.jie_you_ba.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Coupon {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private Float value;

    private String sale;

    private String regular;

    private Float regularValue;

    private String type;

    private String status;

    private String createPerson;

    private Date createTime;

    private String updatePerson;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale == null ? null : sale.trim();
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular == null ? null : regular.trim();
    }

    public Float getRegularValue() {
        return regularValue;
    }

    public void setRegularValue(Float regularValue) {
        this.regularValue = regularValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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