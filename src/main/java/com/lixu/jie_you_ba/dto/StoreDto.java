package com.lixu.jie_you_ba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Classname StoreDto
 * @Description TODO
 * @Date 2019-03-23 00:59
 * @Created by lixu
 */
@Setter
@Getter
public class StoreDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long storeIdSearch;

    private String storeNameSearch;

    private String storeTypeSearch;
}
