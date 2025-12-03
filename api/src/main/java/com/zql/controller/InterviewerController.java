package com.zql.controller;


import com.zql.bo.InterviewerBo;
import com.zql.grace.result.GraceJSONResult;
import com.zql.service.InterviewerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    public GraceJSONResult CreateOrUpdate(@Valid @RequestBody InterviewerBo interviewerBo) {
        interviewerService.CreateOrUpdate(interviewerBo);
        return GraceJSONResult.ok();
    }

    /**
     * 查询所有数字人面试官
     * @return
     */
    @GetMapping("/list")
    public GraceJSONResult queryAll() {
        return GraceJSONResult.ok(interviewerService.queryAll());
    }

}
