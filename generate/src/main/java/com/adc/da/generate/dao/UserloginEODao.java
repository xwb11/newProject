package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.base.page.BasePage;
import com.adc.da.generate.entity.UserloginEO;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>USERLOGIN UserloginEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-10 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface UserloginEODao extends BaseDao<UserloginEO> {

    String checkAccount(String account);

    String checkPassword(String account);

    //查询账户是否存在
    int  selectAccoutCount(String account);

    //查询用户对应的类型
    String selectRole(UserloginEO userloginEO);

    List<UserloginEO> queryByList(UserloginEO userloginEO);

    String selectPassword(UserloginEO userloginEO);

    //修改密码
    int updatePassword(UserloginEO userloginEO);
}
