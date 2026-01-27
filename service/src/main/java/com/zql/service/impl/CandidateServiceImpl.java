package com.zql.service.impl;

import com.mysql.cj.util.StringUtils;
import com.zql.bo.CandidateBo;
import com.zql.mapper.CandidateMapper;
import com.zql.pojo.Candidate;
import com.zql.service.CandidateService;
import com.zql.service.base.BaseInfoProperties;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.introspector.BeanAccess;

import java.time.LocalDateTime;

@Service
public class CandidateServiceImpl extends BaseInfoProperties implements CandidateService {
    @Resource
    private CandidateMapper candidateMapper;

    @Override
    public void createOrUpdate(CandidateBo candidateBo) {
        Candidate candidate = new Candidate();
        BeanUtils.copyProperties(candidateBo, candidate);
        candidate.setUpdatedTime(LocalDateTime.now());

        if(StringUtils.isNullOrEmpty(candidate.getId())){
            candidate.setCreatedTime(LocalDateTime.now());
            candidateMapper.insert(candidate);
        }
        else{
            candidateMapper.updateById(candidate);
        }
    }
}
