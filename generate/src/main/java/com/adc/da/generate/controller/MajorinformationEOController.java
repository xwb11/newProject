package com.adc.da.generate.controller;

import static com.adc.da.generate.util.MajorinformationEOPrompt.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import com.adc.da.generate.entity.SchoolinformationEO;
import com.adc.da.generate.page.SchoolinformationEOPage;
import com.adc.da.generate.util.UserinformationEOPrompt;
import com.adc.da.myutil.util.PublicPrompt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.MajorinformationEO;
import com.adc.da.generate.page.MajorinformationEOPage;
import com.adc.da.generate.service.MajorinformationEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/generate/majorinformation")
@Api(description = "|MajorinformationEO|")
public class MajorinformationEOController extends BaseController<MajorinformationEO>{

    private static final Logger logger = LoggerFactory.getLogger(MajorinformationEOController.class);

    @Autowired
    private MajorinformationEOService majorinformationEOService;

	@ApiOperation(value = "|MajorinformationEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("generate:majorinformation:page")
    public ResponseMessage<PageInfo<MajorinformationEO>> page(MajorinformationEOPage page) throws Exception {
        List<MajorinformationEO> rows = majorinformationEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    /**
    * @Description:    查询专业信息(分页)
    * @Author:         xwb
    * @CreateDate:     2018/10/10 10:16
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/10/10 10:16
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "|UserinformationEO|查询用户信息（分页加模糊查询）")
    @GetMapping("/queryMajorInfoByPage")
    public ResponseMessage<PageInfo<MajorinformationEO>> queryMajorInfoByPage(MajorinformationEOPage page) throws Exception {
        List<MajorinformationEO> rows = majorinformationEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }


    /**
    * @Description:    查询专业信息
    * @Author:         xwb
    * @CreateDate:     2018/10/9 22:26
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/10/9 22:26
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
	@ApiOperation(value = "|MajorinformationEO|查询")
    @PostMapping("/selectMajorInfo")
    @RequiresPermissions("generate:majorinformation:list")
    public ResponseMessage selectMajorInfo(@RequestBody MajorinformationEO majorinformationEO) throws Exception {

        return Result.success(SELECTMAJORNAME_SUCCESS,majorinformationEOService.selectMajorInfo(majorinformationEO));
    }

    @ApiOperation(value = "|MajorinformationEO|详情")
    @GetMapping("/{majorkey}")
    @RequiresPermissions("generate:majorinformation:get")
    public ResponseMessage<MajorinformationEO> find(@RequestParam String majorkey) throws Exception {
        return Result.success(majorinformationEOService.selectByPrimaryKey(majorkey));
    }
    /**
    * @Description:    新增专业信息
    * @Author:         xwb
    * @CreateDate:     2018/10/9 22:25
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/10/9 22:25
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "|MajorinformationEO|新增")
    @PostMapping("/majorInfoAdd")
    @RequiresPermissions("majorInfoAdd")
    public ResponseMessage majorInfoAdd(@RequestBody MajorinformationEO majorinformationEO,@RequestParam String userRole) throws Exception {
//        majorinformationEOService.insertSelective(majorinformationEO);
        //身份校验
        if(!"1".equals(userRole)){//若不是管理员
            return Result.error(UserinformationEOPrompt.USE_PERMIT);
        }
        if(majorinformationEOService.majorNameTesting(majorinformationEO).equals("1")){
            majorinformationEOService.majorInfoAdd(majorinformationEO);
           return Result.success(PublicPrompt.INSERT_SUCCESS) ;
        }else {
           return Result.error(MAJORNAME_REPEAT);
        }
    }

    /**
    * @Description:    修改专业信息
    * @Author:         xwb
    * @CreateDate:     2018/10/9 22:26
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/10/9 22:26
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "|MajorinformationEO|修改")
    @PutMapping("/updateMajorInfo")
    @RequiresPermissions("generate:majorinformation:update")
    public ResponseMessage updateMajorInfo(@RequestBody MajorinformationEO majorinformationEO,@RequestParam String userRole) throws Exception {
        //身份校验
        if(!"1".equals(userRole)){//若不是管理员
            return Result.error(UserinformationEOPrompt.USE_PERMIT);
        }
        if(majorinformationEOService.majorNameTestingWhenUpdate(majorinformationEO).equals("1")){
            majorinformationEOService.updateMajorInfo(majorinformationEO);
            return Result.success(PublicPrompt.UPDATE_SUCCESS) ;
        }else {
            return Result.error(MAJORNAME_REPEAT);
        }
    }
    /**
    * @Description:    删除专业信息
    * @Author:         xwb
    * @CreateDate:     2018/10/9 22:26
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/10/9 22:26
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "|MajorinformationEO|删除")
    @DeleteMapping("/deleteMajorInfo")
    @RequiresPermissions("generate:majorinformation:delete")
    public ResponseMessage delete(@RequestParam String majorkey,@RequestParam String userRole) throws Exception {
        //身份校验
        if(!"1".equals(userRole)){//若不是管理员
            return Result.error(UserinformationEOPrompt.USE_PERMIT);
        }
        logger.info("delete from MAJORINFORMATION where majorkey = {}", majorkey);
        return Result.success(PublicPrompt.DELETE_SUCCESS,majorinformationEOService.dleteMajorInfo(majorkey));
    }

}
