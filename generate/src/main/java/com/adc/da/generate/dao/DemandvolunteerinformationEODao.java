package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.base.page.BasePage;
import com.adc.da.generate.VO.DemandvolunteerinformationVO;
import com.adc.da.generate.entity.DemandvolunteerinformationEO;
import com.adc.da.generate.page.DemandvolunteerinformationVOPage;
import com.sun.xml.internal.rngom.parse.host.Base;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>DEMANDVOLUNTEERINFORMATION DemandvolunteerinformationEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface DemandvolunteerinformationEODao extends BaseDao<DemandvolunteerinformationEO> {


    /**
    * @Description:    查询创建信息
    * @Author:         xwb
    * @CreateDate:     2018/11/10 11:40
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/11/10 11:40
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    List<DemandvolunteerinformationVO> selectDemandvolunteerinformation(BasePage page);

    /**
    * @Description:   新增创建信息
    * @Author:         xwb
    * @CreateDate:     2018/11/10 11:41
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/11/10 11:41
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    int addDemandvolunteerinformation(DemandvolunteerinformationVO demandvolunteerinformationVO);

    /**
    * @Description:    修改需求创建信息
    * @Author:         xwb
    * @CreateDate:     2018/11/10 12:06
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/11/10 12:06
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    int updateDemandvolunteerinformation(DemandvolunteerinformationVO demandvolunteerinformationVO);

    /**
    * @Description:   删除创建信息
    * @Author:         xwb
    * @CreateDate:     2018/11/10 12:07
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/11/10 12:07
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    int deleteDemandvolunteerinformation(DemandvolunteerinformationVO demandvolunteerinformationVO);

    int queryByDemandCount(BasePage page);

    int selectIsPublish();
}
