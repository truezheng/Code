package com.guli.aliyunoss.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * 文件上传
     * @param file 上传的文件
     * @return 文件的url地址
     */
    String upload(MultipartFile file);

}
