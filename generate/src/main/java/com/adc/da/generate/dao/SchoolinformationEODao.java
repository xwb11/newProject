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

    /**
    * @Description:    查询学校名称
    * @Author:         xwb
    * @CreateDate:     2018/10/29
    * @Version:        1.0
    */
    String selectSchoolName(String schoolkey);

    /**
    * @Description:    新增学校信息
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:49
    * @Version:        1.0
    */
    int schoolInfoAdd(SchoolinformationEO schoolinformationEO);
    /**
    * @Description:    删除学校信息
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:49
    * @Version:        1.0
    */
    int schoolInfoDelete(String schoolkey);
    /**
    * @Description:    更新学校信息
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:49
    * @Version:        1.0
    */
    int updateByPrimaryKey(SchoolinformationEO schoolinformationEO);
    /**
    * @Description:    更新学校信息（非空修改）
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:50
    * @Version:        1.0
    */
    int updateByPrimaryKeySelective(SchoolinformationEO schoolinformationEO);
    /**
    * @Description:    查询学校所有信息(模糊查询)
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:50
    * @Version:        1.0
    */
    List<SchoolinformationEO> selectSchoolInfo(SchoolinformationEO schoolinformationEO);
    /**
    * @Description:    获取学校信息（分页）
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:51
    * @Version:        1.0
    */
    List<SchoolinformationEO> querySchoolInfoByPage(SchoolinformationEOPage page);
    /**
    * @Description:    根据学校名称进行查询
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:51
    * @Version:        1.0
    */
    List<SchoolinformationEO> selectSchoolByName(String schoolname);
    /**
    * @Description:    j查询用户账户是否重复
    * @Author:         xwb
    * @CreateDate:     2018/10/10 16:51
    * @Version:        1.0
    */
    //新增时
    public String schoolNameTesting(SchoolinformationEO schoolinformationEO);
    //修改时
    public int schoolNameTestingWhenUpdate(SchoolinformationEO schoolinformationEO);
}
