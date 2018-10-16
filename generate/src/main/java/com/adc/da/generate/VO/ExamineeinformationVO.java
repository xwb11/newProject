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

    private String userkey;
    private String useraccount;
    private String userpassword;
    private String userrole;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private String status;

    @Override
    public String getUserkey() {
        return userkey;
    }

    @Override
    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
