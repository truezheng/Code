package com.guli.aliyunoss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.guli.aliyunoss.service.FileService;
import com.guli.aliyunoss.util.ConstantPropertiesUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @Auther: zheng
 * @Date: 2019/7/19
 * @Description:
 */
@Service
public class FileServiceImpl implements FileService {
    /**
     *
     * @param file 上传的文件
     * @return 文件的url
     */
    @Override
    public String upload(MultipartFile file) {

        String endPoint = ConstantPropertiesUtil.END_POINT;
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKEY_NAME;
        String fileHost = ConstantPropertiesUtil.FILE_HOST;


        InputStream inputStream = null;
        String uploadUrl=null;
        try {
            inputStream = file.getInputStream();

            //判断oss实例是否存在：如果不存在则创建，如果存在则获取
            OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
            if (!ossClient.doesBucketExist(bucketName)) {
                //创建bucket
                ossClient.createBucket(bucketName);
                //设置oss实例的访问权限：公共读
                ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            }
            //保存路径
            String filePath=new DateTime().toString("yyyy/MM/dd");
            //文件原始名字
            String originalFilename=file.getOriginalFilename();
            //文件扩展名
            String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
            //新生文件名
            String fileName=UUID.randomUUID().toString()+fileType;
            //文件的相对路径
            String fileUrl=fileHost+"/"+filePath+"/"+fileName;

            //使用文件流上传文件到阿里云的oss
            ossClient.putObject(bucketName,fileUrl, inputStream);

            //关闭ossClient
            ossClient.shutdown();

            //文件的url
            uploadUrl ="https://"+bucketName+"."+endPoint+"/"+fileUrl;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadUrl;
    }
}
