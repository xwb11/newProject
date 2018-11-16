package com.adc.da.generate.service;

import com.adc.da.base.page.BasePage;
import com.adc.da.generate.VO.AdminssionsplaninformationVO;
import com.adc.da.generate.VO.DemandvolunteerinformationVO;
import com.adc.da.generate.page.DemandvolunteerinformationVOPage;
import com.adc.da.util.http.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.DemandvolunteerinformationEODao;
import com.adc.da.generate.entity.DemandvolunteerinformationEO;


/**
 *
 * <br>
 * <b>功能：</b>DEMANDVOLUNTEERINFORMATION DemandvolunteerinformationEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("demandvolunteerinformationEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class DemandvolunteerinformationEOService extends BaseService<DemandvolunteerinformationEO, Void> {

    private static final Logger logger = LoggerFactory.getLogger(DemandvolunteerinformationEOService.class);

    @Autowired
    private DemandvolunteerinformationEODao dao;

    public DemandvolunteerinformationEODao getDao() {
        return dao;
    }

    public PageInfo<DemandvolunteerinformationVO> selectDemandvolunteerinformation(BasePage page) throws Exception {
        Integer rowCount = this.queryByCount(page);
        page.getPager().setRowCount(rowCount);
        PageInfo<DemandvolunteerinformationVO> pageInfo = new PageInfo();
        pageInfo.setList(this.dao.selectDemandvolunteerinformation(page));
        pageInfo.setCount((long)rowCount);
        pageInfo.setPageSize(page.getPager().getPageSize());
        pageInfo.setPageCount((long)page.getPager().getPageCount());
        pageInfo.setPageNo(page.getPager().getPageId());
        return pageInfo;
    }

    public  int queryByCount(BasePage page) {
        return this.getDao().queryByDemandCount(page);
    }

    public boolean addDemandvolunteerinformation(DemandvolunteerinformationVO demandvolunteerinformationVO){
        if((demandvolunteerinformationVO.getCompanyName()!=null && !"".equals(demandvolunteerinformationVO.getCompanyName()))
                && (demandvolunteerinformationVO.getProjectName()!=null && !"".equals(demandvolunteerinformationVO.getProjectName()))
                ){
            dao.addDemandvolunteerinformation(demandvolunteerinformationVO);
            return true;
        }else {
            return false;
        }
    }

    public boolean updateDemandvolunteerinformation(DemandvolunteerinformationVO demandvolunteerinformationVO){
        if(demandvolunteerinformationVO.getDemandKey()!=null && !"".equals(demandvolunteerinformationVO.getDemandKey())){
            dao.updateDemandvolunteerinformation(demandvolunteerinformationVO);
            return true;
        }else {
            return false;
        }
    }

    public boolean deleteDemandvolunteerinformation(DemandvolunteerinformationVO demandvolunteerinformationVO){
        if(demandvolunteerinformationVO.getDemandKey()!=null && !"".equals(demandvolunteerinformationVO.getDemandKey())){
            dao.deleteDemandvolunteerinformation(demandvolunteerinformationVO);
            return true;
        }else {
            return false;
        }
    }

    public int  selectIsPublish(){
    return  dao.selectIsPublish();
    }

}
