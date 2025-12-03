package com.zql.service;

import com.zql.bo.InterviewerBo;
import com.zql.pojo.Interviewer;

import java.util.List;

public interface InterviewerService {

    public void CreateOrUpdate(InterviewerBo interviewerBo);

    public List<Interviewer> queryAll();
}
