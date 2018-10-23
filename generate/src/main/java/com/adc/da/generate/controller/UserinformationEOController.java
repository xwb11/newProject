package com.adc.da.generate.controller;

import static com.adc.da.generate.util.UserinformationEOPrompt.*;
import static com.adc.da.generate.util.UserinformationEOPrompt.LOGIN_FAILED;
import static com.adc.da.generate.util.UserinformationEOPrompt.USERROLE_NOTEXIST;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import com.adc.da.generate.VO.UserinformationVO;
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

    /**
     * 修改密码（生成）
     * 刘笑天 20181022
     * @param userinformationEO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|UserinformationEO|修改(密码)")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseMessage<UserinformationEO> update(@RequestBody UserinformationEO userinformationEO) throws Exception {
        userinformationEOService.updateByPrimaryKeySelective(userinformationEO);
        return Result.success(userinformationEO);
    }

    @ApiOperation(value = "|UserinformationEO|删除")
    @DeleteMapping(consumes = APPLICATION_JSON_UTF8_VALUE,value = "/{userkey}")
    public ResponseMessage delete(@PathVariable String userkey) throws Exception {
        userinformationEOService.deleteByPrimaryKey(userkey);
        logger.info("delete from USERINFORMATION where userkey = {}", userkey);
        return Result.success();
    }

    /**
     * 用户信息删除
     * 刘志杰 2018-10-08
     * @param userinformationVO 封装用户信息与权限
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|UserinformationEO|用户信息删除")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE,value = "/deleteUserInfo")
    public ResponseMessage deleteUserInfo(@RequestBody UserinformationVO userinformationVO) throws Exception {
        if(!"1".equals(userinformationVO.getUserLoginRole())){ //用户如果不是 管理员身份
            return Result.error(UserinformationEOPrompt.USE_PERMIT);
        }
        if(userinformationVO.getUserkey()==null){
            return Result.error(UserinformationEOPrompt.DELETE_ERRO);
        }
        userinformationEOService.deleteUserInfo(userinformationVO);
        return Result.success();
    }

    /**
     * 用户信息新增
     * 刘志杰 2018-10-08
     * @param userinformationVO 封装用户信息与权限
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|UserinformationEO|用户信息新增")
    @PostMapping("/createUserInfo")
    public ResponseMessage<UserinformationVO> createUserInfo(@RequestBody UserinformationVO userinformationVO) throws Exception {
        //身份验证
        if(!"1".equals(userinformationVO.getUserLoginRole())){ //用户 如果不是 管理员身份
            return Result.error(UserinformationEOPrompt.USE_PERMIT);
        }
        //用户名验重
        if(userinformationEOService.AccountRepeat(userinformationVO)){
            return Result.error(UserinformationEOPrompt.ACOUNT_REPEAT);
        }
        userinformationEOService.insertUserInfo(userinformationVO);
        return Result.success(userinformationVO);
    }

    /**
     * 用户信息修改
     * 刘志杰 2018-10-08
     * @param userinformationVO 封装用户信息与权限
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|UserinformationEO|用户信息修改")
    @PostMapping(value="/updateUserInfo")
    public ResponseMessage<UserinformationVO> updateUserInfo(@RequestBody UserinformationVO userinformationVO) throws Exception {
        //身份验证
        if(!"1".equals(userinformationVO.getUserLoginRole())){ //用户 如果不是 管理员身份
            return Result.error(UserinformationEOPrompt.USE_PERMIT);
        }
        //用户名验重
        if(userinformationEOService.AccountRepeat(userinformationVO)){
            return Result.error(UserinformationEOPrompt.ACOUNT_REPEAT);
        }
        userinformationEOService.updateByPrimaryKeySelective(userinformationVO);
        return Result.success(userinformationVO);
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
     * 查询用户信息（分页+模糊查询）
     * 刘志杰 2018-10-08
     * @param page
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|UserinformationEO|查询用户信息（分页）")
    @PostMapping("/queryUserInfoByPage")
    public ResponseMessage<PageInfo<UserinformationEO>> queryUserInfoByPage(@RequestBody UserinformationEOPage page) throws Exception {
        List<UserinformationEO> rows = userinformationEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }
    /**
     * 用户登录
     * 刘笑天 20181010
     * @param userAccount
     * @param userPassword
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|UserinformationEO|登录")
    @PostMapping("/userLogin")
    public ResponseMessage userLogin(@RequestParam String userAccount,@RequestParam String userPassword) throws Exception{
        UserinformationEO userinformationEO = userinformationEOService.userLogin(userAccount,userPassword);
        if (userinformationEO != null){
            String userRole = userinformationEO.getUserrole();
//            if ("0".equals(userRole)){//考生
//                return Result.success(EXAMINEE_LOGIN_SUCCESS,userinformationEO);
//            }else if("1".equals(userRole)){//管理员
//                return Result.success(ADMIN_LOGIN_SUCCESS,userinformationEO);
//            }else if("2".equals(userRole)){//招生者
//                return Result.success(ADMISSIONS_LOGIN_SUCCESS,userinformationEO);
//            }else if ("3".equals(userRole)){//逻辑删除
//                return Result.success(USER_IS_FAKEDELETED,userinformationEO);
//            }else{
//                return Result.success("角色类型不存在");
//            }
            switch(userRole){
                case "0": //考生
                    return Result.success("00",EXAMINEE_LOGIN_SUCCESS,userinformationEO);
                case "1": //管理员
                    return Result.success("01",ADMIN_LOGIN_SUCCESS,userinformationEO);
                case "2": //招生者
                    return Result.success("02",ADMISSIONS_LOGIN_SUCCESS,userinformationEO);
                case "3": //逻辑删除
                    return Result.success("03",USER_IS_FAKEDELETED,userinformationEO);
                default: //角色类型不存在
                    return Result.error(USERROLE_NOTEXIST);
            }
        }else{
            return Result.error(LOGIN_FAILED);
        }
    }

    /**
     * 旧密码校验
     * 刘笑天 20181022
     * @param userinformationEO
     * @return
     */
    @ApiOperation(value = "|UserinformationEO|旧密码校验")
    @PostMapping("checkOldPassword")
    ResponseMessage checkOldPassword(@RequestBody UserinformationEO userinformationEO){
        String oldPassword = userinformationEO.getUserpassword();
        if (!"".equals(oldPassword)){//如果旧密码不为空
            UserinformationEO userinformationEO1 = userinformationEOService.checkOldPassword(userinformationEO);
            if (userinformationEO1 != null){
                return Result.success("",CHECKPASSWORD_SUCCESS,"");
            }else{
                return Result.error(CHECKPASSWORD_FAILED);
            }
        }else{
            return Result.error(PASSWORD_BLANK);
        }
    }
}
