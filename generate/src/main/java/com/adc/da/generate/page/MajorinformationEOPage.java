package com.adc.da.generate.page;

import com.adc.da.base.page.BasePage;

import java.util.Date;

/**
 * <b>功能：</b>MAJORINFORMATION MajorinformationEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class MajorinformationEOPage extends BasePage {

    private String majorkey;
    private String majorkeyOperator = "=";
    private String majorname;
    private String majornameOperator = "=";
    private String createtime;
    private String createtime1;
    private String createtime2;
    private String createtimeOperator = "=";

    public String getMajorkey() {
        return this.majorkey;
    }

    public void setMajorkey(String majorkey) {
        this.majorkey = majorkey;
    }

    public String getMajorkeyOperator() {
        return this.majorkeyOperator;
    }

    public void setMajorkeyOperator(String majorkeyOperator) {
        this.majorkeyOperator = majorkeyOperator;
    }

    public String getMajorname() {
        return this.majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public String getMajornameOperator() {
        return this.majornameOperator;
    }

    public void setMajornameOperator(String majornameOperator) {
        this.majornameOperator = majornameOperator;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreatetime1() {
        return this.createtime1;
    }

    public void setCreatetime1(String createtime1) {
        this.createtime1 = createtime1;
    }

    public String getCreatetime2() {
        return this.createtime2;
    }

    public void setCreatetime2(String createtime2) {
        this.createtime2 = createtime2;
    }

    public String getCreatetimeOperator() {
        return this.createtimeOperator;
    }

    public void setCreatetimeOperator(String createtimeOperator) {
        this.createtimeOperator = createtimeOperator;
    }

}
