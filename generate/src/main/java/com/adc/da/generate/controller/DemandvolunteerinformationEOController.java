package com.adc.da.generate.controller;

import static com.adc.da.generate.util.DemandvolunteerinformationEOPrompt.ENTRY_SUCCESS;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.adc.da.generate.VO.DemandvolunteerinformationVO;
import com.adc.da.generate.page.DemandvolunteerinformationVOPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.DemandvolunteerinformationEO;
import com.adc.da.generate.page.DemandvolunteerinformationEOPage;
import com.adc.da.generate.service.DemandvolunteerinformationEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/generate/demandvolunteerinformation")
@Api(description = "|DemandvolunteerinformationEO|")
public class DemandvolunteerinformationEOController extends BaseController<DemandvolunteerinformationEO>{

    private static final Logger logger = LoggerFactory.getLogger(DemandvolunteerinformationEOController.class);

    @Autowired
    private DemandvolunteerinformationEOService demandvolunteerinformationEOService;

	@ApiOperation(value = "|DemandvolunteerinformationEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("generate:demandvolunteerinformation:page")
    public ResponseMessage<PageInfo<DemandvolunteerinformationEO>> page(DemandvolunteerinformationEOPage page) throws Exception {
        List<DemandvolunteerinformationEO> rows = demandvolunteerinformationEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|DemandvolunteerinformationEO|查询")
    @GetMapping("")
    @RequiresPermissions("generate:demandvolunteerinformation:list")
    public ResponseMessage<List<DemandvolunteerinformationEO>> list(DemandvolunteerinformationEOPage page) throws Exception {
        return Result.success(demandvolunteerinformationEOService.queryByList(page));
	}

    @ApiOperation(value = "|DemandvolunteerinformationEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:demandvolunteerinformation:save")
    public ResponseMessage<DemandvolunteerinformationEO> create(@RequestBody DemandvolunteerinformationEO demandvolunteerinformationEO) throws Exception {
        demandvolunteerinformationEOService.insertSelective(demandvolunteerinformationEO);
        return Result.success(demandvolunteerinformationEO);
    }

    @ApiOperation(value = "|DemandvolunteerinformationEO|需求计划创建新增")
    @PostMapping("/addDemandvolunteerinformation")
    @RequiresPermissions("generate:demandvolunteerinformation:save")
    public ResponseMessage<DemandvolunteerinformationEO> addDemandvolunteerinformation(@RequestBody DemandvolunteerinformationEO demandvolunteerinformationEO) throws Exception {
	    demandvolunteerinformationEO.setDemandKey(UUID.randomUUID().toString());
	    demandvolunteerinformationEO.setCreateTime(new Date());
        demandvolunteerinformationEOService.insertSelective(demandvolunteerinformationEO);
        return Result.success();
    }

    @ApiOperation(value = "|DemandvolunteerinformationEO|需求计划分页查询")
    @PostMapping("/selectDemandvolunteerinformation")
    @RequiresPermissions("generate:demandvolunteerinformation:page")
    public ResponseMessage<PageInfo<DemandvolunteerinformationVO>> selectDemandvolunteerinformation(@RequestBody DemandvolunteerinformationVOPage page) throws Exception {
        PageInfo<DemandvolunteerinformationVO> rows = demandvolunteerinformationEOService.selectDemandvolunteerinformation(page);
        return Result.success(rows);
    }

    @ApiOperation(value = "|DemandvolunteerinformationEO|需求计划创建更新")
    @PostMapping("/updateDemandvolunteerinformation")
    @RequiresPermissions("generate:demandvolunteerinformation:update")
    public ResponseMessage<DemandvolunteerinformationEO> updateDemandvolunteerinformation(@RequestBody DemandvolunteerinformationEO demandvolunteerinformationEO) throws Exception {
	    demandvolunteerinformationEO.setPublishTime(new Date());
        demandvolunteerinformationEOService.updateByPrimaryKeySelective(demandvolunteerinformationEO);
        return Result.success();
    }

    @ApiOperation(value = "|DemandvolunteerinformationEO|需求计划创建删除")
    @PostMapping("/deleteDemandvolunteerinformation")
    @RequiresPermissions("generate:demandvolunteerinformation:delete")
    public ResponseMessage<DemandvolunteerinformationVO> deleteDemandvolunteerinformation(@RequestBody DemandvolunteerinformationVO demandvolunteerinformationVO) throws Exception {
        demandvolunteerinformationEOService.deleteDemandvolunteerinformation(demandvolunteerinformationVO);
        return Result.success();
    }

}
