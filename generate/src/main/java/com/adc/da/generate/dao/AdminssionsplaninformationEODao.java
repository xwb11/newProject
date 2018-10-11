package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.generate.entity.AdminssionsplaninformationEO;
import com.adc.da.generate.entity.AdminssionsplaninformationVO;
import com.adc.da.generate.entity.SchoolinformationEO;
import com.adc.da.generate.page.AdminssionsplaninformationVOPage;
import com.adc.da.generate.page.SchoolinformationEOPage;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>ADMINSSIONSPLANINFORMATION AdminssionsplaninformationEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface AdminssionsplaninformationEODao extends BaseDao<AdminssionsplaninformationEO> {

    //查询本年招生信息（分页）
    List<AdminssionsplaninformationVO> queryAdmissionInfoByPage(AdminssionsplaninformationVOPage page);

    //查询本年招生信息（模糊查询）
    List<AdminssionsplaninformationVO> selectAdmission(AdminssionsplaninformationVO adminssionsplaninformationVO);

    //查询去年招考信息
//    List<AdminssionsplaninformationVO> selectLastYearAdmission(AdminssionsplaninformationVO adminssionsplaninformationVO);
    List<AdminssionsplaninformationVO> selectLastYearAdmission(AdminssionsplaninformationVOPage page);
}
