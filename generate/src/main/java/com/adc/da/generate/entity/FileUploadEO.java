package com.adc.da.generate.entity;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>FILE_UPLOAD FileUploadEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-11-11 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class FileUploadEO extends BaseEntity {

    private String fileId;
    private String filePath;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>fileId -> file_id</li>
     * <li>filePath -> file_path</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "fileId": return "file_id";
            case "filePath": return "file_path";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>file_id -> fileId</li>
     * <li>file_path -> filePath</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "file_id": return "fileId";
            case "file_path": return "filePath";
            default: return null;
        }
    }
    
    /**  **/
    public String getFileId() {
        return this.fileId;
    }

    /**  **/
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    /**  **/
    public String getFilePath() {
        return this.filePath;
    }

    /**  **/
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
