package com.adc.da.generate.VO;

import com.adc.da.generate.entity.CompanyinfoEO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: XWB
 * @Date: 2018/11/11 19:45
 * @Description: 封装上传文件与企业信息
 */
public class CompanyinfoVO extends CompanyinfoEO {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
