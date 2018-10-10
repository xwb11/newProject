package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.generate.entity.MajorinformationEO;
import com.adc.da.generate.entity.SchoolinformationEO;
import com.adc.da.generate.entity.UserinformationEO;
import com.adc.da.generate.page.SchoolinformationEOPage;
import com.adc.da.generate.page.UserinformationEOPage;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>SCHOOLINFORMATION SchoolinformationEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface SchoolinformationEODao extends BaseDao<SchoolinformationEO> {

    int schoolInfoAdd(SchoolinformationEO schoolinformationEO);

    int schoolInfoDelete(String schoolkey);

    int updateByPrimaryKey(SchoolinformationEO schoolinformationEO);

    int updateByPrimaryKeySelective(SchoolinformationEO schoolinformationEO);

    /**
     * 查询学校所有信息(模糊查询)
     * @return
     */
    List<SchoolinformationEO> selectSchoolInfo(SchoolinformationEO schoolinformationEO);

    /**
     * 获取学校信息（分页）
     * @param page
     * @return
     */
    List<SchoolinformationEO> querySchoolInfoByPage(SchoolinformationEOPage page);

    /**
     * 根据学校名称进行查询
     * @param schoolname
     * @return
     */
    List<SchoolinformationEO> selectSchoolByName(String schoolname);

    /**
     *  查询用户账户是否重复
     * @param
     * @return
     */
    //新增时
//    @Select("select * from SCHOOLINFORMATION where 'SchoolName'=#{schoolname}")
    public String schoolNameTesting(SchoolinformationEO schoolinformationEO);
    //修改时
//    @Select("select * from SCHOOLINFORMATION where 'SchoolName'=#{schoolname} and 'SchoolKey'!=#{schoolkey}")
    public String schoolNameTestingWhenUpdate(SchoolinformationEO schoolinformationEO);
}
