package com.adc.da.myutil.controller;

import com.adc.da.myutil.service.ExeclCheck;
import com.adc.da.myutil.service.ImageUploadService;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/${restPath}/ImageUploadController")
@Api(description = "|ImageUploadController|图片上传")
public class ImageUploadController {

    @Autowired
    private ImageUploadService service;
    @Autowired
    private ExeclCheck execlCheckService;
    /*
    * 图片上传
    * 2018-4-1
    * 李云强
    * 参数：file---要上传的文件
    *       type---要保存到的文件夹
    * 返回值;url---文件的上传地址
    *        size---文件大小（）
    * */
    @ApiOperation(value = "|ImageUpload|图片上传 ")
    @PostMapping("ImageUpload")
    public ResponseMessage<Map<String,String>> ImageUpload(@RequestParam("file") MultipartFile file, @RequestParam("type") String type){
        Long size=null;
        if(!file.isEmpty()){
            System.out.println("文件大小："+file.getSize());
            size=file.getSize()/1024;
        }else {
            return Result.error("上传文件不能为空");
        }
        if ("".equals(type)||type==null){
            type="other";
        }
        String url = service.uploadeLocalImage(file, type);
        System.out.println("tupian-----url------"+url);
        Map<String,String> map = new HashMap<>();
        map.put("url",url);
        map.put("size",size.toString());
        return Result.success(map);
    }

    /**
     * 用于测试ExeclCheck方法的可用性
     * @author fangyuxuan
     * @param quasiExaminationNumber
     * @return
     * @throws IOException
     * @throws BiffException
     */
    @ApiOperation(value = "|ExeclCheck|Execl文件校验 ")
    @PostMapping("/ExeclCheck")
    public ResponseMessage execlCheck(@RequestParam("quasiExaminationNumber") String quasiExaminationNumber) throws IOException, BiffException {
      int flag = execlCheckService.execlCheck(quasiExaminationNumber);
      if(flag == 1){
          return Result.success("200","可用");
      }else{
          return Result.error("不可用");
      }
    }
}
