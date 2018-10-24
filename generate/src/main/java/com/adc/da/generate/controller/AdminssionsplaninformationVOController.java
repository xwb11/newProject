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

//    /**
//     * @Description:    查询招生信息（分页)
//     * @Author:         xwb
//     * @CreateDate:     2018/10/10 10:44
//     * @UpdateUser:     xwb
//     * @UpdateDate:     2018/10/10 10:44
//     * @UpdateRemark:   修改内容
//     * @Version:        1.0
//     */
//    @ApiOperation(value = "|AdminssionsplaninformationVO|查询招生信息（分页加模糊查询）")
//    @PostMapping("/queryAdminssionInfoByPage")
//    public ResponseMessage<PageInfo<AdminssionsplaninformationVO>> queryAdminssionInfoByPage(@RequestBody AdminssionsplaninformationVOPage page) throws Exception {
//        List<AdminssionsplaninformationVO> rows = adminssionsplaninformationEOService.queryAdminssionInfoByPage(page);
//        return Result.success(getPageInfo(page.getPager(),rows));
//    }

//    /**
//     * @Description:    查询去年招考信息（分页)
//     * @Author:         xwb
//     * @CreateDate:     2018/10/10 10:44
//     * @UpdateUser:     xwb
//     * @UpdateDate:     2018/10/10 10:44
//     * @UpdateRemark:   修改内容
//     * @Version:        1.0
//     */
//    @ApiOperation(value = "|AdminssionsplaninformationVO|查询去年招考信息（分页）")
//    @PostMapping("/queryLastAdminssionInfoByPage")
//    public ResponseMessage<PageInfo<AdminssionsplaninformationVO>> queryLastAdminssionInfoByPage(@RequestBody AdminssionsplaninformationVOPage page) throws Exception {
//        List<AdminssionsplaninformationVO> rows = adminssionsplaninformationEOService.selectLastYearAdmission(page);
//        return Result.success(getPageInfo(page.getPager(),rows));
//    }

    /**
    * @Description:   _加载招生计划信息（后台-分页）
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:40
    * @UpdateUser:     yueben
    * @UpdateDate:     2018/10/24 9:40
    * @UpdateRemark:   修改内容
    */
    @ApiOperation(value = "|AdminssionsplaninformationVO|分页查询")
    @PostMapping("AdminssionsplaninformationVOPageAll")
    @RequiresPermissions("generate:adminssionsplaninformation:page")
    public ResponseMessage<PageInfo<AdminssionsplaninformationVO>> page(@RequestBody AdminssionsplaninformationVOPage page) throws Exception {
        List<AdminssionsplaninformationVO> rows = adminssionsplaninformationEOService.selectAll(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    /**
    * @Description:   _通过学校，省份，专业进行模糊查询（后台-分页）
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:41
    * @UpdateUser:     yueben
    * @UpdateDate:     2018/10/24 9:41
    * @UpdateRemark:   修改内容
    */
    @PostMapping("/AdminssionsplaninformationVOPageBySMP")
    @RequiresPermissions("generate:adminssionsplaninformation:page")
    public ResponseMessage<PageInfo<AdminssionsplaninformationVO>> selectBySMP(@RequestBody  AdminssionsplaninformationEOPage page) throws Exception{
        List<AdminssionsplaninformationVO> rows = adminssionsplaninformationEOService.selectBySMP(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }


    /**
    * @Description:   _删除一条招生计划
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:44
    * @UpdateUser:     yueben
    * @UpdateDate:     2018/10/24 9:44
    * @UpdateRemark:   修改内容
    */
    @PostMapping("/deleteAdminssionsplaninformationVO/{adminssionskey}")
    @RequiresPermissions("generate:adminssionsplaninformation:delete")
    public ResponseMessage deleteByKey(@PathVariable String adminssionskey) throws Exception{
        adminssionsplaninformationEOService.deleteByKey(adminssionskey);
        return Result.success();
    }

    /**
    * @Description:   _新增一条数据
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:45
    * @UpdateUser:     yueben
    * @UpdateDate:     2018/10/24 9:45
    * @UpdateRemark:   修改内容
    */
    @PostMapping("/createAdminssionsplaninformationVO")
    @RequiresPermissions("generate:adminssionsplaninformation:save")
    public ResponseMessage insertOne(@RequestBody AdminssionsplaninformationEO adminssionsplaninformationEO) throws Exception{
        String str = adminssionsplaninformationEOService.insertOne(adminssionsplaninformationEO);
        return getReturn(str);
    }

    /**
    * @Description:   _修改一条数据
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:45
    * @UpdateUser:     yueben
    * @UpdateDate:     2018/10/24 9:45
    * @UpdateRemark:   修改内容
    */
    @PostMapping("/updateAdminssionsplaninformationVO")
    @RequiresPermissions("generate:adminssionsplaninformation:update")
    public ResponseMessage updateByKey(@RequestBody AdminssionsplaninformationEO adminssionsplaninformationEO) throws  Exception{
        String str = adminssionsplaninformationEOService.updataByKey(adminssionsplaninformationEO);
        return getReturn(str);

    }


    /**
    * @Description:   _发布招生计划
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:46
    * @UpdateUser:     yueben
    * @UpdateDate:     2018/10/24 9:46
    * @UpdateRemark:   修改内容
    */
    @PostMapping("/releaseAdminssionsplaninformationVO")
    @RequiresPermissions("generate:adminssionsplaninformation:update")
    public ResponseMessage release(AdminssionsplaninformationEO adminssionsplaninformationEO) throws  Exception{
        String str = adminssionsplaninformationEOService.release(adminssionsplaninformationEO);
        return getReturn(str);
    }

    /**
    * @Description:   _根据service层，新增、修改是否成功来确定返回值
    * @Author:         yueben
    * @CreateDate:     2018/10/24 9:46
    * @UpdateUser:     yueben
    * @UpdateDate:     2018/10/24 9:46
    * @UpdateRemark:   修改内容
    */
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
