package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.generate.entity.MajorinformationEO;
import com.adc.da.generate.page.MajorinformationEOPage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>MAJORINFORMATION MajorinformationEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface MajorinformationEODao extends BaseDao<MajorinformationEO> {

    int majorInfoAdd(MajorinformationEO majorinformationEO);

    int majorInfoDelete(String majorkey);

    int updateByPrimaryKey(MajorinformationEO majorinformationEO);

    int updateByPrimaryKeySelective(MajorinformationEO majorinformationEO);

    /**
     * 查询专业所有信息
     * @return
     */
    List<MajorinformationEO> selectMajorInfo(MajorinformationEO majorinformationEO);

    /**
     * 查询专业信息（分页）
     * @param page
     * @return
     */
    List<MajorinformationEO> queryByMajorInfoPage(MajorinformationEOPage page);



    /**
     * 根据专业名称进行查询
     * @param majorname
     * @return
     */
    List<MajorinformationEO> selectMajorByName(String majorname);

    /**
     *  查询专业账户是否重复
     * @param
     * @return
     */
    //新增时
//    @Select("select * from MAJORINFORMATION where MajorName=#{MajorName}")
    public String majorNameTesting(MajorinformationEO majorinformationEO);
    //修改时
//    @Select("select * from MAJORINFORMATION where MajorName=#{MajorName} and MajorKey!=#{MajorKey}")
    public String majorNameTestingWhenUpdate(MajorinformationEO majorinformationEO);

}
