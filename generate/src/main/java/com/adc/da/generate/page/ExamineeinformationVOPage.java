package com.adc.da.generate.page;

/**
* @Description:   封装录入信息和用户信息
* @Author:         xwb
* @Version:        1.0
*/
public class ExamineeinformationVOPage extends ExamineeinformationEOPage {

    private String useraccount;
    private String useraccountOperator = "=";
    private String userpassword;
    private String userpasswordOperator = "=";
    private String userrole;
    private String userroleOperator = "=";
    private String createtime;
    private String createtime1;
    private String createtime2;
    private String createtimeOperator = "=";
    private String status;
    private String statusOperator = "=";



    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getUseraccountOperator() {
        return useraccountOperator;
    }

    public void setUseraccountOperator(String useraccountOperator) {
        this.useraccountOperator = useraccountOperator;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserpasswordOperator() {
        return userpasswordOperator;
    }

    public void setUserpasswordOperator(String userpasswordOperator) {
        this.userpasswordOperator = userpasswordOperator;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getUserroleOperator() {
        return userroleOperator;
    }

    public void setUserroleOperator(String userroleOperator) {
        this.userroleOperator = userroleOperator;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreatetime1() {
        return createtime1;
    }

    public void setCreatetime1(String createtime1) {
        this.createtime1 = createtime1;
    }

    public String getCreatetime2() {
        return createtime2;
    }

    public void setCreatetime2(String createtime2) {
        this.createtime2 = createtime2;
    }

    public String getCreatetimeOperator() {
        return createtimeOperator;
    }

    public void setCreatetimeOperator(String createtimeOperator) {
        this.createtimeOperator = createtimeOperator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusOperator() {
        return statusOperator;
    }

    public void setStatusOperator(String statusOperator) {
        this.statusOperator = statusOperator;
    }
}
