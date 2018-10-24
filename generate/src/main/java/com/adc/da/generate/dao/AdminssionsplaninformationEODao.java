package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.base.page.BasePage;
import com.adc.da.generate.entity.AdminssionsplaninformationEO;
import com.adc.da.generate.VO.AdminssionsplaninformationVO;
import com.adc.da.generate.page.AdminssionsplaninformationEOPage;
import com.adc.da.generate.page.AdminssionsplaninformationVOPage;

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
    /**
    * @Description:    查询本年招生信息（分页）
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:43
    * @Version:        1.0
    */
    List<AdminssionsplaninformationVO> queryAdmissionInfoByPage(BasePage page);


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
    List<AdminssionsplaninformationVO> selectLastYearAdmission(BasePage page);

    /**
    * @Description:    获取招生信息符合条件的信息数
    * @Author:         xwb
    * @CreateDate:     2018/10/12 13:27
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/10/12 13:27
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    int queryAdminssionByCount(BasePage page);
    /**
     * @Description:    获取去年招考信息符合条件的信息数
     * @Author:         xwb
     * @CreateDate:     2018/10/12 13:27
     * @UpdateUser:     xwb
     * @UpdateDate:     2018/10/12 13:27
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    int queryLastAdminssionByCount(BasePage page);



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


    /**
    * @Description:   _学校，专业，省份进行模糊查询
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:58
    */
    List<AdminssionsplaninformationVO> selectBySMP(AdminssionsplaninformationEOPage page);


    /**
    * @Description:   _验重
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:59
    */
    String isRepeat(AdminssionsplaninformationEO adminssionsplaninformationEO);

    /**
    * @Description:   _删除招生计划
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:59
    */
    int deleteByKey(String adminKey);

    /**
    * @Description:   _加载招生计划（分页）
    * @Author:         yueben
    * @CreateDate:     2018/10/24 10:00
    */
    List<AdminssionsplaninformationVO> selectAll(AdminssionsplaninformationEOPage page);

    /**
    * @Description:   _模糊查询分页计数
    * @Author:         yueben
    * @CreateDate:     2018/10/24 10:00
    */
    int countBySMP(AdminssionsplaninformationEOPage page);
}
