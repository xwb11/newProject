package com.adc.da.generate.service;

import com.adc.da.generate.VO.UserinformationVO;
import com.adc.da.generate.page.UserinformationEOPage;
import com.adc.da.myutil.util.PublicPrompt;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.UserinformationEODao;
import com.adc.da.generate.entity.UserinformationEO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.adc.da.generate.util.SchoolinformationEOPrompt.INSERTSCHOOLNAME_ERROR;
import static com.adc.da.generate.util.UserinformationEOPrompt.INSERT_ERRO;

/**
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
     * @Description: 用户信息新增
     * @Author: xwb
     * @CreateDate: 2018/10/10 20:35
     * @Version: 1.0
     */
    public boolean insertUserInfo(UserinformationEO userinformationEO) {
        if (userinformationEO.getUseraccount() != null && !"".equals(userinformationEO.getUseraccount())) {
            userinformationEO.setUserkey(UUID.randomUUID().toString());
            userinformationEO.setCreatetime(new Date());
        }
        try {
            int num = dao.insertSelective(userinformationEO);
            if (num > 0) {
                return true;
            } else {
                throw new RuntimeException(INSERT_ERRO);
            }
        } catch (Exception e) {
            throw new RuntimeException(INSERT_ERRO);
        }
    }


    /**
     * 用户信息删除
     * 刘志杰 2018-10-08
     *
     * @param userinformationEO 用户信息
     */
    public void deleteUserInfo(UserinformationEO userinformationEO) {
        userinformationEO.setUserrole("3");
        dao.updateByPrimaryKeySelective(userinformationEO);
    }

    /**
     * 查询用户信息（分页）
     * 刘志杰 2018-10-08
     *
     * @param page
     * @return
     */
    public List<UserinformationEO> queryUserInfoByPage(UserinformationEOPage page) {
        return dao.queryUserInfoByPage(page);
    }

    /**
     * 查询用户信息（不分页）
     * 刘志杰 2018-10-08
     *
     * @return
     */
    public List<UserinformationEO> queryUserInfo() {
        return dao.queryUserInfo();
    }

    /**
     * 用户名验重
     * 刘志杰 2018-10-08
     *
     * @param userinformationVO
     * @return
     */
    public boolean AccountRepeat(UserinformationVO userinformationVO) {
        boolean result = true;  //result =true :重复
        //得到useraccount = userinformationVO.getUseraccount()  所有userinformation的key
        List<String> strings = dao.AccountRepeat(userinformationVO.getUseraccount());

        if (strings.size() <= 0) {  //账号名不存在 ，返回 不重复
            result = false;  //result = false 不重复
        } else {  //账号名存在，但是 是该用户的当前的账号，返回不重复
            if (userinformationVO.getUserkey() != null) {
                for (String str : strings) {
                    if (str.equals(userinformationVO.getUserkey())) {
                        result = false;  //result = false 不重复
                    }
                }
            }
        }
        return result;
    }

    /**
     * 用户登录
     * 刘笑天 20181011
     *
     * @param userAccount
     * @param userPassword
     * @return
     */
    public UserinformationEO userLogin(String userAccount, String userPassword) {
//        UserinformationEO userinformationEO = new UserinformationEO();
        if (dao.userLogin(userAccount, userPassword) != null) {
            return dao.userLogin(userAccount, userPassword);
        } else {
            return null;
        }
    }
}
