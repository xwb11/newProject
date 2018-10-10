package com.adc.da.generate.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import com.adc.da.generate.entity.AdminssionsplaninformationVO;
import com.adc.da.generate.entity.SchoolinformationEO;
import com.adc.da.generate.page.AdminssionsplaninformationVOPage;
import com.adc.da.generate.page.SchoolinformationEOPage;
import com.adc.da.myutil.util.PublicPrompt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.AdminssionsplaninformationEO;
import com.adc.da.generate.page.AdminssionsplaninformationEOPage;
import com.adc.da.generate.service.AdminssionsplaninformationEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/generate/adminssionsplaninformation")
@Api(description = "|AdminssionsplaninformationEO|")
public class AdminssionsplaninformationEOController extends BaseController<AdminssionsplaninformationEO>{

    private static final Logger logger = LoggerFactory.getLogger(AdminssionsplaninformationEOController.class);

    @Autowired
    private AdminssionsplaninformationEOService adminssionsplaninformationEOService;

	@ApiOperation(value = "|AdminssionsplaninformationEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("generate:adminssionsplaninformation:page")
    public ResponseMessage<PageInfo<AdminssionsplaninformationEO>> page(AdminssionsplaninformationEOPage page) throws Exception {
        List<AdminssionsplaninformationEO> rows = adminssionsplaninformationEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

//    /**
//    * @Description:    查询招生信息（分页)
//    * @Author:         xwb
//    * @CreateDate:     2018/10/10 10:44
//    * @UpdateUser:     xwb
//    * @UpdateDate:     2018/10/10 10:44
//    * @UpdateRemark:   修改内容
//    * @Version:        1.0
//    */
//    @ApiOperation(value = "|AdminssionsplaninformationVO|查询招生信息（分页）")
//    @GetMapping("/queryAdminssionInfoByPage")
//    public ResponseMessage<PageInfo<AdminssionsplaninformationVO>> queryAdminssionInfoByPage(AdminssionsplaninformationVOPage page) throws Exception {
//        List<AdminssionsplaninformationVO> rows = adminssionsplaninformationEOService.queryAdminssionInfoByPage(page);
//        return Result.success(getPageInfo(page.getPager(),rows));
//    }

    /**
    * @Description:    查询本年招生信息(模糊查询)
    * @Author:         xwb
    * @CreateDate:     2018/10/9 22:23
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/10/9 22:23
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
	@ApiOperation(value = "|AdminssionsplaninformationEO|查询本年招生信息")
    @PostMapping("/selectAdminssion")
    @RequiresPermissions("generate:adminssionsplaninformation:list")
    public ResponseMessage selectAdminssion(@RequestBody AdminssionsplaninformationVO adminssionsplaninformationVO) throws Exception {
        return Result.success(PublicPrompt.SEARCH_SUCCESS,adminssionsplaninformationEOService.selectAdminssion(adminssionsplaninformationVO));
	}

//	/**
//	* @Description:    查询去年招考信息
//	* @Author:         xwb
//	* @CreateDate:     2018/10/9 22:22
//	* @UpdateUser:     xwb
//	* @UpdateDate:     2018/10/9 22:22
//	* @UpdateRemark:   修改内容
//	* @Version:        1.0
//	*/
//    @ApiOperation(value = "|AdminssionsplaninformationEO|查询去年招考信息")
//    @PostMapping("/selectLastYearAdminssion")
//    @RequiresPermissions("generate:adminssionsplaninformation:list")
//    public ResponseMessage selectLastYearAdminssion(@RequestBody AdminssionsplaninformationVO adminssionsplaninformationVO) throws Exception {
//        return Result.success(PublicPrompt.SEARCH_SUCCESS,adminssionsplaninformationEOService.selectLastYearAdmission(adminssionsplaninformationVO));
//    }


    @ApiOperation(value = "|AdminssionsplaninformationEO|详情")
    @GetMapping("/{adminssionskey}")
    @RequiresPermissions("generate:adminssionsplaninformation:get")
    public ResponseMessage<AdminssionsplaninformationEO> find(@PathVariable String adminssionskey) throws Exception {
        return Result.success(adminssionsplaninformationEOService.selectByPrimaryKey(adminssionskey));
    }

    @ApiOperation(value = "|AdminssionsplaninformationEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:adminssionsplaninformation:save")
    public ResponseMessage<AdminssionsplaninformationEO> create(@RequestBody AdminssionsplaninformationEO adminssionsplaninformationEO) throws Exception {
        adminssionsplaninformationEOService.insertSelective(adminssionsplaninformationEO);
        return Result.success(adminssionsplaninformationEO);
    }

    @ApiOperation(value = "|AdminssionsplaninformationEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:adminssionsplaninformation:update")
    public ResponseMessage<AdminssionsplaninformationEO> update(@RequestBody AdminssionsplaninformationEO adminssionsplaninformationEO) throws Exception {
        adminssionsplaninformationEOService.updateByPrimaryKeySelective(adminssionsplaninformationEO);
        return Result.success(adminssionsplaninformationEO);
    }

    @ApiOperation(value = "|AdminssionsplaninformationEO|删除")
    @DeleteMapping("/{adminssionskey}")
    @RequiresPermissions("generate:adminssionsplaninformation:delete")
    public ResponseMessage delete(@PathVariable String adminssionskey) throws Exception {
        adminssionsplaninformationEOService.deleteByPrimaryKey(adminssionskey);
        logger.info("delete from ADMINSSIONSPLANINFORMATION where adminssionskey = {}", adminssionskey);
        return Result.success();
    }
    @ApiOperation(value = "|AdminssionsplaninformationEO|获取已发布专业的学校")
    @PostMapping("/getSchool")
    public ResponseMessage getSchool(){
        List<Map<String,Object>> schools= adminssionsplaninformationEOService.getSchools();
        return Result.success(schools);
    }

    @ApiOperation(value = "|AdminssionsplaninformationEO|获取学校发布的专业")
    @PostMapping("/getSchoolsPublishedMajor")
    public ResponseMessage getSchoolsPublishedMajor(@RequestParam String schoolKey){
        List<Map<String,Object>> schoolPublishedMajors= adminssionsplaninformationEOService.getSchoolsPublishedMajor(schoolKey);
        return Result.success(schoolPublishedMajors);
    }



}
