package com.adc.da.generate.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.ProjectinfoEODao;
import com.adc.da.generate.entity.ProjectinfoEO;

import java.util.Date;
import java.util.UUID;

/**
 *
 * <br>
 * <b>功能：</b>PROJECTINFO ProjectinfoEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("projectinfoEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class ProjectinfoEOService extends BaseService<ProjectinfoEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(ProjectinfoEOService.class);

    @Autowired
    private ProjectinfoEODao dao;

    public ProjectinfoEODao getDao() {
        return dao;
    }

    public boolean addProject(ProjectinfoEO projectinfoEO){
        int projectNameNum = dao.selectProjectName(projectinfoEO.getProjectName());

        if(projectNameNum==0 && projectinfoEO.getProjectName()!=null && !"".equals(projectinfoEO.getProjectName())){
            projectinfoEO.setProjectKey(UUID.randomUUID().toString());
            projectinfoEO.setCreateTime(new Date());
            dao.insertSelective(projectinfoEO);
            return true;
        }else
            return false;
    }

    public boolean updateProject(ProjectinfoEO projectinfoEO){
        if(projectinfoEO.getProjectKey()!=null && !"".equals(projectinfoEO.getProjectKey())){
            int projectNameNum = dao.selectProjectName(projectinfoEO.getProjectName());
            if(projectNameNum<1 && projectinfoEO.getProjectName()!=null && !"".equals(projectinfoEO.getProjectName())){
                dao.updateByPrimaryKeySelective(projectinfoEO);
                return true;
            }else
                return false;
        }else {
            return false;
        }
    }
}
