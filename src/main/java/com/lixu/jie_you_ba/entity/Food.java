package com.lixu.jie_you_ba.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Food {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long storeId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long foodCatalogId;

    private String name;

    private Integer count;

    private Float price;

    private String praise;

    private String image;

    private String createPerson;

    private Date createTime;

    private String updatePerson;

    private Date updateTime;

    private Float sale;

    private Float salePrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getFoodCatalogId() {
        return foodCatalogId;
    }

    public void setFoodCatalogId(Long foodCatalogId) {
        this.foodCatalogId = foodCatalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise == null ? null : praise.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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

    public Float getSale() {
        return sale;
    }

    public void setSale(Float sale) {
        this.sale = sale;
    }

    public Float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }
}