package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.generate.VO.UserinformationVO;
import com.adc.da.generate.entity.UserinformationEO;
import com.adc.da.generate.page.UserinformationEOPage;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>USERINFORMATION UserinformationEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface UserinformationEODao extends BaseDao<UserinformationEO> {

//    /**
//    * @Description:    新增用户信息
//    * @Author:         xwb
//    * @CreateDate:     2018/10/10 20:09
//    */
//    int insertSelective(UserinformationEO userinformationEO);
    /**
     * 查询用户信息（不分页）
     * 刘志杰 2018-10-08
     * @return
     */
    List<UserinformationEO> queryUserInfo();
    /**
     * 查询用户信息（分页）
     * 刘志杰 2018-10-08
     * @param page
     * @return
     */
    List<UserinformationEO> queryUserInfoByPage(UserinformationEOPage page);

    /**
     * 账号 重复校验
     * 刘志杰 2018-10-08
     * @param useraccount
     * @return
     */
    List<String> AccountRepeat(String useraccount);
    /**
     * 用户登录
     * 刘笑天 20181011
     * @param userAccount
     * @param userPassword
     * @return
     */
    UserinformationEO userLogin(@Param("useraccount") String userAccount, @Param("userpassword") String userPassword);

    /**
     * 旧密码校验
     * 刘笑天 20181022
     * @param userinformationEO
     * @return
     */
    UserinformationEO checkOldPassword(UserinformationEO userinformationEO);
}
