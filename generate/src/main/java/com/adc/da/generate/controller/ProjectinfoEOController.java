package com.adc.da.generate.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import com.adc.da.myutil.util.PublicPrompt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.ProjectinfoEO;
import com.adc.da.generate.page.ProjectinfoEOPage;
import com.adc.da.generate.service.ProjectinfoEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/generate/projectinfo")
@Api(description = "|ProjectinfoEO|")
public class ProjectinfoEOController extends BaseController<ProjectinfoEO>{

    private static final Logger logger = LoggerFactory.getLogger(ProjectinfoEOController.class);

    @Autowired
    private ProjectinfoEOService projectinfoEOService;

	@ApiOperation(value = "|ProjectinfoEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("generate:projectinfo:page")
    public ResponseMessage<PageInfo<ProjectinfoEO>> page(ProjectinfoEOPage page) throws Exception {
        List<ProjectinfoEO> rows = projectinfoEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|ProjectinfoEO|查询")
    @GetMapping("")
    @RequiresPermissions("generate:projectinfo:list")
    public ResponseMessage<List<ProjectinfoEO>> list(ProjectinfoEOPage page) throws Exception {
        return Result.success(projectinfoEOService.queryByList(page));
	}

    @ApiOperation(value = "|ProjectinfoEO|详情")
    @GetMapping("/{projectKey}")
    @RequiresPermissions("generate:projectinfo:get")
    public ResponseMessage<ProjectinfoEO> find(@PathVariable String projectKey) throws Exception {
        return Result.success(projectinfoEOService.selectByPrimaryKey(projectKey));
    }

    @ApiOperation(value = "|ProjectinfoEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:projectinfo:save")
    public ResponseMessage<ProjectinfoEO> create(@RequestBody ProjectinfoEO projectinfoEO) throws Exception {
        projectinfoEOService.insertSelective(projectinfoEO);
        return Result.success(projectinfoEO);
    }

    @ApiOperation(value = "|ProjectinfoEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:projectinfo:update")
    public ResponseMessage<ProjectinfoEO> update(@RequestBody ProjectinfoEO projectinfoEO) throws Exception {
        projectinfoEOService.updateByPrimaryKeySelective(projectinfoEO);
        return Result.success(projectinfoEO);
    }

    @ApiOperation(value = "|ProjectinfoEO|删除")
    @DeleteMapping("/{projectKey}")
    @RequiresPermissions("generate:projectinfo:delete")
    public ResponseMessage delete(@PathVariable String projectKey) throws Exception {
        projectinfoEOService.deleteByPrimaryKey(projectKey);
        logger.info("delete from PROJECTINFO where projectKey = {}", projectKey);
        return Result.success();
    }

    @ApiOperation(value = "|ProjectinfoEO|项目新增")
    @PostMapping("/addProject")
    @RequiresPermissions("generate:projectinfo:save")
    public ResponseMessage<ProjectinfoEO> addProject(@RequestBody ProjectinfoEO projectinfoEO) throws Exception {
        boolean result = projectinfoEOService.addProject(projectinfoEO);
        if(result){
            return Result.success(projectinfoEO);
        }else {
            return Result.error("新增失败");
        }

    }

    @ApiOperation(value = "|ProjectinfoEO|项目分页查询")
    @PostMapping("/queryByPage")
    @RequiresPermissions("generate:projectinfo:page")
    public ResponseMessage<PageInfo<ProjectinfoEO>> queryByPage(@RequestBody ProjectinfoEOPage page) throws Exception {
        List<ProjectinfoEO> rows = projectinfoEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    @ApiOperation(value = "|ProjectinfoEO|项目修改")
    @PostMapping("/updateProject")
    @RequiresPermissions("generate:projectinfo:update")
    public ResponseMessage<ProjectinfoEO> updateProject(@RequestBody ProjectinfoEO projectinfoEO) throws Exception {
        boolean result= projectinfoEOService.updateProject(projectinfoEO);
        if(result){
            return Result.success(projectinfoEO);
        }else {
            return Result.error("更新失败");
        }
    }

    @ApiOperation(value = "|ProjectinfoEO|项目删除")
    @PostMapping("/deleteProject")
    @RequiresPermissions("generate:projectinfo:delete")
    public ResponseMessage deleteProject(@RequestBody ProjectinfoEO projectinfoEO) throws Exception {
        projectinfoEOService.deleteByPrimaryKey(projectinfoEO.getProjectKey());
        return Result.success(PublicPrompt.DELETE_SUCCESS);
    }
}
