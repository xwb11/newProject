package com.adc.da.generate.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.base.page.BasePage;
import com.adc.da.generate.VO.RecruitpeopleVO;
import com.adc.da.generate.entity.RecruitpeopleEO;
import com.sun.xml.internal.rngom.parse.host.Base;

import java.util.List;

/**
 *
 * <br>
 * <b>功能：</b>RECRUITPEOPLE RecruitpeopleEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public interface RecruitpeopleEODao extends BaseDao<RecruitpeopleEO> {

    List<RecruitpeopleVO> queryByRecruitpeopleVO(BasePage page);

    int queryRecruitpeopleVOCount(BasePage page);
}
