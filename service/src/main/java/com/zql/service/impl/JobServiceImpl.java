package com.zql.service.impl;

import com.mysql.cj.util.StringUtils;
import com.zql.bo.JobBo;
import com.zql.mapper.JobMapper;
import com.zql.pojo.Job;
import com.zql.service.JobService;
import com.zql.service.base.BaseInfoProperties;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JobServiceImpl extends BaseInfoProperties implements JobService {

    @Resource
    private JobMapper jobMapper;

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
}
