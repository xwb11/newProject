package com.adc.da.generate.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.UserLoginEODao;
import com.adc.da.generate.entity.UserLoginEO;


/**
 *
 * <br>
 * <b>功能：</b>TS_USER_LOGIN UserLoginEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("userLoginEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class UserLoginEOService extends BaseService<UserLoginEO, Integer> {

    private static final Logger logger = LoggerFactory.getLogger(UserLoginEOService.class);

    @Autowired
    private UserLoginEODao dao;

    public UserLoginEODao getDao() {
        return dao;
    }

}
