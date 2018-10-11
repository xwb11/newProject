package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.generate.entity.AdminssionsplaninformationEO;
import com.adc.da.generate.VO.AdminssionsplaninformationVO;
import com.adc.da.generate.page.AdminssionsplaninformationVOPage;

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
    /**
    * @Description:    查询本年招生信息（分页）
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:43
    * @Version:        1.0
    */
    List<AdminssionsplaninformationVO> queryAdmissionInfoByPage(AdminssionsplaninformationVOPage page);
    /**
    * @Description:    查询本年招生信息（模糊查询）
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:44
    * @Version:        1.0
    */
    List<AdminssionsplaninformationVO> selectAdmission(AdminssionsplaninformationVO adminssionsplaninformationVO);
    /**
    * @Description:    查询去年招考信息
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:44
    */
//    List<AdminssionsplaninformationVO> selectLastYearAdmission(AdminssionsplaninformationVO adminssionsplaninformationVO);
    List<AdminssionsplaninformationVO> selectLastYearAdmission(AdminssionsplaninformationVOPage page);
}
