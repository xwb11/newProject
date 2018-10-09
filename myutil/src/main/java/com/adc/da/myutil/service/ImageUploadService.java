package com.adc.da.myutil.service;

import com.adc.da.file.controller.FileUploadRestController;
import com.adc.da.util.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ImageUploadService {

    @Value("${IMAGE_SERVER_IP}")
    private String IMAGE_SERVER_IP;

    @Value("${ACCESS_IMAGE_PORT}")
    private String ACCESS_IMAGE_PORT;

    @Value("${IMAGE_SERVER_PORT}")
    private Integer IMAGE_SERVER_PORT;

    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;

    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;

    @Value("${IMAGE_SERVER_DIRECTORY}")
    private String IMAGE_SERVER_DIRECTORY;

    @Value("${ACCESS_IMAGE_DIRECTORY}")
    private String ACCESS_IMAGE_DIRECTORY;

    @Value("${ACCESS_IMAGE_IP}")
    private String ACCESS_IMAGE_IP;

    @Value("${is_Linux}")
    private String is_Linux;

    @Value("${ftp_transport}")
    private String ftp_transport;
    /*
    * 图片上传到ftp服务器
    * 参数：file--要上传的文件
    *       type--要保存到的文件夹
    * */
    public String uploadeLocalImage(MultipartFile file, String type) {
        String imageAccessUrl = null;
        String localAccessUrl = null;
        try {

            String filePath = "/"+IMAGE_SERVER_DIRECTORY+"/" + type + "/" + new SimpleDateFormat("yyyy").format(new Date()) + "/"
                    + new SimpleDateFormat("MM").format(new Date()) + "/"
                    + new SimpleDateFormat("dd").format(new Date());

            //String newFileName = IDUtils.genImageName()+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String oldFileName;
            String FileNameTemp = file.getOriginalFilename();
            if (FileNameTemp!=null){
                if (FileNameTemp.contains("/")){
                    oldFileName = FileNameTemp.substring(FileNameTemp.lastIndexOf("/")+1,FileNameTemp.lastIndexOf("."));
                }else {
                    oldFileName = FileNameTemp.substring(0,FileNameTemp.lastIndexOf("."));
                }
            }else {
                oldFileName = "null";
            }
            String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1,file.getOriginalFilename().length());
            String path = FileUploadRestController.class.getResource("/").getFile();
            List<String> whiteUrls = FileUtil.readAsStringList(path + "white/uploadWhite.txt");
            if (!whiteUrls.contains(extension)) {
                return "上传文件类型不允许，请重试";
            }
            String newFileName=oldFileName+"_"+IDUtils.genImageName()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            newFileName = newFileName.substring(newFileName.lastIndexOf(File.separator)+1,newFileName.length());
            //type+="/"+extension;
            // 访问路径
            imageAccessUrl = type + "/" + new SimpleDateFormat("yyyy").format(new Date()) + "/"
                    + new SimpleDateFormat("MM").format(new Date()) + "/"
                    + new SimpleDateFormat("dd").format(new Date());
            localAccessUrl = "http://" + ACCESS_IMAGE_IP + ":" + ACCESS_IMAGE_PORT +"/"+ACCESS_IMAGE_DIRECTORY+"/"+ IMAGE_SERVER_DIRECTORY+"/" + imageAccessUrl + "/"
                    + newFileName;
            System.out.println("nginx----lujing----"+localAccessUrl);
            // 存入FTP路径
            boolean ftpboolean = FtpUtil.uploadFile(IMAGE_SERVER_IP, IMAGE_SERVER_PORT, FTP_USERNAME, FTP_PASSWORD, "/", filePath,
                    newFileName, file.getInputStream(),is_Linux,ftp_transport);
            System.out.println("shangchuan-----ftp----"+ftpboolean);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("图片上传失败:"+e.getMessage());
            return "图片上传失败";
        }
        return localAccessUrl;

    }

    /**
     * 文件上传，供service中的代码调用
     *
     * @param bs
     * @param type
     * @return
     */
    public String uploadLocalImage(byte[] bs, String fileName, String type) {
        String imageAccessUrl;
        String localAccessUrl;
        try {
            String filePath = "/"+IMAGE_SERVER_DIRECTORY+"/" + type + "/" + new SimpleDateFormat("yyyy").format(new Date()) + "/"
                    + new SimpleDateFormat("MM").format(new Date()) + "/"
                    + new SimpleDateFormat("dd").format(new Date());
            // String newFileName = IDUtils.genImageName() +
            // file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            // 访问路径
            imageAccessUrl = type + "\\" + new SimpleDateFormat("yyyy").format(new Date()) + "\\"
                    + new SimpleDateFormat("MM").format(new Date()) + "\\"
                    + new SimpleDateFormat("dd").format(new Date());
            localAccessUrl = "http:\\\\" + ACCESS_IMAGE_IP + ":" + ACCESS_IMAGE_PORT + "\\"+ACCESS_IMAGE_DIRECTORY+"\\"+ IMAGE_SERVER_DIRECTORY+ "\\" + imageAccessUrl + "\\"
                    + fileName;
            // 存入FTP路径
            FtpUtil.uploadFile(IMAGE_SERVER_IP, IMAGE_SERVER_PORT, FTP_USERNAME, FTP_PASSWORD, "/", filePath, fileName,
                    new ByteArrayInputStream(bs),is_Linux,ftp_transport);
        } catch (Exception e) {
            e.printStackTrace();
            return "图片上传失败";
        }
        return localAccessUrl;
    }
}
