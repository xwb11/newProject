package com.adc.da.generate.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>EXAMINEEINFORMATION ExamineeinformationEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class ExamineeinformationEO extends BaseEntity {

    private String examineekey;
    private String quasiexaminationnumber;
    private String realname;
    private String sex;
    private String registeredresidence;
    private String politicaloutlook ;
    private String nativeplace;
    private Integer age;
    private String idcardnumber;
    private Integer chinese;
    private Integer math;
    private Integer foreignlanguages;
    private Integer sports;
    private Integer othersynthesis;
    private Integer specialbonus;
    private Integer totalscore;
    private String graduateschool;
    private String userkey;
    private String email;
    private Long phonenumber;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>examineekey -> examineekey</li>
     * <li>quasiexaminationnumber -> quasiexaminationnumber</li>
     * <li>realname -> realname</li>
     * <li>sex -> sex</li>
     * <li>registeredresidence -> registeredresidence</li>
     * <li>politicaloutlook  -> politicaloutlook </li>
     * <li>nativeplace -> nativeplace</li>
     * <li>age -> age</li>
     * <li>idcardnumber -> idcardnumber</li>
     * <li>chinese -> chinese</li>
     * <li>math -> math</li>
     * <li>foreignlanguages -> foreignlanguages</li>
     * <li>sports -> sports</li>
     * <li>othersynthesis -> othersynthesis</li>
     * <li>specialbonus -> specialbonus</li>
     * <li>totalscore -> totalscore</li>
     * <li>graduateschool -> graduateschool</li>
     * <li>userkey -> userkey</li>
     * <li>email -> email</li>
     * <li>phonenumber -> phonenumber</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "examineekey": return "examineekey";
            case "quasiexaminationnumber": return "quasiexaminationnumber";
            case "realname": return "realname";
            case "sex": return "sex";
            case "registeredresidence": return "registeredresidence";
            case "politicaloutlook ": return "politicaloutlook ";
            case "nativeplace": return "nativeplace";
            case "age": return "age";
            case "idcardnumber": return "idcardnumber";
            case "chinese": return "chinese";
            case "math": return "math";
            case "foreignlanguages": return "foreignlanguages";
            case "sports": return "sports";
            case "othersynthesis": return "othersynthesis";
            case "specialbonus": return "specialbonus";
            case "totalscore": return "totalscore";
            case "graduateschool": return "graduateschool";
            case "userkey": return "userkey";
            case "email": return "email";
            case "phonenumber": return "phonenumber";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>examineekey -> examineekey</li>
     * <li>quasiexaminationnumber -> quasiexaminationnumber</li>
     * <li>realname -> realname</li>
     * <li>sex -> sex</li>
     * <li>registeredresidence -> registeredresidence</li>
     * <li>politicaloutlook  -> politicaloutlook </li>
     * <li>nativeplace -> nativeplace</li>
     * <li>age -> age</li>
     * <li>idcardnumber -> idcardnumber</li>
     * <li>chinese -> chinese</li>
     * <li>math -> math</li>
     * <li>foreignlanguages -> foreignlanguages</li>
     * <li>sports -> sports</li>
     * <li>othersynthesis -> othersynthesis</li>
     * <li>specialbonus -> specialbonus</li>
     * <li>totalscore -> totalscore</li>
     * <li>graduateschool -> graduateschool</li>
     * <li>userkey -> userkey</li>
     * <li>email -> email</li>
     * <li>phonenumber -> phonenumber</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "examineekey": return "examineekey";
            case "quasiexaminationnumber": return "quasiexaminationnumber";
            case "realname": return "realname";
            case "sex": return "sex";
            case "registeredresidence": return "registeredresidence";
            case "politicaloutlook ": return "politicaloutlook ";
            case "nativeplace": return "nativeplace";
            case "age": return "age";
            case "idcardnumber": return "idcardnumber";
            case "chinese": return "chinese";
            case "math": return "math";
            case "foreignlanguages": return "foreignlanguages";
            case "sports": return "sports";
            case "othersynthesis": return "othersynthesis";
            case "specialbonus": return "specialbonus";
            case "totalscore": return "totalscore";
            case "graduateschool": return "graduateschool";
            case "userkey": return "userkey";
            case "email": return "email";
            case "phonenumber": return "phonenumber";
            default: return null;
        }
    }
    
    /**  **/
    public String getExamineekey() {
        return this.examineekey;
    }

    /**  **/
    public void setExamineekey(String examineekey) {
        this.examineekey = examineekey;
    }

    /**  **/
    public String getQuasiexaminationnumber() {
        return this.quasiexaminationnumber;
    }

    /**  **/
    public void setQuasiexaminationnumber(String quasiexaminationnumber) {
        this.quasiexaminationnumber = quasiexaminationnumber;
    }

    /**  **/
    public String getRealname() {
        return this.realname;
    }

    /**  **/
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**  **/
    public String getSex() {
        return this.sex;
    }

    /**  **/
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**  **/
    public String getRegisteredresidence() {
        return this.registeredresidence;
    }

    /**  **/
    public void setRegisteredresidence(String registeredresidence) {
        this.registeredresidence = registeredresidence;
    }

    /**  **/
    public String getPoliticaloutlook () {
        return this.politicaloutlook ;
    }

    /**  **/
    public void setPoliticaloutlook (String politicaloutlook ) {
        this.politicaloutlook  = politicaloutlook ;
    }

    /**  **/
    public String getNativeplace() {
        return this.nativeplace;
    }

    /**  **/
    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    /**  **/
    public Integer getAge() {
        return this.age;
    }

    /**  **/
    public void setAge(Integer age) {
        this.age = age;
    }

    /**  **/
    public String getIdcardnumber() {
        return this.idcardnumber;
    }

    /**  **/
    public void setIdcardnumber(String idcardnumber) {
        this.idcardnumber = idcardnumber;
    }

    /**  **/
    public Integer getChinese() {
        return this.chinese;
    }

    /**  **/
    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    /**  **/
    public Integer getMath() {
        return this.math;
    }

    /**  **/
    public void setMath(Integer math) {
        this.math = math;
    }

    /**  **/
    public Integer getForeignlanguages() {
        return this.foreignlanguages;
    }

    /**  **/
    public void setForeignlanguages(Integer foreignlanguages) {
        this.foreignlanguages = foreignlanguages;
    }

    /**  **/
    public Integer getSports() {
        return this.sports;
    }

    /**  **/
    public void setSports(Integer sports) {
        this.sports = sports;
    }

    /**  **/
    public Integer getOthersynthesis() {
        return this.othersynthesis;
    }

    /**  **/
    public void setOthersynthesis(Integer othersynthesis) {
        this.othersynthesis = othersynthesis;
    }

    /**  **/
    public Integer getSpecialbonus() {
        return this.specialbonus;
    }

    /**  **/
    public void setSpecialbonus(Integer specialbonus) {
        this.specialbonus = specialbonus;
    }

    /**  **/
    public Integer getTotalscore() {
        return this.totalscore;
    }

    /**  **/
    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    /**  **/
    public String getGraduateschool() {
        return this.graduateschool;
    }

    /**  **/
    public void setGraduateschool(String graduateschool) {
        this.graduateschool = graduateschool;
    }

    /**  **/
    public String getUserkey() {
        return this.userkey;
    }

    /**  **/
    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }

    /**  **/
    public String getEmail() {
        return this.email;
    }

    /**  **/
    public void setEmail(String email) {
        this.email = email;
    }

    /**  **/
    public Long getPhonenumber() {
        return this.phonenumber;
    }

    /**  **/
    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

}
