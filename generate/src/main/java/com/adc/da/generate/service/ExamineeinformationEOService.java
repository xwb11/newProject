package com.adc.da.generate.service;

import com.adc.da.generate.dao.UserinformationEODao;
import com.adc.da.generate.entity.UserinformationEO;
import com.adc.da.generate.util.ExamineeinformationPrompt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.ExamineeinformationEODao;
import com.adc.da.generate.entity.ExamineeinformationEO;


/**
 * <br>
 * <b>功能：</b>EXAMINEEINFORMATION ExamineeinformationEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("examineeinformationEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class ExamineeinformationEOService extends BaseService<ExamineeinformationEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(ExamineeinformationEOService.class);

    @Autowired
    private ExamineeinformationEODao dao;


    public ExamineeinformationEODao getDao() {
        return dao;
    }

    /**
     * 考生信息录入校验
     * 刘志杰 2018-10-08
     *
     * @param examineeinformationEO 考生信息
     * @return
     */
    public String informationCheck(ExamineeinformationEO examineeinformationEO,UserinformationEO userinformationEO) {
        //非空 校验
            if (examineeinformationEO.getQuasiexaminationnumber() == null ||
                examineeinformationEO.getRealname() == null ||
                examineeinformationEO.getSex() == null ||
                examineeinformationEO.getAge() == null ||
                examineeinformationEO.getIdcardnumber() == null ||
                examineeinformationEO.getRegisteredresidence() == null ||
                examineeinformationEO.getPoliticaloutlook() == null ||
                examineeinformationEO.getNativeplace() == null ||
                examineeinformationEO.getEmail() == null ||
                examineeinformationEO.getPhonenumber() == null ||
                examineeinformationEO.getGraduateschool() == null||
                userinformationEO.getUseraccount()==null||
                userinformationEO.getUserpassword()==null
                ) {
            return ExamineeinformationPrompt.NOT_NULL;
        }
        //身份证号 重复校验
        if (dao.queryIdCard(examineeinformationEO.getIdcardnumber())!=0) {
            return ExamineeinformationPrompt.IDCARD_REPEAT;
        }
        //身份证号 长度18位 校验
        if (examineeinformationEO.getIdcardnumber().trim().length() != 18) {
            return ExamineeinformationPrompt.IDCARD_LENGTH;
        }
        //手机号 重复校验
        if (dao.queryPhoneNumber(examineeinformationEO.getPhonenumber())!=0) {
            return ExamineeinformationPrompt.PHONENUMBER_REPEAT;
        }
        //邮箱 重复校验
        if (dao.queryEMail(examineeinformationEO.getEmail())!=0) {
            return ExamineeinformationPrompt.EMAIL_REPEAT;
        }
        return "true";
    }
}
