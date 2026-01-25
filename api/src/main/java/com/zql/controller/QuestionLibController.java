package com.zql.controller;


import com.zql.bo.InterviewerBo;
import com.zql.bo.QuestionLibBo;
import com.zql.grace.result.GraceJSONResult;
import com.zql.pojo.QuestionLib;
import com.zql.service.QuestionLibService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questionLib")
public class QuestionLibController {

    @Resource
    private QuestionLibService questionLibService;

    @PostMapping("/createOrUpdate")
    public GraceJSONResult CreateOrUpdate(@RequestBody QuestionLibBo questionLibBo) {
        questionLibService.createOrUpdate(questionLibBo);
        return GraceJSONResult.ok();
    }

}
