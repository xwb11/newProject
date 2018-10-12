package com.adc.da.generate.VO;

import com.adc.da.generate.entity.SchoolinformationEO;

public class SchoolinformationVO extends SchoolinformationEO {
    private String userLoginRole;

    public String getUserLoginRole() {
        return userLoginRole;
    }

    public void setUserLoginRole(String userLoginRole) {
        this.userLoginRole = userLoginRole;
    }
}
