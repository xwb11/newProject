package com.adc.da.generate.service;

import com.adc.da.generate.entity.AdminssionsplaninformationVO;
import com.adc.da.generate.entity.SchoolinformationEO;
import com.adc.da.generate.page.AdminssionsplaninformationVOPage;
import com.adc.da.generate.page.SchoolinformationEOPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.AdminssionsplaninformationEODao;
import com.adc.da.generate.entity.AdminssionsplaninformationEO;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>ADMINSSIONSPLANINFORMATION AdminssionsplaninformationEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("adminssionsplaninformationEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class AdminssionsplaninformationEOService extends BaseService<AdminssionsplaninformationEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(AdminssionsplaninformationEOService.class);

    @Autowired
    private AdminssionsplaninformationEODao dao;

    public AdminssionsplaninformationEODao getDao() {
        return dao;
    }

    /**
     *  查询本年招生信息（分页查询）
     * @param page
     * @return
     */
    public List<AdminssionsplaninformationVO> queryAdminssionInfoByPage(AdminssionsplaninformationVOPage page) {
        return dao.queryAdmissionInfoByPage(page);
    }

    /**
     * 查询本年招生信息（模糊查询）
     * @return
     */
    public List<AdminssionsplaninformationVO> selectAdminssion (AdminssionsplaninformationVO adminssionsplaninformationVO){
        return dao.selectAdmission(adminssionsplaninformationVO);
    }


//    public List<AdminssionsplaninformationVO> selectLastYearAdmission(AdminssionsplaninformationVO adminssionsplaninformationVO){
//        return dao.selectLastYearAdmission(adminssionsplaninformationVO);
//    }

    /**
     * 查询去年招考信息
     * @param page
     * @return
     */
    public List<AdminssionsplaninformationVO> selectLastYearAdmission(AdminssionsplaninformationVOPage page){
        return dao.selectLastYearAdmission(page);
    }
}
