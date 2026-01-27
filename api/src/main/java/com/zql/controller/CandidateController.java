package com.zql.controller;


import com.zql.bo.CandidateBo;
import com.zql.bo.JobBo;
import com.zql.grace.result.GraceJSONResult;
import com.zql.service.CandidateService;
import io.minio.messages.Grant;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
