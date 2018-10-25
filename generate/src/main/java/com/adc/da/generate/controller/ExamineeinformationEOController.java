package com.adc.da.generate.controller;

import static com.adc.da.generate.util.ExamineeinformationEOPrompt.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.adc.da.generate.VO.ExamineeinformationVO;
import com.adc.da.generate.entity.UserinformationEO;
import com.adc.da.generate.page.ExamineeinformationVOPage;
import com.adc.da.generate.service.UserinformationEOService;
import com.adc.da.generate.util.ExamineeinformationEOPrompt;
import com.adc.da.myutil.service.ExeclCheck;
import com.adc.da.myutil.util.IsEmpty;
import com.adc.da.util.utils.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.ExamineeinformationEO;
import com.adc.da.generate.page.ExamineeinformationEOPage;
import com.adc.da.generate.service.ExamineeinformationEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/${restPath}/generate/examineeinformation")
@Api(description = "|ExamineeinformationEO|")
public class ExamineeinformationEOController extends BaseController<ExamineeinformationEO> {

    private static final Logger logger = LoggerFactory.getLogger(ExamineeinformationEOController.class);

    @Autowired
    private ExamineeinformationEOService examineeinformationEOService;

    @Autowired
    private UserinformationEOService userinformationEOService;

    @ApiOperation(value = "|ExamineeinformationEO|分页查询")
    @GetMapping("/page")
    public ResponseMessage<PageInfo<ExamineeinformationEO>> page(ExamineeinformationEOPage page) throws Exception {
        List<ExamineeinformationEO> rows = examineeinformationEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    @ApiOperation(value = "|ExamineeinformationEO|查询")
    @GetMapping("")
    public ResponseMessage<List<ExamineeinformationEO>> list(ExamineeinformationEOPage page) throws Exception {
        return Result.success(examineeinformationEOService.queryByList(page));
    }
    /**
    * @Description:    考生录入信息分页查询
    * @Author:         xwb
    * @CreateDate:     2018/10/15 9:03
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/10/15 9:03
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "|ExamineeinformationEO|考生录入信息分页查询")
    @PostMapping("/queryByPage")
    public ResponseMessage<PageInfo<ExamineeinformationVO>> queryByPage(@RequestBody ExamineeinformationVOPage page) throws Exception {
        PageInfo<ExamineeinformationVO> rows = examineeinformationEOService.selectExamineeinformationByPage(page);
        return Result.success(rows);
    }

    /**
    * @Description:    获取考生录入信息
    * @Author:         xwb
    * @CreateDate:     2018/10/25 17:37
    * @Version:        1.0
    */
    @ApiOperation(value = "|ExamineeinformationEO|获取考生录入信息")
    @PostMapping("/selectExamineeinfomation")
    public ResponseMessage<List<ExamineeinformationVO>> selectExamineeinfomation(@RequestParam String examineekey) throws Exception {
        return Result.success(examineeinformationEOService.selectExamineeinfomation(examineekey));
    }


    /**
     * 获取考生基本信息详情
     * 刘笑天 20181011
     * 框架生成方法
     * @param examineekey
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|ExamineeinformationEO|获取考生基本信息详情")
    @GetMapping("/{examineekey}")
    public ResponseMessage<ExamineeinformationEO> find(@PathVariable String examineekey) throws Exception {
        return Result.success(examineeinformationEOService.selectByPrimaryKey(examineekey));
    }

    @ApiOperation(value = "|ExamineeinformationEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseMessage<ExamineeinformationEO> create(@RequestBody ExamineeinformationEO examineeinformationEO) throws Exception {
        examineeinformationEOService.insertSelective(examineeinformationEO);
        return Result.success(examineeinformationEO);
    }

    @ApiOperation(value = "|ExamineeinformationEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseMessage<ExamineeinformationEO> update(@RequestBody ExamineeinformationEO examineeinformationEO) throws Exception {
        examineeinformationEOService.updateByPrimaryKeySelective(examineeinformationEO);
        return Result.success(examineeinformationEO);
    }

    @ApiOperation(value = "|ExamineeinformationEO|删除")
    @DeleteMapping("/{examineekey}")
    public ResponseMessage delete(@PathVariable String examineekey) throws Exception {
        examineeinformationEOService.deleteByPrimaryKey(examineekey);
        logger.info("delete from EXAMINEEINFORMATION where examineekey = {}", examineekey);
        return Result.success();
    }

     //2018/10/12 13:39:43
    /**
    * @Description:    考生信息录入
    * @Author:         lzj
    * @CreateDate:     2018/10/10
    * @UpdateUser:     xwb修改
    * @UpdateDate:     2018/10/12 13:40
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "|ExamineeinformationEO|考生信息录入")
    @PostMapping("/informationEntry")
    public ResponseMessage informationEntry(@RequestBody ExamineeinformationVO examineeinformationVO) throws Exception {
        IsEmpty isEmpty = new IsEmpty();
        boolean flag = isEmpty.IsValueEmpty(examineeinformationVO);
        System.out.println(flag);
        //校验，如果成功 返回字符串"true",否则返回提示语
        UserinformationEO userinformationEO = examineeinformationVO.getUserinformationEO();
        ExamineeinformationEO examineeinformationEO = examineeinformationVO.getExamineeinformationEO();
        String result=examineeinformationEOService.informationCheck(examineeinformationEO,userinformationEO);
        if (result != "true") {
            return Result.error(result);
        }
//        userinformationEO.setUserkey(UUID.randomUUID());
//        examineeinformationEO.setExamineekey(UUID.randomUUID());
//        examineeinformationEO.setQuasiexaminationnumber(UUID.randomUserId());
//        examineeinformationEO.setUserkey(userinformationEO.getUserkey());
        userinformationEOService.updateByPrimaryKeySelective(userinformationEO);
        examineeinformationEOService.updateByPrimaryKeySelective(examineeinformationEO);
        return Result.success(ENTRY_SUCCESS);
    }

    /**
     * 考生注册
     * 刘笑天 20181011
     * 最后修改 刘笑天 20181022
     * @param examineeinformationVO
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|ExamineeinformationEO|注册")
    @PostMapping("/examineeRegist")
    public ResponseMessage userRegist(@RequestBody ExamineeinformationVO examineeinformationVO) throws Exception{
        UserinformationEO userinformationEO = examineeinformationVO.getUserinformationEO();
        //获取当前时间作为账号注册时间
        userinformationEO.setCreatetime(new Date());
        //先注册账号密码
        examineeinformationEOService.addUserInformation(userinformationEO);

        ExamineeinformationEO examineeinformationEO = examineeinformationVO.getExamineeinformationEO();
        //将准考证号邮箱手机号和用户账号密码关联
        examineeinformationEOService.addExamineeInformation(examineeinformationEO);
        return Result.success("",REGIST_SUCCESS,"");
    }

    @ApiOperation(value = "|ExamineeinformationEO|注册_检测准考证号")
    @PostMapping("/checkExaminationNumber")
    public ResponseMessage checkExaminationNumber(@RequestParam String quasiExaminationNumber) throws Exception{
        ExeclCheck execlCheck = new ExeclCheck();
        if(execlCheck.execlCheck(quasiExaminationNumber)==1){//若excel中存在 检测数据库中是否存在
            ExamineeinformationEO examineeinformationEO = examineeinformationEOService.checkQuasiExaminationNumber(quasiExaminationNumber);
            if(examineeinformationEO != null){
                return Result.error(QUASIEXAMINATIONNUMBER_EXIST);//数据库中存在
            }else{
                return Result.success("",QUASIEXAMINATIONNUMBER_NOTEXIST,"");//数据库中不存在
            }
        }else {//若excel中不存在 直接不可以注册
            return Result.error(QUASIEXAMINATIONNUMBER_NOTRIGHT);
        }
    }
}
