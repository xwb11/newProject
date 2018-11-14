package com.adc.da.generate.service;

import com.adc.da.generate.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adc.da.base.service.BaseService;
import com.adc.da.generate.dao.FileUploadEODao;
import com.adc.da.generate.entity.FileUploadEO;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 *
 * <br>
 * <b>功能：</b>FILE_UPLOAD FileUploadEOService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
@Service("fileUploadEOService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class FileUploadEOService extends BaseService<FileUploadEO, String> {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadEOService.class);

    @Autowired
    private FileUploadEODao dao;

    public FileUploadEODao getDao() {
        return dao;
    }

}
