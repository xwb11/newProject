package com.adc.da.generate.service;

import com.adc.da.generate.page.UserinformationEOPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.UserinformationEODao;
import com.adc.da.generate.entity.UserinformationEO;

import java.util.List;


/**
 *
 * <br>
 * <b>功能：</b>USERINFORMATION UserinformationEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("userinformationEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class UserinformationEOService extends BaseService<UserinformationEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(UserinformationEOService.class);

    @Autowired
    private UserinformationEODao dao;

    public UserinformationEODao getDao() {
        return dao;
    }

    /**
     * 用户信息删除
     * 刘志杰 2018-10-08
     * @param userinformationEO 用户信息
     */
    public void deleteUserInfo(UserinformationEO userinformationEO) {
        userinformationEO.setUserrole("3");
        dao.updateByPrimaryKey(userinformationEO);
    }

    /**
     * 查询用户信息（分页）
     * 刘志杰 2018-10-08
     * @param page
     * @return
     */
    public List<UserinformationEO> queryUserInfoByPage(UserinformationEOPage page) {
        return dao.queryUserInfoByPage(page);
    }

    /**
     * 查询用户信息（不分页）
     * 刘志杰 2018-10-08
     * @return
     */
    public List<UserinformationEO> queryUserInfo() {
        return dao.queryUserInfo();
    }

    /**
     * 用户名验重
     * 刘志杰 2018-10-08
     * @param useraccount
     * @return
     */
    public boolean AccountRepeat(String useraccount){
        boolean result=false;
        if(dao.queryAccount(useraccount)==0){
            result=true;
        }
        return result;
    }

    /**
     * 用户登录
     * 刘笑天 20181011
     * @param userAccount
     * @param userPassword
     * @return
     */
    public UserinformationEO userLogin(String userAccount,String userPassword){
//        UserinformationEO userinformationEO = new UserinformationEO();
        if(dao.userLogin(userAccount,userPassword)!=null){
            return dao.userLogin(userAccount,userPassword);
        }else{
            return null;
        }
    }
}
