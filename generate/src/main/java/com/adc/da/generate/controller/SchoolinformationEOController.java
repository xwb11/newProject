package com.adc.da.generate.controller;

import static com.adc.da.generate.util.SchoolinformationEOPrompt.SCHOOLNAME_REPEAT;
import static com.adc.da.myutil.util.PublicPrompt.UPDATE_SUCCESS;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import com.adc.da.generate.VO.SchoolinformationVO;
import com.adc.da.generate.entity.UserinformationEO;
import com.adc.da.generate.page.UserinformationEOPage;
import com.adc.da.generate.util.UserinformationEOPrompt;
import com.adc.da.myutil.util.PublicPrompt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.SchoolinformationEO;
import com.adc.da.generate.page.SchoolinformationEOPage;
import com.adc.da.generate.service.SchoolinformationEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/generate/schoolinformation")
@Api(description = "|SchoolinformationEO|")
public class SchoolinformationEOController extends BaseController<SchoolinformationEO>{

    private static final Logger logger = LoggerFactory.getLogger(SchoolinformationEOController.class);

    @Autowired
    private SchoolinformationEOService schoolinformationEOService;

	@ApiOperation(value = "|SchoolinformationEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("generate:schoolinformation:page")
    public ResponseMessage<PageInfo<SchoolinformationEO>> page(@RequestBody SchoolinformationEOPage page) throws Exception {
        List<SchoolinformationEO> rows = schoolinformationEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    /**
    * @Description:    查询学校信息（分页+模糊查询）
    * @Author:         xwb
    * @CreateDate:     2018/10/10 9:59
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/10/10 9:59
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "|SchoolinformationEO|查询用户信息（分页）")
    @PostMapping("/querySchoolInfoByPage")
    public ResponseMessage<PageInfo<SchoolinformationEO>> querySchoolInfoByPage( SchoolinformationEOPage page) throws Exception {
        List<SchoolinformationEO> rows = schoolinformationEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }


    @ApiOperation(value = "|SchoolinformationEO|详情")
    @GetMapping("/{schoolkey}")
    @RequiresPermissions("generate:schoolinformation:get")
    public ResponseMessage<SchoolinformationEO> find(@PathVariable String schoolkey) throws Exception {
        return Result.success(schoolinformationEOService.selectByPrimaryKey(schoolkey));
    }

    /**
    * @Description:    新增学校信息
    * @Author:         xwb
    * @CreateDate:     2018/10/9 22:30
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/10/9 22:30
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "|SchoolinformationEO|新增")
    @PostMapping("/addSchoolInfo")
    @RequiresPermissions("generate:schoolinformation:save")
    public ResponseMessage addSchoolInfo(@RequestBody SchoolinformationVO schoolinformationVO) throws Exception {
        //身份校验
        if(!"1".equals(schoolinformationVO.getUserLoginRole())){//若不是管理员
            return Result.error(UserinformationEOPrompt.USE_PERMIT);
        }
        //学习名称重复校验
        if(schoolinformationEOService.schoolNameTesting(schoolinformationVO).equals("1")){
            schoolinformationEOService.schoolInfoAdd(schoolinformationVO);
            return Result.success(PublicPrompt.INSERT_SUCCESS);
        }else {
            return Result.error(SCHOOLNAME_REPEAT);
        }
    }

    /**
    * @Description:    修改学校信息
    * @Author:         xwb
    * @CreateDate:     2018/10/9 22:30
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/10/9 22:30
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "|SchoolinformationEO|修改")
    @PostMapping("/updateSchoolInfo")
    @RequiresPermissions("generate:schoolinformation:update")
    public ResponseMessage updateSchoolInfo(@RequestBody SchoolinformationVO schoolinformationVO) throws Exception {
        //身份校验
        if(!"1".equals(schoolinformationVO.getUserLoginRole())){//若不是管理员
            return Result.error(UserinformationEOPrompt.USE_PERMIT);
        }
        if(schoolinformationEOService.schoolNameTestingWhenUpdate(schoolinformationVO).equals("1")){
            schoolinformationEOService.updateSchoolInfo(schoolinformationVO);
            return Result.success(UPDATE_SUCCESS);
        }else {
            return Result.error(SCHOOLNAME_REPEAT);
        }
    }

    /**
    * @Description:    删除学校信息
    * @Author:         xwb
    * @CreateDate:     2018/10/9 22:31
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/10/9 22:31
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "|SchoolinformationEO|删除")
    @PostMapping("/deleteSchoolInfo")
    @RequiresPermissions("generate:schoolinformation:delete")
    public ResponseMessage deleteSchoolInfo(@RequestBody SchoolinformationVO schoolinformationVO) throws Exception {
        //身份校验
        if(!"1".equals(schoolinformationVO.getUserLoginRole())){//若不是管理员
            return Result.error(UserinformationEOPrompt.USE_PERMIT);
        }
        schoolinformationEOService.deleteSchoolInfo(schoolinformationVO.getSchoolkey());
//        logger.info("delete from SCHOOLINFORMATION where schoolkey = {}", schoolkey);
        return Result.success(PublicPrompt.DELETE_SUCCESS);
    }

}
