package com.adc.da.generate.page;

import com.adc.da.base.page.BasePage;


/**
 * <b>功能：</b>FILE_UPLOAD FileUploadEOPage<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class FileUploadEOPage extends BasePage {

    private String fileId;
    private String fileIdOperator = "=";
    private String filePath;
    private String filePathOperator = "=";

    public String getFileId() {
        return this.fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileIdOperator() {
        return this.fileIdOperator;
    }

    public void setFileIdOperator(String fileIdOperator) {
        this.fileIdOperator = fileIdOperator;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePathOperator() {
        return this.filePathOperator;
    }

    public void setFilePathOperator(String filePathOperator) {
        this.filePathOperator = filePathOperator;
    }

}
