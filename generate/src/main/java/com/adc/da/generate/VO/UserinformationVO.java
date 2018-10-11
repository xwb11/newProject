package com.adc.da.generate.VO;

import com.adc.da.generate.entity.UserinformationEO;

public class UserinformationVO extends UserinformationEO {
    private String userLoginRole;

    public String getUserLoginRole() {
        return userLoginRole;
    }

    public void setUserLoginRole(String userLoginRole) {
        this.userLoginRole = userLoginRole;
    }
}
