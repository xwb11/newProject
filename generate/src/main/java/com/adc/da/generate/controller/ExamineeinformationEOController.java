package com.adc.da.generate.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;

import com.adc.da.generate.VO.ExamineeinformationVO;
import com.adc.da.generate.entity.UserinformationEO;
import com.adc.da.generate.service.UserinformationEOService;
import com.adc.da.generate.util.ExamineeinformationPrompt;
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

    @ApiOperation(value = "|ExamineeinformationEO|详情")
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

    /**
     * 考生信息录入
     * 刘志杰 2018-10-08
     * @param examineeinformationVO 封装了所有 userinformationEO，examineeinformationEO的信息
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "|ExamineeinformationEO|考生信息录入")
    @PostMapping("/informationEntry")
    public ResponseMessage informationEntry(@RequestBody ExamineeinformationVO examineeinformationVO) throws Exception {
        //校验，如果成功 返回字符串"true",否则返回提示语
        UserinformationEO userinformationEO = examineeinformationVO.getUserinformationEO();
        ExamineeinformationEO examineeinformationEO = examineeinformationVO.getExamineeinformationEO();
        String result=examineeinformationEOService.informationCheck(examineeinformationEO,userinformationEO);
        if (result != "true") {
            return Result.error(result);
        }
        examineeinformationEO.setExamineekey(UUID.randomUUID());
        examineeinformationEOService.insertSelective(examineeinformationEO);
        userinformationEOService.updateByPrimaryKey(userinformationEO);
        return Result.success(ExamineeinformationPrompt.ENTRY_SUCCESS);
    }



}
