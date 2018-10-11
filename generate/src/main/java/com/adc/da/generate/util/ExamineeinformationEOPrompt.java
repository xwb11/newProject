package com.adc.da.generate.util;

import com.adc.da.myutil.util.PublicPrompt;

//考生信息 提示语
public class ExamineeinformationEOPrompt extends PublicPrompt {
    public static final String NOT_NULL = "填写的信息都不能为空";
    public static final String IDCARD_LENGTH = "身份证号 长度必须是18位字符";
    public static final String IDCARD_REPEAT = "身份证号已存在";
    public static final String PHONENUMBER_REPEAT = "手机号已存在";
    public static final String EMAIL_REPEAT = "邮箱已存在";
    public static final String ENTRY_SUCCESS = "录入成功";
    public static final String REGIST_SUCCESS = "注册成功";
    public static final String REGIST_FAILED = "注册失败";
    public static final String CHECK_FAILED = "您填写的信息已被别人使用 请核对后重新填写";
}
