package com.zql.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mysql.cj.util.StringUtils;
import com.zql.bo.InterviewerBo;
import com.zql.exception.GraceException;
import com.zql.grace.result.ResponseStatusEnum;
import com.zql.mapper.InterviewerMapper;
import com.zql.pojo.Interviewer;
import com.zql.service.InterviewerService;
import com.zql.service.JobService;
import com.zql.service.QuestionLibService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InterviewerServiceImpl implements InterviewerService {

    @Resource
    private InterviewerMapper interviewerMapper;

    @Resource
    private JobService jobService;

    @Resource
    private QuestionLibService questionLibService;

    @Override
    public void CreateOrUpdate(InterviewerBo interviewerBo){
        Interviewer interviewer = new Interviewer();
        BeanUtils.copyProperties(interviewerBo, interviewer);
        interviewer.setUpdatedTime(LocalDateTime.now());

        if (StringUtils.isNullOrEmpty(interviewer.getId())) {
            // Create new interviewer
            interviewer.setCreateTime(LocalDateTime.now());
            interviewerMapper.insert(interviewer);
        } else {
            // Update existing interviewer
            interviewerMapper.updateById(interviewer);
        }
    }

    @Override
    public List<Interviewer> queryAll() {
        return interviewerMapper.selectList(new QueryWrapper<Interviewer>().orderByDesc("updated_time"));
    }

    @Override
    public void delete(String id) {

        boolean jobFlag = jobService.isJObContainsInterviewer(id);
        boolean questionFlag = questionLibService.isQuestionContainsInterviewer(id);

        if(jobFlag || questionFlag){
            GraceException.display(ResponseStatusEnum.CAN_NOT_DELETE_INTERVIEWER);
        }
        else{
            interviewerMapper.deleteById(id);
        }

    }
}
