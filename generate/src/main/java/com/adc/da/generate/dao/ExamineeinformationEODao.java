package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.base.page.BasePage;
import com.adc.da.generate.VO.ExamineeinformationVO;
import com.adc.da.generate.entity.ExamineeinformationEO;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>EXAMINEEINFORMATION ExamineeinformationEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface ExamineeinformationEODao extends BaseDao<ExamineeinformationEO> {


    /**
    * @Description:    查询录入信息
    * @Author:         xwb
    * @CreateDate:     2018/10/15 9:33
    * @Version:        1.0
    */
    List<ExamineeinformationVO> examineeinformationByPage(BasePage page);
    /**
    * @Description:    查询录入信息总数
    * @Author:         xwb
    * @CreateDate:     2018/10/15 9:32
    * @Version:        1.0
    */
    int queryExamineeinformationCount(BasePage page);

    /**
    * @Description:    同一账号下的手机，邮箱，身份证号验重
    * @Author:         xwb
    * @CreateDate:     2018/10/22 9:23
    * @Version:        1.0
    */
    int checkRepeat(ExamineeinformationEO examineeinformationEO);

    /**
     * 身份证号 重复校验
     * 刘志杰 2018-10-08
     * @param idcardnumber
     * @return
     */
    int queryIdCard(String idcardnumber);
    /**
     * 手机号 重复校验
     * 刘志杰 2018-10-08
     * @param phonenumber
     * @return
     */
    int queryPhoneNumber(Long phonenumber);
    /**
     * 邮箱 重复校验
     * 刘志杰 2018-10-08
     * @param email
     * @return
     */
    int queryEMail(String email);
    /**
     * 注册查重
     * 刘笑天 20181011
     * @param examineeinformationEO
     * @return
     */
    ExamineeinformationEO checkRegistInfo(ExamineeinformationEO examineeinformationEO);

    /**
     * 准考证验证
     * 刘笑天 20181019
     * @param quasiExaminationNumber
     */
    ExamineeinformationEO checkQuasiExaminationNumber(String quasiExaminationNumber);
}
