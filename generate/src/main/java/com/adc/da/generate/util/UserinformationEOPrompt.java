package com.adc.da.generate.util;

import com.adc.da.myutil.util.PublicPrompt;

/**
* @Description:    用户信息 提示语
* @Author:         xwb
* @CreateDate:     2018/10/11 12:51
* @Version:        1.0
*/
public class UserinformationEOPrompt extends PublicPrompt {
    /**
     * 用户信息修改
     */
    public static final String USE_PERMIT = "你没有使用权限！";
    public static final String DELETE_ERRO = "删除失败！";
    public static final String INSERT_ERRO = "新增失败！";
    public static final String UPDATE_ERRO = "修改失败！";
    public static final String ACOUNT_REPEAT = "账号名重复！";



    /**
     * 用户登录
     * 刘笑天 20181011
     */
    public static final String LOGIN_FAILED = "登录失败，用户名或密码错误";
    public static final String ADMIN_LOGIN_SUCCESS = "管理员登录成功";
    public static final String EXAMINEE_LOGIN_SUCCESS = "考生登录成功";
    public static final String ADMISSIONS_LOGIN_SUCCESS = "招生者登录成功";
    public static final String USER_IS_FAKEDELETED = "用户已被删除";
    public static final String USERROLE_NOTEXIST = "登录失败，角色类型不存在";

    /**
     * 用户注册
     * 刘笑天 20181022
     */
    public static final String PASSWORD_BLANK = "旧密码不能为空";
    public static final String CHECKPASSWORD_SUCCESS = "旧密码输入正确";
    public static final String CHECKPASSWORD_FAILED = "旧密码输入错误";

}
