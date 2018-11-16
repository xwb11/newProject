package com.adc.da.generate.controller;

import static com.adc.da.generate.util.CompanyinfoEOPrompt.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.adc.da.generate.VO.CompanyinfoVO;
import com.adc.da.generate.entity.FileUploadEO;
import com.adc.da.myutil.util.PublicPrompt;
import com.adc.da.util.utils.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import com.adc.da.base.web.BaseController;
import com.adc.da.generate.entity.CompanyinfoEO;
import com.adc.da.generate.page.CompanyinfoEOPage;
import com.adc.da.generate.service.CompanyinfoEOService;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.adc.da.util.http.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/${restPath}/generate/companyinfo")
@Api(description = "|CompanyinfoEO|")
public class CompanyinfoEOController extends BaseController<CompanyinfoEO>{

    private static final Logger logger = LoggerFactory.getLogger(CompanyinfoEOController.class);

    private static String filePath = "";

    @Autowired
    private CompanyinfoEOService companyinfoEOService;

	@ApiOperation(value = "|CompanyinfoEO|分页查询")
    @GetMapping("/page")
    @RequiresPermissions("generate:companyinfo:page")
    public ResponseMessage<PageInfo<CompanyinfoEO>> page(CompanyinfoEOPage page) throws Exception {
        List<CompanyinfoEO> rows = companyinfoEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

	@ApiOperation(value = "|CompanyinfoEO|查询")
    @GetMapping("")
    @RequiresPermissions("generate:companyinfo:list")
    public ResponseMessage<List<CompanyinfoEO>> list(CompanyinfoEOPage page) throws Exception {
        return Result.success(companyinfoEOService.queryByList(page));
	}

    @ApiOperation(value = "|CompanyinfoEO|详情")
    @GetMapping("/{companyKey}")
    @RequiresPermissions("generate:companyinfo:get")
    public ResponseMessage<CompanyinfoEO> find(@PathVariable String companyKey) throws Exception {
        return Result.success(companyinfoEOService.selectByPrimaryKey(companyKey));
    }

    @ApiOperation(value = "|CompanyinfoEO|新增")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:companyinfo:save")
    public ResponseMessage<CompanyinfoEO> create(@RequestBody CompanyinfoEO companyinfoEO) throws Exception {
        companyinfoEOService.insertSelective(companyinfoEO);
        return Result.success(companyinfoEO);
    }

    @ApiOperation(value = "|CompanyinfoEO|修改")
    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("generate:companyinfo:update")
    public ResponseMessage<CompanyinfoEO> update(@RequestBody CompanyinfoEO companyinfoEO) throws Exception {
        companyinfoEOService.updateByPrimaryKeySelective(companyinfoEO);
        return Result.success(companyinfoEO);
    }

    @ApiOperation(value = "|CompanyinfoEO|删除")
    @DeleteMapping("/{companyKey}")
    @RequiresPermissions("generate:companyinfo:delete")
    public ResponseMessage delete(@PathVariable String companyKey) throws Exception {
        companyinfoEOService.deleteByPrimaryKey(companyKey);
        logger.info("delete from COMPANYINFO where companyKey = {}", companyKey);
        return Result.success();
    }

    @ApiOperation(value = "|CompanyinfoEO|企业信息录入")
    @PostMapping("/addCompanyInfo")
    @RequiresPermissions("generate:companyinfo:save")
    public ResponseMessage<CompanyinfoEO> addCompanyInfo( @RequestBody CompanyinfoEO companyinfoVO) throws Exception {
        String path = "";
	    for(int i=1 ; i<filePath.length() ; i++){
            if (filePath.charAt(i) == '/'){
                path+="\\\\";
                continue;
            }else{
                path+=filePath.charAt(i);
            }
        }

        companyinfoVO.setFilePath(path);

        boolean result= companyinfoEOService.insertCompanyInfo(companyinfoVO);
       if(result){
           return Result.success(ENTRY_SUCCESS,companyinfoVO);
       }else {
            return Result.error(ENTRY_ERROR);
       }
    }


    @PostMapping("/addCompanyInfo_fileup")
    public ResponseMessage<CompanyinfoEO> fileup(@RequestParam( value = "file",required = false)MultipartFile file) throws Exception {

        if(file != null && !file.isEmpty()) {
            //获取项目根目录
            String realPath = ResourceUtils.getURL("classpath:").getPath();
            filePath = realPath + "fileload/" + file.getOriginalFilename();
            File file1 = new File(filePath);
            if(!file1.getParentFile().exists()) file1.getParentFile().mkdir();
            InputStream is = file.getInputStream();
            FileOutputStream fos = new FileOutputStream(file1);
            int b;
            byte[] bytes = new byte[1024];
            while ((b = is.read(bytes)) != -1) {
                fos.write(bytes, 0, b);
            }

            is.close();
            fos.close();
            return Result.success();
        }
        return Result.error(ENTRY_ERROR);
    }

    @ApiOperation(value = "|CompanyinfoEO|企业分页查询")
    @PostMapping("/queryByPage")
    @RequiresPermissions("generate:companyinfo:page")
    public ResponseMessage<PageInfo<CompanyinfoEO>> queryByPage(@RequestBody CompanyinfoEOPage page) throws Exception {
        List<CompanyinfoEO> rows = companyinfoEOService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    @ApiOperation(value = "|CompanyinfoEO|企业信息修改")
    @PostMapping("/updateCompanyInfo")
    @RequiresPermissions("generate:companyinfo:update")
    public ResponseMessage<CompanyinfoEO> updateCompanyInfo(@RequestBody CompanyinfoEO companyinfoEO) throws Exception {
        boolean result = companyinfoEOService.updateCompanyInfo(companyinfoEO);
        if(result){
            return Result.success(UPDATE_SUCCESS,companyinfoEO);
        }else {
            return Result.error(UPDATE_ERROR);
        }
    }

    @ApiOperation(value = "|CompanyinfoEO|企业信息删除")
    @PostMapping("/deleteCompanyInfo")
    @RequiresPermissions("generate:companyinfo:delete")
    public ResponseMessage deleteCompanyInfo(@RequestBody CompanyinfoEO companyinfoEO) throws Exception {
        companyinfoEOService.deleteByPrimaryKey(companyinfoEO.getCompanyKey());
        return Result.success(DELETE_SUCCESS);
    }

    @ApiOperation(value = "|CompanyinfoEO|企业信息下载")
    @GetMapping("/CompanyInfoFileDown")
    public ResponseMessage flieDown(String filePath, HttpServletResponse response) throws Exception {

        File file = new File(filePath);
        if(!file.exists()) return Result.error();
        response.setCharacterEncoding("iso-8859-1");
        response.setContentType("application/force-download");// 设置强制下载不打开
        response.setHeader("content-disposition", "attachment;filename="
                + new String(file.getName().getBytes(),"iso-8859-1"));
        System.out.println(file.getName());
        FileInputStream fis = new FileInputStream(file);
        ServletOutputStream os = response.getOutputStream();
        int b;
        byte[] bytes = new byte[1024];
        while((b = fis.read(bytes)) > 0){
            os.write(bytes,0,b);
        }
        fis.close();
        os.flush();
        return Result.success();
    }


//    // 传入的参数file是我们指定的文件
//    @ApiOperation(value = "|FileUploadEO|文件上传")
//    @PostMapping("/upload")
//    public String upload(@RequestParam("file") MultipartFile file) {
//
//        return companyinfoEOService.Upload(file);
//    }
}
