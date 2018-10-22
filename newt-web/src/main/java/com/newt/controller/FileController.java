package com.newt.controller;

import com.newt.pojo.Result;
import com.newt.pojo.ResultGenerator;
import com.newt.utils.aliyun.OOSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 文件上传
 * @Author zcc
 * @Date 18/10/22
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private OOSUtil oosUtil;


    /**
     * @Description: 文件上传
     * @param:  * @param file
     * @return: com.newt.pojo.Result
     */
    @RequestMapping(value = "/upload")
    public Result uploadFile(MultipartFile file) {

        String upload = oosUtil.upload(file);
        return ResultGenerator.getSuccessResult(upload);
    }
}
