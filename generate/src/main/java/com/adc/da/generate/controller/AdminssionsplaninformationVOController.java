package com.adc.da.generate.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.AdminssionsplaninformationEO;
import com.adc.da.generate.entity.AdminssionsplaninformationVO;
import com.adc.da.generate.page.AdminssionsplaninformationVOPage;
import com.adc.da.generate.service.AdminssionsplaninformationEOService;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/${restPath}/generate/adminssionsplaninformation")
@Api(description = "|AdminssionsplaninformationVO|")
public class AdminssionsplaninformationVOController extends BaseController<AdminssionsplaninformationVO> {

    private static final Logger logger = LoggerFactory.getLogger(AdminssionsplaninformationVOController.class);

    @Autowired
    private AdminssionsplaninformationEOService adminssionsplaninformationEOService;

    /**
     * @Description:    查询招生信息（分页)
     * @Author:         xwb
     * @CreateDate:     2018/10/10 10:44
     * @UpdateUser:     xwb
     * @UpdateDate:     2018/10/10 10:44
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @ApiOperation(value = "|AdminssionsplaninformationVO|查询招生信息（分页）")
    @PostMapping("/queryAdminssionInfoByPage")
    public ResponseMessage<PageInfo<AdminssionsplaninformationVO>> queryAdminssionInfoByPage(AdminssionsplaninformationVOPage page) throws Exception {
        List<AdminssionsplaninformationVO> rows = adminssionsplaninformationEOService.queryAdminssionInfoByPage(page);
        return Result.success(getPageInfo(page.getPager(),rows));
    }

    /**
     * @Description:    查询去年招考信息（分页)
     * @Author:         xwb
     * @CreateDate:     2018/10/10 10:44
     * @UpdateUser:     xwb
     * @UpdateDate:     2018/10/10 10:44
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @ApiOperation(value = "|AdminssionsplaninformationVO|查询去年招考信息（分页）")
    @PostMapping("/queryLastAdminssionInfoByPage")
    public ResponseMessage<PageInfo<AdminssionsplaninformationVO>> queryLastAdminssionInfoByPage(AdminssionsplaninformationVOPage page) throws Exception {
        List<AdminssionsplaninformationVO> rows = adminssionsplaninformationEOService.selectLastYearAdmission(page);
        return Result.success(getPageInfo(page.getPager(),rows));
    }
}
