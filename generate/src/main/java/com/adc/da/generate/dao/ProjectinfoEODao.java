package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.generate.entity.ProjectinfoEO;
/**
 *
 * <br>
 * <b>功能：</b>PROJECTINFO ProjectinfoEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface ProjectinfoEODao extends BaseDao<ProjectinfoEO> {

    int selectProjectName(String projectName);
}
