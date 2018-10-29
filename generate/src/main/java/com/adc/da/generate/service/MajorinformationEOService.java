package com.adc.da.generate.service;

import com.adc.da.generate.entity.SchoolinformationEO;
import com.adc.da.generate.page.MajorinformationEOPage;
import com.adc.da.generate.page.SchoolinformationEOPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.MajorinformationEODao;
import com.adc.da.generate.entity.MajorinformationEO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.adc.da.generate.util.MajorinformationEOPrompt.*;

/**
 *
 * <br>
 * <b>功能：</b>MAJORINFORMATION MajorinformationEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("majorinformationEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class MajorinformationEOService extends BaseService<MajorinformationEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(MajorinformationEOService.class);

    @Autowired
    private MajorinformationEODao majorinformationEODao;

    public MajorinformationEODao getDao() {
        return majorinformationEODao;
    }

    /**
     * 查询专业信息（模糊查询）
     * @return
     *  宣文彬 2018/10/8
     */
    public List<MajorinformationEO> selectMajorInfo(MajorinformationEO majorinformationEO){
        return majorinformationEODao.selectMajorInfo(majorinformationEO);
    }

    /**
     * 查询专业信息（分页）
     * @param page
     * @return
     * 宣文彬 2018/10/8
     */
    public List<MajorinformationEO> queryMajorInfoByPage(MajorinformationEOPage page) {
        return majorinformationEODao.queryByMajorInfoPage(page);
    }

    /**
     * 新增专业信息
     * @param majorinformationEO
     * @return
     * 宣文彬 2018/10/8
     */
    public boolean majorInfoAdd(MajorinformationEO majorinformationEO) {
        if (majorinformationEO.getMajorname() != null && !"".equals(majorinformationEO.getMajorname())) {
           majorinformationEO.setMajorkey(UUID.randomUUID().toString());
            majorinformationEO.setCreatetime(new Date());
            try {
                    int num = majorinformationEODao.majorInfoAdd(majorinformationEO);
                    if (num > 0) {
                        return true;
                    } else {
                        throw new RuntimeException(INSERTMAJORNAME_ERROR);
                    }
            } catch (Exception e) {
                throw new RuntimeException(INSERTMAJORNAME_ERROR + e.getMessage());
            }
        } else {
            throw new RuntimeException(MAJORNAME_NOTNULL);
        }
    }

    /**
     * 修改专业信息
     * @param majorinformationEO
     * @return
     * 宣文彬 2018/10/8
     */
    public boolean updateMajorInfo(@RequestBody MajorinformationEO majorinformationEO){
        if(majorinformationEO.getMajorname()!=null&&!"".equals(majorinformationEO.getMajorname())){
//            majorinformationEO.setCreatetime(new Date());
            try {
                    ////查询id下所对应的专业名称
                    String majorName = majorinformationEODao.selectMajorName(majorinformationEO.getMajorkey());
                    //数据库中的专业名称与现页面中传过来的专业名称比较
                    if(majorName.equals(majorinformationEO.getMajorname())){//相等则说明没有修改学校名称，则不进行判重
                        int num = majorinformationEODao.updateByPrimaryKeySelective(majorinformationEO);
                        if (num>0) {
                            return true;
                        } else {
                            throw new RuntimeException(UPDATEMAJORNAME_ERROR);
                        }
                    }else {
                        //判断是否存在相同名称
                        int number = majorinformationEODao.majorNameTestingWhenUpdate(majorinformationEO);
                        if(number ==0){//==0则不存在相同名称
                            int num = majorinformationEODao.updateByPrimaryKeySelective(majorinformationEO);
                            if (num>0) {
                                return true;
                            } else {
                                throw new RuntimeException(UPDATEMAJORNAME_ERROR);
                            }
                        }else {
                            return false;
                        }
                    }

            } catch (Exception e) {
                throw new RuntimeException( UPDATEMAJORNAME_ERROR+ e.getMessage());
            }
        }else {
            throw new RuntimeException(MAJORNAME_NOTNULL);
        }
    }

    /**
     * 根据主键删除专业信息
     * @param majorkey
     * @return
     * 宣文彬 2018/10/8
     */
    public boolean dleteMajorInfo(String majorkey){
        if(majorkey!=null){
            try {
                int num = majorinformationEODao.majorInfoDelete(majorkey);
                if (num>0) {
                    return true;
                } else {
                    throw new RuntimeException(DELETEMAJORNAME_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException(DELETEMAJORNAME_ERROR + e.getMessage());
            }
        }else {
            throw new RuntimeException(MAJORNAME_NOTNULL);
        }
    }

    /**
     * 专业名称判重
     * @param majorinformationEO
     * @return
     * 宣文彬 2018/10/8
     */

    //新增时
    public String majorNameTesting(MajorinformationEO majorinformationEO){
        //判断数据库中是否已存在相同的名称
        if(majorinformationEODao.majorNameTesting(majorinformationEO)==null){
            //设定返回1代表名称没有重复
            return "1";
        }else {
            return MAJORNAME_REPEAT;
        }
    }
    //更新时
//    public String majorNameTestingWhenUpdate(MajorinformationEO majorinformationEO){
//        //判断数据库中是否已存在相同的名称
//        if(majorinformationEODao.majorNameTestingWhenUpdate(majorinformationEO)==null){
//            //设定返回1代表名称没有重复
//            return "1";
//        }else {
//            return MAJORNAME_REPEAT;
//        }
//    }

}
