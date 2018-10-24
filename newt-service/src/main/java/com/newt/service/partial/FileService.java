package com.newt.service.partial;

import com.newt.pojo.alibaba.OssAliyunField;
import com.newt.utils.aliyun.OOSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 文件操作
 * @Author zcc
 * @Date 18/10/23
 */
@Service
public class FileService {

    @Autowired
    private OOSUtil oosUtil;

    @Autowired
    @Qualifier("defaultOssAliyunField")
    private OssAliyunField ossAliyunField;


    /**
     * @Description: 文件上传
     * @param: * @param file
     * @return: java.lang.String
     */
    public String upload(MultipartFile file) {
        String fileUrl = oosUtil.upload(file);

        return fileUrl;
    }

    /**
     * @param fileUrl
     * @Description: 删除原链接, 更新OOS图片链接
     * @param: * @param file
     * @return: java.lang.String
     */
    public String updateOOS(MultipartFile file, String fileUrl) {

        String PREFIX = ossAliyunField.getPrefix() + "";
        String[] split = fileUrl.split("/");

        oosUtil.delete(ossAliyunField, split[split.length - 1]);

        String nowFileUrl = upload(file);

        return nowFileUrl;
    }
}
