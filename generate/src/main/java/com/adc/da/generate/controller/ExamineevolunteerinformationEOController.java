package com.adc.da.generate.controller;

import static com.adc.da.generate.util.ExamineeinformationEOPrompt.BATCHDELETE_SUCCESS;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.adc.da.generate.VO.ExamineevolunteerinformationVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.ExamineevolunteerinformationEO;
import com.adc.da.generate.page.ExamineevolunteerinformationEOPage;
import com.adc.da.generate.service.ExamineevolunteerinformationEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@RestController
@RequestMapping("/${restPath}/generate/examineevolunteerinformation")
@Api(description = "|ExamineevolunteerinformationEO|")
public class ExamineevolunteerinformationEOController extends BaseController<ExamineevolunteerinformationEO>{

    private static final Logger logger = LoggerFactory.getLogger(ExamineevolunteerinformationEOController.class);

    @Autowired
    private ExamineevolunteerinformationEOService examineevolunteerinformationEOService;

	@ApiOperation(value = "|ExamineevolunteerinformationEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("generate:examineevolunteerinformation:page")
    public ResponseMessage<PageInfo<ExamineevolunteerinformationEO>> page(ExamineevolunteerinformationEOPage page) throws Exception {
        List<ExamineevolunteerinformationEO> rows = examineevolunteerinformationEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }
/**
* @Description:   查询被学校录取的信息
* @Author:         xwb
* @CreateDate:     2018/10/9 22:24
* @UpdateUser:     xwb
* @UpdateDate:     2018/10/9 22:24
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
	@ApiOperation(value = "|ExamineevolunteerinformationEO|查询")
    @GetMapping("/selectAdminssionBySchool")
    @RequiresPermissions("generate:examineevolunteerinformation:list")
    public ResponseMessage selectAdminssionBySchool(@RequestParam String examinationnumber) throws Exception {
        return Result.success(examineevolunteerinformationEOService.selectAdminssionBySchool(examinationnumber));
	}

    @ApiOperation(value = "|ExamineevolunteerinformationEO|详情")
    @GetMapping("/{volunteerkey}")
    @RequiresPermissions("generate:examineevolunteerinformation:get")
    public ResponseMessage<ExamineevolunteerinformationEO> find(@PathVariable String volunteerkey) throws Exception {
        return Result.success(examineevolunteerinformationEOService.selectByPrimaryKey(volunteerkey));
    }

    @ApiOperation(value = "|ExamineevolunteerinformationEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:examineevolunteerinformation:save")
    public ResponseMessage<ExamineevolunteerinformationEO> create(@RequestBody ExamineevolunteerinformationEO examineevolunteerinformationEO) throws Exception {
        examineevolunteerinformationEOService.insertSelective(examineevolunteerinformationEO);
        return Result.success(examineevolunteerinformationEO);
    }

    @ApiOperation(value = "|ExamineevolunteerinformationEO|修改考生志愿")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:examineevolunteerinformation:update")
    public ResponseMessage<ExamineevolunteerinformationEO> update(@RequestBody ExamineevolunteerinformationEO examineevolunteerinformationEO) throws Exception {
        examineevolunteerinformationEOService.updateByPrimaryKeySelective(examineevolunteerinformationEO);
        return Result.success(examineevolunteerinformationEO);
    }

    @ApiOperation(value = "|ExamineevolunteerinformationEO|删除")
    @DeleteMapping("/{volunteerkey}")
    @RequiresPermissions("generate:examineevolunteerinformation:delete")
    public ResponseMessage delete(@PathVariable String volunteerkey) throws Exception {
        examineevolunteerinformationEOService.deleteByPrimaryKey(volunteerkey);
        logger.info("delete from EXAMINEEVOLUNTEERINFORMATION where volunteerkey = {}", volunteerkey);
        return Result.success();
    }
    @ApiOperation(value = "|ExamineevolunteerinformationEO|获取考生志愿")
    @GetMapping("/getExamineeVolunteerInformation")
    public ResponseMessage getExamineeVolunteerInformation(@RequestParam String examinationnumber){
        List<Map<String,Object>> examineeVolunteers= examineevolunteerinformationEOService.getExamineeVolunteerInformation(examinationnumber);
        return Result.success(examineeVolunteers);
    }

    @ApiOperation(value = "|ExamineevolunteerinformationEO|考生学校查重")
    @PostMapping("/checkExamineeSchool")
    public ResponseMessage checkExamineeSchool(@RequestParam String examinationNumber,@RequestParam String schoolKey){
        ExamineevolunteerinformationEO examineevolunteerinformationEO = examineevolunteerinformationEOService.checkExamineeSchool(examinationNumber, schoolKey);
        if (examineevolunteerinformationEO != null){
            return Result.error("","您已报考该学校。",examineevolunteerinformationEO);
        }else{
            return Result.success("","您还未报考当前学校，可以报考。",examineevolunteerinformationEO);
        }

    }

    /**
     * 报考志愿包括：准考证号（随着登录人可直接带出）、志愿编号、学校名称、专业名称、申报时间。
     * 其中申报时间由系统获得 不用填写
     * @param examinationnumber
     * @param volunteernumber
     * @param schoolkey
     * @param majorkey
     * @return
     */
    @ApiOperation(value = "|ExamineevolunteerinformationEO|考生申报志愿")
    @PostMapping("/ExamineeDeclareVolunteer")
    public ResponseMessage examineeDeclareVolunteer(@RequestParam String examinationnumber,
                                                    @RequestParam Integer volunteernumber,
                                                    @RequestParam String schoolkey,
                                                    @RequestParam String majorkey)
    {
        /**
         * 志愿数量验证可以由前端做 通过调用“获取考生志愿”接口 得到志愿list 判断list大小来判断志愿数量
         * 此处验证只是暂时的
         */
        List<Map<String,Object>> examineeVolunteers= examineevolunteerinformationEOService.getExamineeVolunteerInformation(examinationnumber);
        System.out.println(examineeVolunteers.size());
        if(examineeVolunteers.size()>=7){
            return Result.error("已申报7条志愿");
        }
        ExamineevolunteerinformationEO examineevolunteerinformationEO = new ExamineevolunteerinformationEO();
        examineevolunteerinformationEO.setExaminationnumber(examinationnumber);
        examineevolunteerinformationEO.setVolunteernumber(volunteernumber);
        examineevolunteerinformationEO.setSchoolkey(schoolkey);
        examineevolunteerinformationEO.setMajorkey(majorkey);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//String类型
        examineevolunteerinformationEO.setDeclaretime(new Date());
        examineevolunteerinformationEOService.examineeDeclareVolunteer(examineevolunteerinformationEO);
        return Result.success("申报成功");
    }

//    @ApiOperation(value = "|ExamineevolunteerinformationEO|考生修改志愿")
//    @PostMapping("/ExamineeUpdateVolunteer")
//    public ResponseMessage examineeUpdateVolunteer(@RequestBody ExamineevolunteerinformationEO examineevolunteerinformationEO){
//        examineevolunteerinformationEOService.examineeUpdateVolunteer(examineevolunteerinformationEO);
//	    return Result.success();
//    }

    @ApiOperation(value = "|ExamineevolunteerinformationEO|考生批量删除志愿")
    @PostMapping("/ExamineeBatchDeleteVolunteer")
    public ResponseMessage examineeBatchDeleteVolunteer(@RequestBody List<ExamineevolunteerinformationEO> volunteerKeys){
//        ExamineevolunteerinformationEO EO = new ExamineevolunteerinformationEO();
//        EO.setVolunteerkey("1");


//        List<ExamineevolunteerinformationEO> volunteerKeys = new ArrayList();

//        ExamineevolunteerinformationVO examineevolunteerinformationVO = new ExamineevolunteerinformationVO();
//        examineevolunteerinformationVO.setList(volunteerKeys);
        ExamineevolunteerinformationVO examineevolunteerinformationVO = new ExamineevolunteerinformationVO();
        if(volunteerKeys.size() != 0 ||volunteerKeys != null){
            examineevolunteerinformationVO.setList(volunteerKeys);
        }
        examineevolunteerinformationEOService.examineeBatchDeleteVolunteer(examineevolunteerinformationVO);
        return Result.success(BATCHDELETE_SUCCESS);
    }
}
