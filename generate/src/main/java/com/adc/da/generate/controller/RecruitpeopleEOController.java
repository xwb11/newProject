package com.adc.da.generate.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;

import com.adc.da.generate.VO.RecruitpeopleVO;
import com.adc.da.generate.page.RecruitpeopleVOPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.RecruitpeopleEO;
import com.adc.da.generate.page.RecruitpeopleEOPage;
import com.adc.da.generate.service.RecruitpeopleEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/generate/recruitpeople")
@Api(description = "|RecruitpeopleEO|")
public class RecruitpeopleEOController extends BaseController<RecruitpeopleEO>{

    private static final Logger logger = LoggerFactory.getLogger(RecruitpeopleEOController.class);

    @Autowired
    private RecruitpeopleEOService recruitpeopleEOService;

	@ApiOperation(value = "|RecruitpeopleEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("generate:recruitpeople:page")
    public ResponseMessage<PageInfo<RecruitpeopleEO>> page(RecruitpeopleEOPage page) throws Exception {
        List<RecruitpeopleEO> rows = recruitpeopleEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|RecruitpeopleEO|查询")
    @GetMapping("")
    @RequiresPermissions("generate:recruitpeople:list")
    public ResponseMessage<List<RecruitpeopleEO>> list(RecruitpeopleEOPage page) throws Exception {
        return Result.success(recruitpeopleEOService.queryByList(page));
	}

    @ApiOperation(value = "|RecruitpeopleEO|详情")
    @GetMapping("/{userKey}")
    @RequiresPermissions("generate:recruitpeople:get")
    public ResponseMessage<RecruitpeopleEO> find(@PathVariable String userKey) throws Exception {
        return Result.success(recruitpeopleEOService.selectByPrimaryKey(userKey));
    }

    @ApiOperation(value = "|RecruitpeopleEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:recruitpeople:save")
    public ResponseMessage<RecruitpeopleEO> create(@RequestBody RecruitpeopleEO recruitpeopleEO) throws Exception {
        recruitpeopleEOService.insertSelective(recruitpeopleEO);
        return Result.success(recruitpeopleEO);
    }

    @ApiOperation(value = "|RecruitpeopleEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:recruitpeople:update")
    public ResponseMessage<RecruitpeopleEO> update(@RequestBody RecruitpeopleEO recruitpeopleEO) throws Exception {
        recruitpeopleEOService.updateByPrimaryKeySelective(recruitpeopleEO);
        return Result.success(recruitpeopleEO);
    }

    @ApiOperation(value = "|RecruitpeopleEO|删除")
    @DeleteMapping("/{userKey}")
    @RequiresPermissions("generate:recruitpeople:delete")
    public ResponseMessage delete(@PathVariable String userKey) throws Exception {
        recruitpeopleEOService.deleteByPrimaryKey(userKey);
        logger.info("delete from RECRUITPEOPLE where userKey = {}", userKey);
        return Result.success();
    }

    @ApiOperation(value = "|RecruitpeopleEO|招募人员分页查询")
    @PostMapping("/selectRecruitpeople")
    @RequiresPermissions("generate:recruitpeople:page")
    public ResponseMessage<PageInfo<RecruitpeopleVO>> selectRecruitpeople(@RequestBody RecruitpeopleVOPage page) throws Exception {
        PageInfo<RecruitpeopleVO> rows = recruitpeopleEOService.selectDemandvolunteerinformation(page);
        return Result.success(rows);
    }

    @ApiOperation(value = "|RecruitpeopleEO|招募人员新增")
    @PostMapping("/addRecruitpeople")
    @RequiresPermissions("generate:recruitpeople:save")
    public ResponseMessage<RecruitpeopleVO> addRecruitpeople(@RequestBody RecruitpeopleVO recruitpeopleVO) throws Exception {
        recruitpeopleEOService.insertSelective(recruitpeopleVO);
        return Result.success(recruitpeopleVO);
    }

    @ApiOperation(value = "|RecruitpeopleEO|招募人员删除")
    @PostMapping("/deleteRecruitpeople")
    @RequiresPermissions("generate:recruitpeople:delete")
    public ResponseMessage deleteRecruitpeople(@RequestParam String userKey) throws Exception {
        recruitpeopleEOService.deleteByPrimaryKey(userKey);
        return Result.success();
    }

    @ApiOperation(value = "|RecruitpeopleEO|招募人员修改")
    @PutMapping("/updateRecruitpeople")
    @RequiresPermissions("generate:recruitpeople:update")
    public ResponseMessage<RecruitpeopleEO> updateRecruitpeople(@RequestBody RecruitpeopleEO recruitpeopleEO) throws Exception {
        recruitpeopleEOService.updateByPrimaryKeySelective(recruitpeopleEO);
        return Result.success(recruitpeopleEO);
    }
}
