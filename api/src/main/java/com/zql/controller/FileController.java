package com.zql.controller;

import com.mysql.cj.util.StringUtils;
import com.zql.grace.result.GraceJSONResult;
import com.zql.grace.result.ResponseStatusEnum;
import com.zql.service.base.MinIOConfig;
import com.zql.service.base.MinIOUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private MinIOConfig minIOConfig;

    @PostMapping("/uploadInterviewerImage")
    public GraceJSONResult uploadInterviewerImage(@RequestParam("file") MultipartFile file) throws Exception{
        String filename = file.getOriginalFilename();
        if(StringUtils.isNullOrEmpty(filename)){
            return GraceJSONResult.errorCustom(ResponseStatusEnum.FILE_UPLOAD_NULL_ERROR);
        }
        filename = "interviewer/" + dealWithoutFilename(filename);
        String imageUrl = MinIOUtils.uploadFile(minIOConfig.getBucketName(), filename, file.getInputStream(),true);
        return GraceJSONResult.ok(imageUrl);
    }

    private String dealWithFilename(String filename){
        String suffixName = filename.substring(filename.lastIndexOf("."));
        String originName = filename.substring(0, filename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        return originName + "-" + uuid + suffixName;
    }

    private String dealWithoutFilename(String filename){
        String suffixName = filename.substring(filename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        return uuid + suffixName;
    }
}
