package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.generate.entity.AdminssionsplaninformationEO;
import com.adc.da.generate.entity.AdminssionsplaninformationVO;
import com.adc.da.generate.entity.SchoolinformationEO;
import com.adc.da.generate.page.AdminssionsplaninformationVOPage;
import com.adc.da.generate.page.SchoolinformationEOPage;

import java.util.List;
import java.util.Map;

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
    /**
     * 获取已发布专业的学校
     * 刘笑天 20181011
     * @return
     */
    List<Map<String,Object>> getSchools();

    /**
     * 获取学校已发布的专业
     * 刘笑天 20181011
     * @param schoolKey
     * @return
     */
    List<Map<String,Object>> getSchoolsPublishedMajor(String schoolKey);
}
