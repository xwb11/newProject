package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.generate.VO.ExamineevolunteerinformationVO;
import com.adc.da.generate.entity.ExamineevolunteerinformationEO;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>EXAMINEEVOLUNTEERINFORMATION ExamineevolunteerinformationEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface ExamineevolunteerinformationEODao extends BaseDao<ExamineevolunteerinformationEO> {
    /**
    * @Description:    查询已经被学校录取的信息
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:44
    * @Version:        1.0
    */
    List<ExamineevolunteerinformationVO> selectAdminssionBySchool(String examinationnumber);
}
