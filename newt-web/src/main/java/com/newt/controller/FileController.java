package com.newt.controller;

import com.newt.pojo.Result;
import com.newt.pojo.ResultGenerator;
import com.newt.service.partial.FileService;
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
    private FileService fileService;


    /**
     * @Description: 上传文件并删除原有链接
     * @param: * @param file
     * @return: com.newt.pojo.Result
     */
    @RequestMapping(value = "/upload/update")
    public Result uploadFile(MultipartFile file, String fileUrl) {

        String nowFileUrl = fileService.updateOOS(file, fileUrl);

        return ResultGenerator.getSuccessResult(nowFileUrl);
    }


}
