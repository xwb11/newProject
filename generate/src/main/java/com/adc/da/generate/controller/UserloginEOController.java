package com.adc.da.generate.controller;

import static com.adc.da.generate.util.UserloginEOPrompt.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import com.adc.da.myutil.util.PublicPrompt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.UserloginEO;
import com.adc.da.generate.page.UserloginEOPage;
import com.adc.da.generate.service.UserloginEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/generate/userlogin")
@Api(description = "|UserloginEO|")
public class UserloginEOController extends BaseController<UserloginEO>{

    private static final Logger logger = LoggerFactory.getLogger(UserloginEOController.class);

    @Autowired
    private UserloginEOService userloginEOService;

	@ApiOperation(value = "|UserloginEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("generate:userlogin:page")
    public ResponseMessage<PageInfo<UserloginEO>> page(UserloginEOPage page) throws Exception {
        List<UserloginEO> rows = userloginEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|UserloginEO|查询")
    @GetMapping("")
    @RequiresPermissions("generate:userlogin:list")
    public ResponseMessage<List<UserloginEO>> list(UserloginEOPage page) throws Exception {
        return Result.success(userloginEOService.queryByList(page));
	}

    @ApiOperation(value = "|UserloginEO|详情")
    @GetMapping("/{userKey}")
    @RequiresPermissions("generate:userlogin:get")
    public ResponseMessage<UserloginEO> find(@PathVariable String userKey) throws Exception {
        return Result.success(userloginEOService.selectByPrimaryKey(userKey));
    }

    @ApiOperation(value = "|UserloginEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:userlogin:save")
    public ResponseMessage<UserloginEO> create(@RequestBody UserloginEO userloginEO) throws Exception {
        userloginEOService.insertSelective(userloginEO);
        return Result.success(userloginEO);
    }

    @ApiOperation(value = "|UserloginEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:userlogin:update")
    public ResponseMessage<UserloginEO> update(@RequestBody UserloginEO userloginEO) throws Exception {
        userloginEOService.updateByPrimaryKeySelective(userloginEO);
        return Result.success(userloginEO);
    }

    @ApiOperation(value = "|UserloginEO|删除")
    @DeleteMapping("/{userKey}")
    @RequiresPermissions("generate:userlogin:delete")
    public ResponseMessage delete(@PathVariable String userKey) throws Exception {
        userloginEOService.deleteByPrimaryKey(userKey);
        logger.info("delete from USERLOGIN where userKey = {}", userKey);
        return Result.success();
    }

    @ApiOperation(value = "|UserloginEO|登录")
    @PostMapping("/userLogin")
    public ResponseMessage userLogin(@RequestBody UserloginEO userloginEO) throws Exception {

	   String result = userloginEOService.checkAccount(userloginEO);
//	   String userRole=userloginEOService.selectUserRole(userloginEO);
	   switch (result) {
	       case "登录成功" :
               return Result.success(userloginEOService.queryByList(userloginEO));
           case "登录失败,账号或密码错误":
               return  Result.error(LOGIN_ERROR);
           case "账户不存在":
                return Result.error(ACCOUNT_NULL);
           case "账户和密码不能为空":
                return Result.error(ACCOUNTANDPASSWORD_NOTNULL);
       }
        return Result.success(LOGIN_SUCCESS);
    }

    @ApiOperation(value = "|UserloginEO|修改密码")
    @PostMapping("/updatePassword")
    public ResponseMessage updatePassword(@RequestBody UserloginEO userloginEO) throws Exception {
	    boolean result = userloginEOService.checkPassword(userloginEO);
            if(result){
               return Result.success(UPDATE_SUCCESS);
            }else {
               return Result.error(PASSWORD_ERROR);
            }
        }
    }
