package com.adc.da.generate.VO;

import com.adc.da.generate.entity.ExamineeinformationEO;
import com.adc.da.generate.entity.ExamineevolunteerinformationEO;
import com.adc.da.generate.entity.UserinformationEO;

import java.util.Date;

public class ExamineeinformationVO extends ExamineeinformationEO {
    private ExamineeinformationEO examineeinformationEO;
    private UserinformationEO userinformationEO;

    public ExamineeinformationEO getExamineeinformationEO() {
        return examineeinformationEO;
    }

    public void setExamineeinformationEO(ExamineeinformationEO examineeinformationEO) {
        this.examineeinformationEO = examineeinformationEO;
    }

    public UserinformationEO getUserinformationEO() {
        return userinformationEO;
    }

    public void setUserinformationEO(UserinformationEO userinformationEO) {
        this.userinformationEO = userinformationEO;
    }
}
