package com.guli.aliyunoss.controller;

import com.guli.aliyunoss.service.FileService;
import com.guli.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: zheng
 * @Date: 2019/7/19
 * @Description:
 */
@Api(description = "阿里云oss文件管理")
@CrossOrigin
@RestController
@RequestMapping("/admin/oss/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    public R upload(
            @RequestParam("file") MultipartFile file) {
        String url = fileService.upload(file);
        return R.ok().message("文件上传成功").data("url", url);
    }
}
