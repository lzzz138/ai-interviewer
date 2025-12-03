package com.zql.controller;


import com.zql.bo.InterviewerBo;
import com.zql.grace.result.GraceJSONResult;
import com.zql.service.InterviewerService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interviewer")
public class InterviewerController {

    @Resource
    private InterviewerService interviewerService;

    /**
     * 创建或更新数字人面试官
     * @return
     */
    @PostMapping("/createOrUpdate")
    public GraceJSONResult CreateOrUpdate(@RequestBody InterviewerBo interviewerBo) {
        interviewerService.CreateOrUpdate(interviewerBo);
        return GraceJSONResult.ok();
    }
}
