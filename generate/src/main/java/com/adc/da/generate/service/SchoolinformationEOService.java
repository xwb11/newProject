package com.adc.da.generate.service;

import com.adc.da.generate.entity.MajorinformationEO;
import com.adc.da.generate.entity.UserinformationEO;
import com.adc.da.generate.page.SchoolinformationEOPage;
import com.adc.da.generate.page.UserinformationEOPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.SchoolinformationEODao;
import com.adc.da.generate.entity.SchoolinformationEO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.adc.da.generate.util.MajorinformationEOPrompt.MAJORNAME_REPEAT;
import static com.adc.da.generate.util.SchoolinformationEOPrompt.*;

/**
 *
 * <br>
 * <b>功能：</b>SCHOOLINFORMATION SchoolinformationEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("schoolinformationEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class SchoolinformationEOService extends BaseService<SchoolinformationEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(SchoolinformationEOService.class);

    @Autowired
    private SchoolinformationEODao schoolinformationEODao;

    public SchoolinformationEODao getDao() {
        return schoolinformationEODao;
    }

    /**
     * 查询学校信息(模糊查询)
     * @return
     *  宣文彬 2018/10/8
     */
    public List<SchoolinformationEO> selectSchoolInfo(SchoolinformationEO schoolinformationEO){
        return schoolinformationEODao.selectSchoolInfo(schoolinformationEO);
    }

    /**
     * 获取学校信息（分页）
     * @param page
     * @return
     * 宣文彬 2018/10/8
     */
    public List<SchoolinformationEO> querySchoolInfoByPage(SchoolinformationEOPage page) {
        return schoolinformationEODao.querySchoolInfoByPage(page);
    }

    /**
     * 新增专业信息
     * @param schoolinformationEO
     * @return
     * 宣文彬 2018/10/8
     */
    public boolean schoolInfoAdd(SchoolinformationEO schoolinformationEO) {
        if (schoolinformationEO.getSchoolname() != null && !"".equals(schoolinformationEO.getSchoolname())) {
            schoolinformationEO.setSchoolkey(UUID.randomUUID().toString());
            schoolinformationEO.setCreatetime(new Date());
            try {
                    int num = schoolinformationEODao.schoolInfoAdd(schoolinformationEO);
                    if (num > 0) {
                        return true;
                    } else {
                        throw new RuntimeException(INSERTSCHOOLNAME_ERROR);
                    }
            } catch (Exception e) {
                throw new RuntimeException(INSERTSCHOOLNAME_ERROR + e.getMessage());
            }
        } else {
            throw new RuntimeException(SCHOOLNAME_NOTNULL);
        }
    }

    /**
     * 修改专业信息
     * @param schoolinformationEO
     * @return
     * 宣文彬 2018/10/8
     */
    public String updateSchoolInfo(SchoolinformationEO schoolinformationEO){
        if(schoolinformationEO.getSchoolkey()!=null&&!"".equals(schoolinformationEO.getSchoolkey())){
//            schoolinformationEO.setCreatetime(new Date());
            try {
                    //查询id下所对应的学校名称
                    String schoolname = schoolinformationEODao.selectSchoolName(schoolinformationEO.getSchoolkey());
                    //数据库中的学校名称与现页面中传过来的学校名称比较
                    if(schoolname.equals(schoolinformationEO.getSchoolname())){//相等则说明没有修改学校名称，则不进行判重
                        int num = schoolinformationEODao.updateByPrimaryKeySelective(schoolinformationEO);
                        if (num>0) {
                            return UPDATE_SUCCESS;
                        } else {
                            throw new RuntimeException(UPDATESCHOOLNAME_ERROR);
                        }
                    }else {
                        //判断是否存在相同名称
                        int number = schoolinformationEODao.schoolNameTestingWhenUpdate(schoolinformationEO);
                        if(number==0){//==0则不存在相同名称
                            int num = schoolinformationEODao.updateByPrimaryKeySelective(schoolinformationEO);
                            if (num>0) {
                                return UPDATE_SUCCESS;
                            } else {
                                throw new RuntimeException(UPDATESCHOOLNAME_ERROR);
                            }
                        }else {
                            return SCHOOLNAME_REPEAT;
                        }
                    }

            } catch (Exception e) {
                throw new RuntimeException(UPDATESCHOOLNAME_ERROR + e.getMessage());
            }
        }else {
            throw new RuntimeException(SCHOOLNAME_NOTNULL);
        }
    }

    /**
     * 根据主键删除专业信息
     * @param schoolkey
     * @return
     * 宣文彬 2018/10/8
     */
    public boolean deleteSchoolInfo(String schoolkey){
        if(schoolkey!=null){

            try {
                int num = schoolinformationEODao.schoolInfoDelete(schoolkey);
                if (num>0) {
                    return true;
                } else {
                    throw new RuntimeException(DELETESCHOOLNAME_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException(DELETESCHOOLNAME_ERROR + e.getMessage());
            }
        }else {
            throw new RuntimeException(SCHOOLNAME_NOTNULL);
        }
    }

    /**
     * 学校名称判重
     * @param schoolinformationEO
     * @return
     * 宣文彬 2018/10/8
     */

    //新增时
    public String schoolNameTesting(SchoolinformationEO schoolinformationEO){
        //判断数据库中是否已存在相同的名称
        if(schoolinformationEODao.schoolNameTesting(schoolinformationEO)==null){
            //设定返回1代表名称没有重复
            return "1";
        }else {
            return SCHOOLNAME_REPEAT;
        }
    }
    //更新时
//    public String schoolNameTestingWhenUpdate(SchoolinformationEO schoolinformationEO){
//        //判断数据库中是否已存在相同的名称
//        if(schoolinformationEODao.schoolNameTestingWhenUpdate(schoolinformationEO)==null){
//            //设定返回1代表名称没有重复
//            return "1";
//        }else {
//            return SCHOOLNAME_REPEAT;
//        }
//    }
}
