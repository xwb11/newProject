package com.adc.da.generate.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.UserLoginEO;
import com.adc.da.generate.page.UserLoginEOPage;
import com.adc.da.generate.service.UserLoginEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/generate/userLogin")
@Api(description = "|UserLoginEO|")
public class UserLoginEOController extends BaseController<UserLoginEO>{

    private static final Logger logger = LoggerFactory.getLogger(UserLoginEOController.class);

    @Autowired
    private UserLoginEOService userLoginEOService;

	@ApiOperation(value = "|UserLoginEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("generate:userLogin:page")
    public ResponseMessage<PageInfo<UserLoginEO>> page(UserLoginEOPage page) throws Exception {
        List<UserLoginEO> rows = userLoginEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|UserLoginEO|查询")
    @GetMapping("")
    @RequiresPermissions("generate:userLogin:list")
    public ResponseMessage<List<UserLoginEO>> list(UserLoginEOPage page) throws Exception {
        return Result.success(userLoginEOService.queryByList(page));
	}

    @ApiOperation(value = "|UserLoginEO|详情")
    @GetMapping("/{pkLogin}")
    @RequiresPermissions("generate:userLogin:get")
    public ResponseMessage<UserLoginEO> find(@PathVariable Integer pkLogin) throws Exception {
        return Result.success(userLoginEOService.selectByPrimaryKey(pkLogin));
    }

    @ApiOperation(value = "|UserLoginEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:userLogin:save")
    public ResponseMessage<UserLoginEO> create(@RequestBody UserLoginEO userLoginEO) throws Exception {
        userLoginEOService.insertSelective(userLoginEO);
        return Result.success(userLoginEO);
    }

    @ApiOperation(value = "|UserLoginEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:userLogin:update")
    public ResponseMessage<UserLoginEO> update(@RequestBody UserLoginEO userLoginEO) throws Exception {
        userLoginEOService.updateByPrimaryKeySelective(userLoginEO);
        return Result.success(userLoginEO);
    }

    @ApiOperation(value = "|UserLoginEO|删除")
    @DeleteMapping("/{pkLogin}")
    @RequiresPermissions("generate:userLogin:delete")
    public ResponseMessage delete(@PathVariable Integer pkLogin) throws Exception {
        userLoginEOService.deleteByPrimaryKey(pkLogin);
        logger.info("delete from TS_USER_LOGIN where pkLogin = {}", pkLogin);
        return Result.success();
    }

}
