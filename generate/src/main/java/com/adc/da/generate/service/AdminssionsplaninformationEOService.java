package com.adc.da.generate.service;

import com.adc.da.base.page.BasePage;
import com.adc.da.generate.VO.AdminssionsplaninformationVO;
import com.adc.da.generate.VO.ExamineeinformationVO;
import com.adc.da.generate.page.AdminssionsplaninformationEOPage;
import com.adc.da.generate.page.AdminssionsplaninformationVOPage;
import com.adc.da.myutil.service.IDUtils;
import com.adc.da.util.http.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.AdminssionsplaninformationEODao;
import com.adc.da.generate.entity.AdminssionsplaninformationEO;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * <br>
 * <b>功能：</b>ADMINSSIONSPLANINFORMATION AdminssionsplaninformationEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("adminssionsplaninformationEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class AdminssionsplaninformationEOService extends BaseService<AdminssionsplaninformationEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(AdminssionsplaninformationEOService.class);

    @Autowired
    private AdminssionsplaninformationEODao dao;

    public AdminssionsplaninformationEODao getDao() {
        return dao;
    }
//    /**
//    * @Description:    查询本年招生信息（分页查询）
//    * @Author:         xwb
//    * @CreateDate:     2018/10/10 16:58
//    * @Version:        1.0
//    */
//    public List<AdminssionsplaninformationVO> queryAdminssionInfoByPage(BasePage page) throws Exception {
//        Integer rowCount = this.queryByCount(page);
//        page.getPager().setRowCount(rowCount);
//        return this.dao.queryAdmissionInfoByPage(page);
//    }

    /**
    * @Description:    当年录取信息分页模糊查询
    * @Author:         xwb
    * @CreateDate:     2018/10/24 15:34
    * @Version:        1.0
    */
    public PageInfo<AdminssionsplaninformationVO> queryAdmissionByPage(BasePage page) throws Exception {
        Integer rowCount = this.queryByCount(page);
        page.getPager().setRowCount(rowCount);
        PageInfo<AdminssionsplaninformationVO> pageInfo = new PageInfo();
        pageInfo.setList(this.dao.queryAdmissionInfoByPage(page));
        pageInfo.setCount((long)rowCount);
        pageInfo.setPageSize(page.getPager().getPageSize());
        pageInfo.setPageCount((long)page.getPager().getPageCount());
        pageInfo.setPageNo(page.getPager().getPageId());
        return pageInfo;
    }

    /**
    * @Description:    获取招生信息符合条件的信息数
    * @Author:         xwb
    * @CreateDate:     2018/10/12 13:25
    * @Version:        1.0
    */
    public int queryByCount(BasePage page) throws Exception {
        return this.getDao().queryAdminssionByCount(page);
    }


    /**
     * @Description:    获取去年招考信息符合条件的信息数
     * @Author:         xwb
     * @CreateDate:     2018/10/12 13:25
     * @Version:        1.0
     */
    public int queryLastByCount(BasePage page) throws Exception {
        return this.getDao().queryLastAdminssionByCount(page);
    }

//    public List<AdminssionsplaninformationVO> selectLastYearAdmission(AdminssionsplaninformationVO adminssionsplaninformationVO){
//        return dao.selectLastYearAdmission(adminssionsplaninformationVO);
//    }
    /**
    * @Description:    查询去年招考信息
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:59
    * @Version:        1.0
    */
    public List<AdminssionsplaninformationVO> selectLastYearAdmission(BasePage page) throws Exception {
        Integer rowCount = this.queryLastByCount(page);
        page.getPager().setRowCount(rowCount);
        return this.dao.selectLastYearAdmission(page);
    }

    /**
    * @Description:    查询去年招考信息 分页模糊查询
    * @Author:         xwb
    * @CreateDate:     2018/10/24 15:46
    */
    public PageInfo<AdminssionsplaninformationVO> queryLastAdmissionByPage(BasePage page) throws Exception {
        Integer rowCount = this.queryLastByCount(page);
        page.getPager().setRowCount(rowCount);
        PageInfo<AdminssionsplaninformationVO> pageInfo = new PageInfo();
        pageInfo.setList(this.dao.selectLastYearAdmission(page));
        pageInfo.setCount((long)rowCount);
        pageInfo.setPageSize(page.getPager().getPageSize());
        pageInfo.setPageCount((long)page.getPager().getPageCount());
        pageInfo.setPageNo(page.getPager().getPageId());
        return pageInfo;
    }

    /**
     * 获取已发布专业的学校
     * 刘笑天 20181011
     * @return
     */
    public List<Map<String,Object>> getSchools(){
        return dao.getSchools();
    }

    /**
     * 获取学校已发布的专业
     * 刘笑天 20181011
     * @param schoolKey
     * @return
     */
    public List<Map<String,Object>> getSchoolsPublishedMajor(String schoolKey){
        return dao.getSchoolsPublishedMajor(schoolKey);
    }


    /**
    * @Description:   _获取学校，省份，专业模糊查询的集合
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:50
    * @UpdateUser:     yueben
    * @UpdateDate:     2018/10/24 9:50
    * @UpdateRemark:   修改内容
    */
    public List<AdminssionsplaninformationVO> selectBySMP(AdminssionsplaninformationEOPage page) throws Exception{
        //获取当前年份
        Calendar cal = Calendar.getInstance();
        page.setCreateyear(String.valueOf(cal.get(Calendar.YEAR)));
        //接收查询到的数据（分页）
        List<AdminssionsplaninformationVO> list = dao.selectBySMP(page);
        //获取数据总条数，用于分页
        Integer rowCount = dao.countBySMP(page);
        page.getPager().setRowCount(rowCount.intValue());
        return list;
    }

    /**
    * @Description:   _获取所有招生计划数据（分页）
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:54
    * @UpdateUser:     yueben
    * @UpdateDate:     2018/10/24 9:54
    * @UpdateRemark:   修改内容
    */
    public List<AdminssionsplaninformationVO> selectAll(AdminssionsplaninformationEOPage page) throws Exception{
        //设置创建啊年份
        Calendar cal = Calendar.getInstance();
        page.setCreateyear(String.valueOf(cal.get(Calendar.YEAR)));
        //接收查询到的数据（分页）
        List<AdminssionsplaninformationVO> list = dao.selectAll(page);
        //获取数据总条数，用于分页
        Integer rowCount = dao.queryByCount(page);
        page.getPager().setRowCount(rowCount.intValue());
        return list;
    }

    /**
    * @Description:   _新增招生计划
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:55
    * @UpdateUser:     yueben
    * @UpdateDate:     2018/10/24 9:55
    * @UpdateRemark:   修改内容
    */
    public String insertOne(AdminssionsplaninformationEO adminssionsplaninformationEO) throws Exception{
        //格式化时间
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置创建啊年份
        Calendar cal = Calendar.getInstance();
        adminssionsplaninformationEO.setCreateyear(String.valueOf(cal.get(Calendar.YEAR)));
        //生成ID
        adminssionsplaninformationEO.setAdminssionskey(String.valueOf(IDUtils.genItemId()));
        //设置创建时间
        adminssionsplaninformationEO.setCreatetime(sdf.parse(sdf.format(now)));
        //设置状态为未发布
        adminssionsplaninformationEO.setIspublish(0);
        //验重
        if(dao.isRepeat(adminssionsplaninformationEO) != null){
            return "-1";
        }

        return dao.insertSelective(adminssionsplaninformationEO)>0?"ok":"fail";
    }

    /**
    * @Description:   _修改招生计划
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:56
    * @UpdateUser:     yueben
    * @UpdateDate:     2018/10/24 9:56
    * @UpdateRemark:   修改内容
    */
    public String updataByKey(AdminssionsplaninformationEO adminssionsplaninformationEO) throws Exception{
        //验重
        String adminKey = dao.isRepeat(adminssionsplaninformationEO);
        if(!adminKey.equals(adminssionsplaninformationEO.getAdminssionskey()) && adminKey != null){
            return "-1";
        }

        return dao.updateByPrimaryKeySelective(adminssionsplaninformationEO)>0?"ok":"fail";

    }

    /**
    * @Description:   _删除一条招生计划
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:57
    * @UpdateUser:     yueben
    * @UpdateDate:     2018/10/24 9:57
    * @UpdateRemark:   修改内容
    */
    public String deleteByKey(String adminssionskey) throws Exception{
        return dao.deleteByKey(adminssionskey)>0?"ok":"fail";
    }

    /**
    * @Description:   _发布招生计划
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:57
    * @UpdateUser:     yueben
    * @UpdateDate:     2018/10/24 9:57
    * @UpdateRemark:   修改内容
    */
    public  String release(AdminssionsplaninformationEO adminssionsplaninformationEO) throws Exception{
        //格式化时间
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置发布时间
        adminssionsplaninformationEO.setPublishtime(sdf.parse(sdf.format(now)));
        //设置状态为未发布
        adminssionsplaninformationEO.setIspublish(1);

        return dao.updateByPrimaryKeySelective(adminssionsplaninformationEO)>0?"ok":"fail";
    }

}
