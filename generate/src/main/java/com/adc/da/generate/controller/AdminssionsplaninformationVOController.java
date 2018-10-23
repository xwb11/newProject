package com.adc.da.generate.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.VO.AdminssionsplaninformationVO;
import com.adc.da.generate.entity.AdminssionsplaninformationEO;
import com.adc.da.generate.page.AdminssionsplaninformationEOPage;
import com.adc.da.generate.page.AdminssionsplaninformationVOPage;
import com.adc.da.generate.service.AdminssionsplaninformationEOService;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${restPath}/generate/adminssionsplaninformation")
@Api(description = "|AdminssionsplaninformationVO|")
public class AdminssionsplaninformationVOController extends BaseController<AdminssionsplaninformationVO> {

    private static final Logger logger = LoggerFactory.getLogger(AdminssionsplaninformationVOController.class);

    @Autowired
    private AdminssionsplaninformationEOService adminssionsplaninformationEOService;

    /**
     * @Description:    查询招生信息（分页)
     * @Author:         xwb
     * @CreateDate:     2018/10/10 10:44
     * @UpdateUser:     xwb
     * @UpdateDate:     2018/10/10 10:44
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @ApiOperation(value = "|AdminssionsplaninformationVO|查询招生信息（分页加模糊查询）")
    @PostMapping("/queryAdminssionInfoByPage")
    public ResponseMessage<PageInfo<AdminssionsplaninformationVO>> queryAdminssionInfoByPage(@RequestBody AdminssionsplaninformationVOPage page) throws Exception {
        List<AdminssionsplaninformationVO> rows = adminssionsplaninformationEOService.queryAdminssionInfoByPage(page);
        return Result.success(getPageInfo(page.getPager(),rows));
    }

    /**
     * @Description:    查询去年招考信息（分页)
     * @Author:         xwb
     * @CreateDate:     2018/10/10 10:44
     * @UpdateUser:     xwb
     * @UpdateDate:     2018/10/10 10:44
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @ApiOperation(value = "|AdminssionsplaninformationVO|查询去年招考信息（分页）")
    @PostMapping("/queryLastAdminssionInfoByPage")
    public ResponseMessage<PageInfo<AdminssionsplaninformationVO>> queryLastAdminssionInfoByPage(@RequestBody AdminssionsplaninformationVOPage page) throws Exception {
        List<AdminssionsplaninformationVO> rows = adminssionsplaninformationEOService.selectLastYearAdmission(page);
        return Result.success(getPageInfo(page.getPager(),rows));
    }

    //加载所有项-岳奔
    @ApiOperation(value = "|AdminssionsplaninformationVO|分页查询")
    @PostMapping("AdminssionsplaninformationVOPageAll")
    @RequiresPermissions("generate:adminssionsplaninformation:page")
    public ResponseMessage<PageInfo<AdminssionsplaninformationVO>> page(@RequestBody AdminssionsplaninformationVOPage page) throws Exception {
        //ResponseMessage<PageInfo<AdminssionsplaninformationVO>>
        System.out.println("---分页查询Admin_All____:" + page.getPage() + "," + page.getPageSize());
        List<AdminssionsplaninformationVO> rows = adminssionsplaninformationEOService.selectAll(page);
        //return new Gson().toJson(rows);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    //学校，省份，专业模糊查询-岳奔
    @PostMapping("/AdminssionsplaninformationVOPageBySMP")
    @RequiresPermissions("generate:adminssionsplaninformation:page")
    public ResponseMessage<PageInfo<AdminssionsplaninformationVO>> selectBySMP(@RequestBody  AdminssionsplaninformationEOPage page) throws Exception{
        List<AdminssionsplaninformationVO> rows = adminssionsplaninformationEOService.selectBySMP(page);
        System.out.println("------------controllerAdminSelectBySMP-----------被访问了！！！" + page.getSchoolkey() + page.getAdminssionskey() + page.getMajorkey());
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    //删除一条招生计划-岳奔
    @PostMapping("/deleteAdminssionsplaninformationVO/{adminssionskey}")
    @RequiresPermissions("generate:adminssionsplaninformation:delete")
    public ResponseMessage deleteByKey(@PathVariable String adminssionskey) throws Exception{
        System.out.println("adminControllerDeleteById==="+adminssionskey);
        adminssionsplaninformationEOService.deleteByKey(adminssionskey);
        return Result.success();
    }

    //新增一条数据-岳奔
    @PostMapping("/createAdminssionsplaninformationVO")
    @RequiresPermissions("generate:adminssionsplaninformation:save")
    public ResponseMessage insertOne(@RequestBody AdminssionsplaninformationEO adminssionsplaninformationEO) throws Exception{
        String str = adminssionsplaninformationEOService.insertOne(adminssionsplaninformationEO);
        return getReturn(str);
    }

    //修改一条数据-岳奔
    @PostMapping("/updateAdminssionsplaninformationVO")
    @RequiresPermissions("generate:adminssionsplaninformation:update")
    public ResponseMessage updateByKey(@RequestBody AdminssionsplaninformationEO adminssionsplaninformationEO) throws  Exception{
        System.out.println("++++++++++UpdateController__:" + adminssionsplaninformationEO.getMajorkey() + ","
                + adminssionsplaninformationEO.getSchoolkey() + ","
                + adminssionsplaninformationEO.getCreateyear());
        String str = adminssionsplaninformationEOService.updataByKey(adminssionsplaninformationEO);
        System.out.println("-----------" + str);
        return getReturn(str);

    }

    //发布招生计划-岳奔
    @PostMapping("/releaseAdminssionsplaninformationVO")
    @RequiresPermissions("generate:adminssionsplaninformation:update")
    public ResponseMessage release(AdminssionsplaninformationEO adminssionsplaninformationEO) throws  Exception{
        System.out.println("++++++++++releaseController__:" + adminssionsplaninformationEO);
        String str = adminssionsplaninformationEOService.release(adminssionsplaninformationEO);
        return getReturn(str);
    }
    //获取返回参数-岳奔
    public ResponseMessage getReturn(String str){
        if (str == "-1"){
            return Result.error("repeat");
        }else if(str == "fail"){
            return Result.error("fail");
        }else {
            return Result.success();
        }
    }

}
