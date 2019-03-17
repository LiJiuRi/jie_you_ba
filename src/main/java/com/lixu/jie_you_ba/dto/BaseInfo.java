package com.lixu.jie_you_ba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @Classname BaseInfo
 * @Description TODO
 * @Date 2019-03-15 11:41
 * @Created by lixu
 */
@Data
public class BaseInfo implements Serializable {

    @JsonProperty("create_person")
    protected String createPerson;

    @JsonProperty("create_time")
    protected Date createTime;

    @JsonProperty("update_person")
    protected String updatePerson;

    @JsonProperty("update_time")
    protected Date updateTime;
}
