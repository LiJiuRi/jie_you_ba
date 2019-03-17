package com.lixu.jie_you_ba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

/**
 * @Classname FoodDto
 * @Description TODO
 * @Date 2019-03-15 21:48
 * @Created by lixu
 */
@Setter
@Getter
public class FoodDto extends BaseInfo{
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("food_catalog_id")
    private Long foodCatalogId;

    private String name;

    private Float price;

    private Float sale;

    @JsonProperty("sale_price")
    private Float salePrice;

    private String image;

    private Integer count;

    private Integer number;
}
