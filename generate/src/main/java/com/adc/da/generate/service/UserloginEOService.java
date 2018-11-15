package com.adc.da.generate.service;

import com.adc.da.base.page.BasePage;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.UserloginEODao;
import com.adc.da.generate.entity.UserloginEO;

import java.security.SecureRandom;
import java.util.List;

import static com.adc.da.generate.util.UserloginEOPrompt.*;

/**
 *
 * <br>
 * <b>功能：</b>USERLOGIN UserloginEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-10 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("userloginEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class UserloginEOService extends BaseService<UserloginEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(UserloginEOService.class);

    @Autowired
    private UserloginEODao dao;

    public UserloginEODao getDao() {
        return dao;
    }

    public String checkAccount(UserloginEO userloginEO){

        if(
           (userloginEO.getAccount() !=null && !"".equals(userloginEO.getAccount())) &&
           (userloginEO.getPassword() !=null && !"".equals(userloginEO.getPassword()))
           ){
            int result = dao.selectAccoutCount(userloginEO.getAccount());
            if(result>0){//判断账号是否存在
                String account = dao.checkAccount(userloginEO.getAccount());
                String password = dao.checkPassword(userloginEO.getAccount());

                if( userloginEO.getPassword().equals(password) && password!=null ){
                    return LOGIN_SUCCESS;
                }else {
                    return LOGIN_ERROR;
                }
            }else {
                return ACCOUNT_NULL;
            }
        }else {
            return ACCOUNTANDPASSWORD_NOTNULL;
        }
    }

    public String selectUserRole(UserloginEO userloginEO){
        return dao.selectRole(userloginEO);
    }

    public List<UserloginEO> queryByList(UserloginEO userloginEO) throws Exception {
        return this.getDao().queryByList(userloginEO);
    }

    /**
    * @Description:    检查修改密码是否重复
    * @Author:         xwb
    * @CreateDate:     2018/11/13 20:33
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/11/13 20:33
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public boolean checkPassword(UserloginEO userloginEO){
        if(userloginEO.getPassword() != null && !"".equals(userloginEO.getPassword())){
            String result = dao.selectPassword(userloginEO);
            if(result != null && !"".equals(result)){
                if(result.equals(userloginEO.getPassword())){
                    return false;
                }else {
                    dao.updatePassword(userloginEO);
                    return true;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public boolean checkOldPassword(UserloginEO userloginEO){
        String result = dao.selectPassword(userloginEO);
        if(result.equals(userloginEO.getPassword())){
            return true;
        }else
            return false;
    }
}
