package com.lixu.jie_you_ba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Classname LoginUserVo
 * @Description TODO
 * @Date 2019-03-15 13:51
 * @Created by lixu
 */
public class LoginUserVo {
    @JsonProperty("admin_id")
    private Long adminId;

    public Long getAdminId() {
        if(null != adminId){
            return adminId;
        }
        return null;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
