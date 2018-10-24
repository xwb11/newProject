package com.adc.da.generate.VO;

import com.adc.da.generate.entity.ExamineeinformationEO;
import com.adc.da.generate.entity.UserinformationEO;

public class UserinformationVO extends UserinformationEO {
    private String userLoginRole;

    private UserinformationEO userinformationEO;
    private String examineeKey;
    private String quasiExaminationNumber;

    public String getExamineeKey() {
        return examineeKey;
    }

    public void setExamineeKey(String examineeKey) {
        this.examineeKey = examineeKey;
    }

    public String getQuasiExaminationNumber() {
        return quasiExaminationNumber;
    }

    public void setQuasiExaminationNumber(String quasiExaminationNumber) {
        this.quasiExaminationNumber = quasiExaminationNumber;
    }

    public UserinformationEO getUserinformationEO() {
        return userinformationEO;
    }

    public void setUserinformationEO(UserinformationEO userinformationEO) {
        this.userinformationEO = userinformationEO;
    }


    public String getUserLoginRole() {
        return userLoginRole;
    }

    public void setUserLoginRole(String userLoginRole) {
        this.userLoginRole = userLoginRole;
    }
}
