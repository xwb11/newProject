package com.adc.da.myutil.util;

import java.io.Serializable;

/**
 * 公共提示语类
 * 所有提示语均为自定义 可自行增删改
 * 需要用到类的位置需要静态引用（import static）
 * 所有子模块下的子提示语类都需要继承此类
 * 刘笑天 20181008
 */
public class PublicPrompt implements Serializable {
//    public static final String PUBLIC_MESSAGE = "公共提示语";//所有提示语变量写法均以此为例
    public static final String PUBLIC_MESSAGE = "公共提示语";

    public static final String SEARCH_SUCCESS = "查询成功";
    public static final String INSERT_SUCCESS = "添加成功";
    public static final String UPDATE_SUCCESS = "修改成功";
    public static final String DELETE_SUCCESS = "删除成功";
}
