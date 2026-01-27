package com.zql.service;

import com.zql.bo.CandidateBo;
import com.zql.bo.JobBo;
import com.zql.pojo.Candidate;
import com.zql.utils.PagedGridResult;

public interface CandidateService {

    public void createOrUpdate(CandidateBo candidateBo);

    public PagedGridResult queryList(String realName, String mobile, Integer page, Integer pageSize);

    public Candidate getDetail(String candidateId);

    public void delete(String candidateId);
}
