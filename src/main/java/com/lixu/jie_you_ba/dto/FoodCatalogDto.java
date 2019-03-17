package com.lixu.jie_you_ba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Classname FoodCatalogDto
 * @Description TODO
 * @Date 2019-03-15 11:08
 * @Created by lixu
 */
@Setter
@Getter
public class FoodCatalogDto extends BaseInfo{

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String name;

    private List<FoodDto> foods;
}
