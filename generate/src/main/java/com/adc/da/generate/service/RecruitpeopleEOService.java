package com.adc.da.generate.service;

import com.adc.da.base.page.BasePage;
import com.adc.da.generate.VO.DemandvolunteerinformationVO;
import com.adc.da.generate.VO.RecruitpeopleVO;
import com.adc.da.generate.page.RecruitpeopleVOPage;
import com.adc.da.util.http.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.RecruitpeopleEODao;
import com.adc.da.generate.entity.RecruitpeopleEO;


/**
 *
 * <br>
 * <b>功能：</b>RECRUITPEOPLE RecruitpeopleEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("recruitpeopleEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class RecruitpeopleEOService extends BaseService<RecruitpeopleEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(RecruitpeopleEOService.class);

    @Autowired
    private RecruitpeopleEODao dao;

    public RecruitpeopleEODao getDao() {
        return dao;
    }

    public PageInfo<RecruitpeopleVO> selectDemandvolunteerinformation(RecruitpeopleVOPage page) throws Exception {
        Integer rowCount = this.queryByCount(page);
        page.getPager().setRowCount(rowCount);
        PageInfo<RecruitpeopleVO> pageInfo = new PageInfo();
        pageInfo.setList(this.dao.queryByRecruitpeopleVO(page));
        pageInfo.setCount((long)rowCount);
        pageInfo.setPageSize(page.getPager().getPageSize());
        pageInfo.setPageCount((long)page.getPager().getPageCount());
        pageInfo.setPageNo(page.getPager().getPageId());
        return pageInfo;
    }

    public  int queryByCount(BasePage page) {
        return this.getDao().queryRecruitpeopleVOCount(page);
    }

}
