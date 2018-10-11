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
    /**
    * @Description:   新增专业信息
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:45
    * @Version:        1.0
    */
    int majorInfoAdd(MajorinformationEO majorinformationEO);
    /**
    * @Description:    删除专业信息
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:45
    * @Version:        1.0
    */
    int majorInfoDelete(String majorkey);
    /**
    * @Description:    修改专业信息
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:46
    * @Version:        1.0
    */
    int updateByPrimaryKey(MajorinformationEO majorinformationEO);
    /**
    * @Description:     修改专业信息(非空修改)
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:46
    * @Version:        1.0
    */
    int updateByPrimaryKeySelective(MajorinformationEO majorinformationEO);
    /**
    * @Description:    查询专业所有信息
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:47
    * @Version:        1.0
    */
    List<MajorinformationEO> selectMajorInfo(MajorinformationEO majorinformationEO);
    /**
    * @Description:    查询专业信息（分页）
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:47
    * @Version:        1.0
    */
    List<MajorinformationEO> queryByMajorInfoPage(MajorinformationEOPage page);
    /**
    * @Description:    根据专业名称进行查询
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:48
    * @Version:        1.0
    */
    List<MajorinformationEO> selectMajorByName(String majorname);
    /**
    * @Description:   查询专业账户是否重复
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:48
    * @Version:        1.0
    */

    //新增时
    public String majorNameTesting(MajorinformationEO majorinformationEO);
    //修改时
    public String majorNameTestingWhenUpdate(MajorinformationEO majorinformationEO);

}
