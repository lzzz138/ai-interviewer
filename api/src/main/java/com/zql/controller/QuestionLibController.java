package com.zql.controller;


import com.zql.bo.InterviewerBo;
import com.zql.bo.QuestionLibBo;
import com.zql.grace.result.GraceJSONResult;
import com.zql.pojo.QuestionLib;
import com.zql.service.QuestionLibService;
import com.zql.utils.PagedGridResult;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    public GraceJSONResult queryList(@RequestParam String question,
                                     @RequestParam String aiName,
                                     @RequestParam(defaultValue = "1", name = "page") Integer page,
                                     @RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize){
        PagedGridResult pagedGridResult = questionLibService.queryList(question, aiName, page, pageSize);
        return GraceJSONResult.ok(pagedGridResult);

    }

}
