package com.zql.service.impl;

import com.github.pagehelper.PageHelper;
import com.mysql.cj.util.StringUtils;
import com.zql.bo.CandidateBo;
import com.zql.mapper.CandidateMapper;
import com.zql.mapper.CandidateMapperCustom;
import com.zql.pojo.Candidate;
import com.zql.service.CandidateService;
import com.zql.service.base.BaseInfoProperties;
import com.zql.utils.PagedGridResult;
import com.zql.vo.CandidateVo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.introspector.BeanAccess;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CandidateServiceImpl extends BaseInfoProperties implements CandidateService {
    @Resource
    private CandidateMapper candidateMapper;

    @Resource
    private CandidateMapperCustom candidateMapperCustom;

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

    @Override
    public PagedGridResult queryList(String realName, String mobile, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        Map<String, Object> map = new HashMap<>();
        map.put("realName", realName);
        map.put("mobile", mobile);

        List<CandidateVo> list = candidateMapperCustom.queryList(map);

        return setterPagedGrid(list, page);
    }
}
