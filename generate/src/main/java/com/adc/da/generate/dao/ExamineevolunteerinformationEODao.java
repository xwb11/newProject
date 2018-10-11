package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.generate.VO.ExamineevolunteerinformationVO;
import com.adc.da.generate.entity.ExamineevolunteerinformationEO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * <br>
 * <b>功能：</b>EXAMINEEVOLUNTEERINFORMATION ExamineevolunteerinformationEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface ExamineevolunteerinformationEODao extends BaseDao<ExamineevolunteerinformationEO> {

    //<查询已经被学校录取的信息
    List<ExamineevolunteerinformationVO> selectAdminssionBySchool(String examinationnumber);


    /**
     * 获取考生志愿
     * 刘笑天 20181011
     * @param examinationnumber
     * @return
     */
    List<Map<String,Object>> getExamineeVolunteerInformation(String examinationnumber);

    /**
     * 考生报考学校查重
     * 刘笑天 20181011
     * @return
     */
    ExamineevolunteerinformationEO checkExamineeSchool(@Param("examinationnumber") String examinationNumber
            ,@Param("schoolkey") String schoolKey);

    /**
     * 考生申报志愿
     * 刘笑天 20181011
     * @param examineevolunteerinformationEO
     */
    void examineeDeclareVolunteer(ExamineevolunteerinformationEO examineevolunteerinformationEO);

    /**
     * 考生修改志愿顺序（未完成）
     * 刘笑天 20181011
     * @param examineevolunteerinformationEO
     */
    void examineeUpdateVolunteer(ExamineevolunteerinformationEO examineevolunteerinformationEO);

    /**
     * 考生志愿批量删除
     * 刘笑天 20181011
     * @param
     */
    void examineeBatchDeleteVolunteer(ExamineevolunteerinformationVO examineevolunteerinformationVO);
//    void examineeBatchDeleteVolunteer(List volunteerKeys);
}
