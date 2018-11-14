package com.adc.da.generate.service;

import com.adc.da.generate.VO.CompanyinfoVO;
import com.adc.da.generate.entity.FileUploadEO;
import com.adc.da.generate.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.CompanyinfoEODao;
import com.adc.da.generate.entity.CompanyinfoEO;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 *
 * <br>
 * <b>功能：</b>COMPANYINFO CompanyinfoEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-08 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("companyinfoEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class CompanyinfoEOService extends BaseService<CompanyinfoEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(CompanyinfoEOService.class);

    @Autowired
    private CompanyinfoEODao dao;

    public CompanyinfoEODao getDao() {
        return dao;
    }

    /**
    * @Description:    录入需求信息
    * @Author:         xwb
    * @CreateDate:     2018/11/9 13:18
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/11/9 13:18
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public boolean insertCompanyInfo(CompanyinfoEO companyinfoVO,MultipartFile file){
        int nameNum = dao.selectCompanyName(companyinfoVO.getCompanyName());
        int phoneNum = dao.selectPhone(companyinfoVO.getPhone());
        int companyNumberNum = dao.selectCompanyNumber(companyinfoVO.getCompanyNumber());

        if(nameNum==0 && phoneNum==0 && companyNumberNum==0){
            companyinfoVO.setCompanyKey(UUID.randomUUID().toString());
            companyinfoVO.setCreatetime(new Date());
//            Upload(MultipartFile);
            if(!file.isEmpty()) {
                // 获取文件名称,包含后缀
                String fileName = file.getOriginalFilename();

                // 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
                // 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
                String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"File/";
                String newPath = path.substring(1,path.length());
                try {
                    // 该方法是对文件写入的封装，在util类中，导入该包即可使用
                    FileUtil.fileupload(file.getBytes(), path, fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
                companyinfoVO.setFilePath(newPath+fileName);
                dao.insertSelective(companyinfoVO);
            }
            return true;
//            dao.insertSelective(companyinfoEO);
//            return true;
        }else {
            return false;
        }
    }

    /**
    * @Description:    修改企业信息
    * @Author:         xwb
    * @CreateDate:     2018/11/9 13:21
    * @UpdateUser:     xwb
    * @UpdateDate:     2018/11/9 13:21
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public boolean updateCompanyInfo(CompanyinfoEO companyinfoEO){
        int nameNum = dao.selectCompanyName(companyinfoEO.getCompanyName());
        int phoneNum = dao.selectPhone(companyinfoEO.getPhone());
        int companyNumberNum = dao.selectCompanyNumber(companyinfoEO.getCompanyNumber());

        if(nameNum>=1 || phoneNum>=1 || companyNumberNum>=1){
            return false;
        }else {
           dao.updateByPrimaryKeySelective(companyinfoEO);
           return true;
        }
    }


}
