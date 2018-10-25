package com.adc.da.generate.service;

import com.adc.da.base.page.BasePage;
import com.adc.da.generate.VO.ExamineeinformationVO;
import com.adc.da.generate.dao.UserinformationEODao;
import com.adc.da.generate.entity.UserinformationEO;
import com.adc.da.generate.util.ExamineeinformationEOPrompt;
import com.adc.da.util.http.PageInfo;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.ExamineeinformationEODao;
import com.adc.da.generate.entity.ExamineeinformationEO;

import java.util.List;

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
     * @Description: 根据考生id获取相应的内容
     * @Author: xwb
     * @CreateDate: 2018/10/25 17:20
     * @Version: 1.0
     */
    public List<ExamineeinformationVO> selectExamineeinfomation(String examineekey) {
        return dao.selectByExamineeKey(examineekey);
    }

    /**
     * @Description: 查询录入信息
     * @Author: xwb
     * @CreateDate: 2018/10/15 9:36
     * @Version: 1.0
     */
    public PageInfo<ExamineeinformationVO> selectExamineeinformationByPage(BasePage page) throws Exception {
        Integer rowCount = this.queryAdminssionByCount(page);
        page.getPager().setRowCount(rowCount);
        PageInfo<ExamineeinformationVO> pageInfo = new PageInfo();
        pageInfo.setList(this.dao.examineeinformationByPage(page));
//        pageInfo.setCount((long)page.getPager().getRowCount());
        pageInfo.setCount((long) rowCount);
        pageInfo.setPageSize(page.getPager().getPageSize());
        pageInfo.setPageCount((long) page.getPager().getPageCount());
        pageInfo.setPageNo(page.getPager().getPageId());
        return pageInfo;
    }

    public int queryAdminssionByCount(BasePage page) throws Exception {
        return this.getDao().queryExamineeinformationCount(page);
    }

    /**
     * 考生信息录入校验
     * 刘志杰 2018-10-08
     *
     * @param examineeinformationEO 考生信息
     * @return
     */
    public String informationCheck(ExamineeinformationEO examineeinformationEO, UserinformationEO userinformationEO) {
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
                examineeinformationEO.getGraduateschool() == null ||
                userinformationEO.getUseraccount() == null ||
                userinformationEO.getUserpassword() == null
                ) {
            return ExamineeinformationEOPrompt.NOT_NULL;
        }
        //身份证号 长度18位 校验
        if (examineeinformationEO.getIdcardnumber().trim().length() != 18) {
            return ExamineeinformationEOPrompt.IDCARD_LENGTH;
        }

        ExamineeinformationEO examineeInfo = dao.selectByPrimaryKey(examineeinformationEO.getExamineekey());
        //身份证号 重复校验
        if (!examineeInfo.getIdcardnumber().equals(examineeinformationEO.getIdcardnumber())) { //不是本人的身份证号
            if (dao.queryIdCard(examineeinformationEO.getIdcardnumber()) != 0) {
                return ExamineeinformationEOPrompt.IDCARD_REPEAT;
            }
        }


        //手机号 重复校验
        if (!examineeInfo.getPhonenumber().equals(examineeinformationEO.getPhonenumber())) {//不是本人的手机号
            if (dao.queryPhoneNumber(examineeinformationEO.getPhonenumber()) != 0) {
                return ExamineeinformationEOPrompt.PHONENUMBER_REPEAT;
            }
        }

        //邮箱 重复校验
        if (!examineeInfo.getEmail().equals(examineeinformationEO.getEmail())) {//不是本人的邮箱
            if (dao.queryEMail(examineeinformationEO.getEmail()) != 0) {
                return ExamineeinformationEOPrompt.EMAIL_REPEAT;
            }
        }


        return "true";
    }

    /**
     * 注册查重
     * 刘笑天 20181011
     *
     * @param examineeinformationEO
     * @return
     */
    public ExamineeinformationEO checkRegistInfo(ExamineeinformationEO examineeinformationEO) {
        return dao.checkRegistInfo(examineeinformationEO);
    }

    /**
     * 准考证验证
     * 刘笑天 20181019
     *
     * @param quasiExaminationNumber
     */
    public ExamineeinformationEO checkQuasiExaminationNumber(String quasiExaminationNumber) {
        return dao.checkQuasiExaminationNumber(quasiExaminationNumber);
    }

    /**
     * 注册_考生账号注册
     * 刘笑天 20181022
     *
     * @param userinformationEO
     */
    public void addUserInformation(UserinformationEO userinformationEO) {
        dao.addUserInformation(userinformationEO);
    }

    /**
     * 注册_考生信息关联账号
     * 刘笑天 20181022
     *
     * @param examineeinformationEO
     */
    public void addExamineeInformation(ExamineeinformationEO examineeinformationEO) {
        dao.addExamineeInformation(examineeinformationEO);
    }
}
