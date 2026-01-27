package com.zql.service;

import com.zql.bo.JobBo;
import com.zql.pojo.Job;
import com.zql.utils.PagedGridResult;

import java.util.HashMap;
import java.util.List;

public interface JobService {

    public void createOrUpdate(JobBo jobBo);

    public PagedGridResult queryList(Integer page, Integer pageSize);

    public Job getDetail(String jobId);

    public void delete(String jobId);

    public boolean isJObContainsInterviewer(String interviewerId);

    public List<HashMap<String, String>> nameList();
}
