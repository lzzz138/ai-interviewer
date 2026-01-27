package com.zql.controller;


import com.zql.bo.JobBo;
import com.zql.bo.QuestionLibBo;
import com.zql.grace.result.GraceJSONResult;
import com.zql.pojo.Job;
import com.zql.service.JobService;
import com.zql.utils.PagedGridResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    public GraceJSONResult queryList( @RequestParam(defaultValue = "1", name = "page") Integer page,
                                      @RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize){
        PagedGridResult result = jobService.queryList(page, pageSize);
        return GraceJSONResult.ok(result);
    }

    //此处可以不加@RequestParam， springboot会自动尝试隐性绑定前端url
    @GetMapping("/detail")
    public GraceJSONResult getDetail(String jobId){
        Job job = jobService.getDetail(jobId);
        return GraceJSONResult.ok(job);
    }

    @PostMapping("/delete")
    public GraceJSONResult delete(String jobId){
        jobService.delete(jobId);
        return GraceJSONResult.ok();
    }

    @GetMapping("/nameList")
    public GraceJSONResult nameList(){
        return GraceJSONResult.ok(jobService.nameList());
    }
}
