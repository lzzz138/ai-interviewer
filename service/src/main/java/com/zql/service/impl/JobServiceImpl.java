package com.zql.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.mysql.cj.util.StringUtils;
import com.zql.bo.JobBo;
import com.zql.mapper.JobMapper;
import com.zql.mapper.JobMapperCustom;
import com.zql.pojo.Job;
import com.zql.service.JobService;
import com.zql.service.base.BaseInfoProperties;
import com.zql.utils.PagedGridResult;
import com.zql.vo.JobVo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class JobServiceImpl extends BaseInfoProperties implements JobService {

    @Resource
    private JobMapper jobMapper;

    @Resource
    private JobMapperCustom jobMapperCustom;

    @Override
    public void createOrUpdate(JobBo jobBo) {
        Job job = new Job();
        BeanUtils.copyProperties(jobBo, job);
        job.setUpdatedTime(LocalDateTime.now());

        if(StringUtils.isNullOrEmpty(job.getId())){
            job.setCreateTime(LocalDateTime.now());
            jobMapper.insert(job);
        }
        else{
            jobMapper.updateById(job);
        }
    }

    @Override
    public PagedGridResult queryList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<JobVo> list = jobMapperCustom.queryList(null);
        return setterPagedGrid(list, page);
    }

    @Override
    public Job getDetail(String jobId) {
        Job job = jobMapper.selectById(jobId);
        return job;
    }

    @Override
    public void delete(String jobId) {
        jobMapper.deleteById(jobId);
    }

    @Override
    public boolean isJObContainsInterviewer(String interviewerId) {
        QueryWrapper<Job> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interviewer_id", interviewerId);

        Long num = jobMapper.selectCount(queryWrapper);
        return num > 0 ? true : false;
    }


    @Override
    public List<HashMap<String, String>> nameList() {
        return jobMapperCustom.nameList(null);
    }
}
