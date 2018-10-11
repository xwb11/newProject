package com.adc.da.generate.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.ExamineevolunteerinformationEO;
import com.adc.da.generate.page.ExamineevolunteerinformationEOPage;
import com.adc.da.generate.service.ExamineevolunteerinformationEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/generate/examineevolunteerinformation")
@Api(description = "|ExamineevolunteerinformationEO|")
public class ExamineevolunteerinformationEOController extends BaseController<ExamineevolunteerinformationEO>{

    private static final Logger logger = LoggerFactory.getLogger(ExamineevolunteerinformationEOController.class);

    @Autowired
    private ExamineevolunteerinformationEOService examineevolunteerinformationEOService;

	@ApiOperation(value = "|ExamineevolunteerinformationEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("generate:examineevolunteerinformation:page")
    public ResponseMessage<PageInfo<ExamineevolunteerinformationEO>> page(ExamineevolunteerinformationEOPage page) throws Exception {
        List<ExamineevolunteerinformationEO> rows = examineevolunteerinformationEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }
/**
* @Description:   查询被学校录取的信息
* @Author:         xwb
* @CreateDate:     2018/10/9 22:24
* @UpdateUser:     xwb
* @UpdateDate:     2018/10/9 22:24
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
	@ApiOperation(value = "|ExamineevolunteerinformationEO|查询")
    @GetMapping("/selectAdminssionBySchool")
    @RequiresPermissions("generate:examineevolunteerinformation:list")
    public ResponseMessage selectAdminssionBySchool(@RequestParam String examinationnumber) throws Exception {
        return Result.success(examineevolunteerinformationEOService.selectAdminssionBySchool(examinationnumber));
	}

    @ApiOperation(value = "|ExamineevolunteerinformationEO|详情")
    @GetMapping("/{volunteerkey}")
    @RequiresPermissions("generate:examineevolunteerinformation:get")
    public ResponseMessage<ExamineevolunteerinformationEO> find(@PathVariable String volunteerkey) throws Exception {
        return Result.success(examineevolunteerinformationEOService.selectByPrimaryKey(volunteerkey));
    }

    @ApiOperation(value = "|ExamineevolunteerinformationEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:examineevolunteerinformation:save")
    public ResponseMessage<ExamineevolunteerinformationEO> create(@RequestBody ExamineevolunteerinformationEO examineevolunteerinformationEO) throws Exception {
        examineevolunteerinformationEOService.insertSelective(examineevolunteerinformationEO);
        return Result.success(examineevolunteerinformationEO);
    }

    @ApiOperation(value = "|ExamineevolunteerinformationEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:examineevolunteerinformation:update")
    public ResponseMessage<ExamineevolunteerinformationEO> update(@RequestBody ExamineevolunteerinformationEO examineevolunteerinformationEO) throws Exception {
        examineevolunteerinformationEOService.updateByPrimaryKeySelective(examineevolunteerinformationEO);
        return Result.success(examineevolunteerinformationEO);
    }

    @ApiOperation(value = "|ExamineevolunteerinformationEO|删除")
    @DeleteMapping("/{volunteerkey}")
    @RequiresPermissions("generate:examineevolunteerinformation:delete")
    public ResponseMessage delete(@PathVariable String volunteerkey) throws Exception {
        examineevolunteerinformationEOService.deleteByPrimaryKey(volunteerkey);
        logger.info("delete from EXAMINEEVOLUNTEERINFORMATION where volunteerkey = {}", volunteerkey);
        return Result.success();
    }

}
