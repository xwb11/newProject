package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.generate.entity.ExamineeinformationEO;
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


    ExamineeinformationEO checkRegistInfo(ExamineeinformationEO examineeinformationEO);

}
