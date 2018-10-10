package com.adc.da.generate.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import com.adc.da.generate.util.UserinformationEOPrompt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.UserinformationEO;
import com.adc.da.generate.page.UserinformationEOPage;
import com.adc.da.generate.service.UserinformationEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/${restPath}/generate/userinformation")
@Api(description = "|UserinformationEO|")
public class UserinformationEOController extends BaseController<UserinformationEO>{

    private static final Logger logger = LoggerFactory.getLogger(UserinformationEOController.class);

    @Autowired
    private UserinformationEOService userinformationEOService;

	@ApiOperation(value = "|UserinformationEO|分页查询")
    @GetMapping("/page")
    public ResponseMessage<PageInfo<UserinformationEO>> page(UserinformationEOPage page) throws Exception {
        List<UserinformationEO> rows = userinformationEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|UserinformationEO|查询")
    @GetMapping("")
    public ResponseMessage<List<UserinformationEO>> list(UserinformationEOPage page) throws Exception {
        return Result.success(userinformationEOService.queryByList(page));
	}

    @ApiOperation(value = "|UserinformationEO|详情")
    @GetMapping("/{userkey}")
    public ResponseMessage<UserinformationEO> find(@PathVariable String userkey) throws Exception {
        return Result.success(userinformationEOService.selectByPrimaryKey(userkey));
    }

    @ApiOperation(value = "|UserinformationEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseMessage<UserinformationEO> create(@RequestBody UserinformationEO userinformationEO) throws Exception {
        userinformationEOService.insertSelective(userinformationEO);
        return Result.success(userinformationEO);
    }

    @ApiOperation(value = "|UserinformationEO|修改")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseMessage<UserinformationEO> update(@RequestBody UserinformationEO userinformationEO) throws Exception {
        userinformationEOService.updateByPrimaryKeySelective(userinformationEO);
        return Result.success(userinformationEO);
    }

    @ApiOperation(value = "|UserinformationEO|删除")
    @PostMapping("/{userkey}")
    public ResponseMessage delete(@PathVariable String userkey) throws Exception {
        userinformationEOService.deleteByPrimaryKey(userkey);
        logger.info("delete from USERINFORMATION where userkey = {}", userkey);
        return Result.success();
    }

    /**
     * 用户信息删除
     * 刘志杰 2018-10-08
     * @param userinformationEO 用户信息
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|UserinformationEO|用户信息删除")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE,value = "/deleteUserInfo")
    public ResponseMessage deleteUserInfo(@RequestBody UserinformationEO userinformationEO) throws Exception {
        if("1".equals(userinformationEO.getUserrole())){ //用户 如果不是 管理员身份
            return Result.error(UserinformationEOPrompt.USE_PERMIT);
        }
        if(userinformationEO.getUserkey()==null){
            return Result.error(UserinformationEOPrompt.DELETE_ERRO);
        }
        userinformationEOService.deleteUserInfo(userinformationEO);
        return Result.success();
    }

    /**
     * 用户信息新增
     * 刘志杰 2018-10-08
     * @param userinformationEO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|UserinformationEO|用户信息新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE,value="/createUserInfo")
    public ResponseMessage<UserinformationEO> createUserInfo(@RequestBody UserinformationEO userinformationEO) throws Exception {
        //身份验证
        if("1".equals(userinformationEO.getUserrole())){ //用户 如果不是 管理员身份
            return Result.error(UserinformationEOPrompt.USE_PERMIT);
        }
        //用户名验重
        if(userinformationEOService.AccountRepeat(userinformationEO.getUseraccount())){
            return Result.error(UserinformationEOPrompt.USE_PERMIT);
        }
        userinformationEOService.insertSelective(userinformationEO);
        return Result.success(userinformationEO);
    }

    /**
     * 用户信息修改
     * 刘志杰 2018-10-08
     * @param userinformationEO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|UserinformationEO|用户信息修改")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE,value="/updateUserInfo")
    public ResponseMessage<UserinformationEO> updateUserInfo(@RequestBody UserinformationEO userinformationEO) throws Exception {
        //身份验证
        if("1".equals(userinformationEO.getUserrole())){ //用户 如果不是 管理员身份
            return Result.error(UserinformationEOPrompt.USE_PERMIT);
        }
        //用户名验重
        if(userinformationEOService.AccountRepeat(userinformationEO.getUseraccount())){
            return Result.error(UserinformationEOPrompt.USE_PERMIT);
        }
        userinformationEOService.updateByPrimaryKeySelective(userinformationEO);
        return Result.success(userinformationEO);
    }

    /**
     * 查询用户信息（不分页）
     * 刘志杰 2018-10-08
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|UserinformationEO|查询用户信息（不分页）")
    @PostMapping("/queryUserInfo")
    public ResponseMessage<List<UserinformationEO>> queryUserInfo() throws Exception {
        return Result.success(userinformationEOService.queryUserInfo());
    }

    /**
     * 查询用户信息（分页）
     * 刘志杰 2018-10-08
     * @param page
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|UserinformationEO|查询用户信息（分页）")
    @PostMapping("/queryUserInfoByPage")
    public ResponseMessage<PageInfo<UserinformationEO>> queryUserInfoByPage(UserinformationEOPage page) throws Exception {
        List<UserinformationEO> rows = userinformationEOService.queryUserInfoByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }
}
