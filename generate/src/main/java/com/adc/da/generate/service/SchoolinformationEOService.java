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
                //判断学校名称是否重复
                if(schoolinformationEODao.schoolNameTesting(schoolinformationEO)==null){
                    int num = schoolinformationEODao.schoolInfoAdd(schoolinformationEO);
                    if (num > 0) {
                        return true;
                    } else {
                        throw new RuntimeException(INSERTSCHOOLNAME_ERROR);
                    }
                }else {
                    throw new RuntimeException(SCHOOLNAME_REPEAT);
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
     */
    public boolean updateSchoolInfo(SchoolinformationEO schoolinformationEO){
        if(schoolinformationEO.getSchoolkey()!=null&&!"".equals(schoolinformationEO.getSchoolkey())){
            schoolinformationEO.setCreatetime(new Date());
            try {
                if(schoolinformationEODao.schoolNameTestingWhenUpdate(schoolinformationEO)==null){
                    int num = schoolinformationEODao.updateByPrimaryKeySelective(schoolinformationEO);
                    if (num>0) {
                        return true;
                    } else {
                        throw new RuntimeException(UPDATESCHOOLNAME_ERROR);
                    }
                }else {
                    throw new RuntimeException(SCHOOLNAME_REPEAT);
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
}
