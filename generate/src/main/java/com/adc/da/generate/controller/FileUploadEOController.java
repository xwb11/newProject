package com.adc.da.generate.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.adc.da.generate.service.CompanyinfoEOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.FileUploadEO;
import com.adc.da.generate.page.FileUploadEOPage;
import com.adc.da.generate.service.FileUploadEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/${restPath}/generate/fileUpload")
@Api(description = "|FileUploadEO|")
public class FileUploadEOController extends BaseController<FileUploadEO>{

    private static final Logger logger = LoggerFactory.getLogger(FileUploadEOController.class);

    @Autowired
    private FileUploadEOService fileUploadEOService;

	@ApiOperation(value = "|FileUploadEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("generate:fileUpload:page")
    public ResponseMessage<PageInfo<FileUploadEO>> page(FileUploadEOPage page) throws Exception {
        List<FileUploadEO> rows = fileUploadEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|FileUploadEO|查询")
    @GetMapping("")
    @RequiresPermissions("generate:fileUpload:list")
    public ResponseMessage<List<FileUploadEO>> list(FileUploadEOPage page) throws Exception {
        return Result.success(fileUploadEOService.queryByList(page));
	}

    @ApiOperation(value = "|FileUploadEO|详情")
    @GetMapping("/{fileId}")
    @RequiresPermissions("generate:fileUpload:get")
    public ResponseMessage<FileUploadEO> find(@PathVariable String fileId) throws Exception {
        return Result.success(fileUploadEOService.selectByPrimaryKey(fileId));
    }

    @ApiOperation(value = "|FileUploadEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:fileUpload:save")
    public ResponseMessage<FileUploadEO> create(@RequestBody FileUploadEO fileUploadEO) throws Exception {
        fileUploadEOService.insertSelective(fileUploadEO);
        return Result.success(fileUploadEO);
    }

    @ApiOperation(value = "|FileUploadEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:fileUpload:update")
    public ResponseMessage<FileUploadEO> update(@RequestBody FileUploadEO fileUploadEO) throws Exception {
        fileUploadEOService.updateByPrimaryKeySelective(fileUploadEO);
        return Result.success(fileUploadEO);
    }

    @ApiOperation(value = "|FileUploadEO|删除")
    @DeleteMapping("/{fileId}")
    @RequiresPermissions("generate:fileUpload:delete")
    public ResponseMessage delete(@PathVariable String fileId) throws Exception {
        fileUploadEOService.deleteByPrimaryKey(fileId);
        logger.info("delete from FILE_UPLOAD where fileId = {}", fileId);
        return Result.success();
    }

//    // 传入的参数file是我们指定的文件
//    @ApiOperation(value = "|FileUploadEO|文件上传")
//    @PostMapping("/upload")
//    public String upload(@RequestParam("file") MultipartFile file) {
//	    FileUploadEO fileUploadEO = new FileUploadEO();
//	    fileUploadEO.setFileId(UUID.randomUUID().toString());
//        return CompanyinfoEOService.Upload(file);
//    }

}
