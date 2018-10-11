package com.adc.da.generate.service;

import com.adc.da.generate.VO.ExamineevolunteerinformationVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.ExamineevolunteerinformationEODao;
import com.adc.da.generate.entity.ExamineevolunteerinformationEO;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>EXAMINEEVOLUNTEERINFORMATION ExamineevolunteerinformationEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("examineevolunteerinformationEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class ExamineevolunteerinformationEOService extends BaseService<ExamineevolunteerinformationEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(ExamineevolunteerinformationEOService.class);

    @Autowired
    private ExamineevolunteerinformationEODao dao;

    public ExamineevolunteerinformationEODao getDao() {
        return dao;
    }
    /**
    * @Description:    查询已被录取的学校信息
    * @Author:         xwb
    * @CreateDate:     2018/10/10 17:00
    * @Version:        1.0
    */
    public List<ExamineevolunteerinformationVO> selectAdminssionBySchool(String examinationnumber){
        return dao.selectAdminssionBySchool(examinationnumber);
    }
}
