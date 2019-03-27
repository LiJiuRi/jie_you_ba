package com.lixu.jie_you_ba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

/**
 * @Classname AdminDto
 * @Description TODO
 * @Date 2019-03-27 16:15
 * @Created by lixu
 */
@Setter
@Getter
public class AdminDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userIdSearch;

    private String userNameSearch;
}
