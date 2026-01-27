package com.zql.controller;


import com.zql.bo.CandidateBo;
import com.zql.bo.JobBo;
import com.zql.grace.result.GraceJSONResult;
import com.zql.pojo.Candidate;
import com.zql.service.CandidateService;
import com.zql.utils.PagedGridResult;
import io.minio.messages.Grant;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Resource
    private CandidateService candidateService;

    @PostMapping("/createOrUpdate")
    public GraceJSONResult CreateOrUpdate(@RequestBody CandidateBo candidateBo){
        candidateService.createOrUpdate(candidateBo);
        return GraceJSONResult.ok();
    }

    @GetMapping("/list")
    public GraceJSONResult queryList(@RequestParam String realName,
                                     @RequestParam String mobile,
                                     @RequestParam(defaultValue = "1", name = "page") Integer page,
                                     @RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize){
        PagedGridResult result = candidateService.queryList(realName, mobile, page, pageSize);
        return GraceJSONResult.ok(result);
    }

    @GetMapping("/detail")
    public GraceJSONResult getDetail(String candidateId){
        Candidate candidate = candidateService.getDetail(candidateId);
        return GraceJSONResult.ok(candidate);
    }

    @PostMapping("/delete")
    public GraceJSONResult delete(String candidateId){
        candidateService.delete(candidateId);
        return GraceJSONResult.ok();
    }

}
