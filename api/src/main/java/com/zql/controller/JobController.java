package com.zql.controller;


import com.zql.bo.JobBo;
import com.zql.bo.QuestionLibBo;
import com.zql.grace.result.GraceJSONResult;
import com.zql.service.JobService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {

    @Resource
    private JobService jobService;

    @PostMapping("/createOrUpdate")
    public GraceJSONResult CreateOrUpdate(@RequestBody JobBo jobBo) {
        jobService.createOrUpdate(jobBo);
        return GraceJSONResult.ok();
    }
}
