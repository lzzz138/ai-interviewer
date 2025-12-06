package com.zql.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mysql.cj.util.StringUtils;
import com.zql.bo.InterviewerBo;
import com.zql.mapper.InterviewerMapper;
import com.zql.pojo.Interviewer;
import com.zql.service.InterviewerService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InterviewerServiceImpl implements InterviewerService {

    @Resource
    private InterviewerMapper interviewerMapper;

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

        //todo  检验面试官是否关联其他的工作职位

        interviewerMapper.deleteById(id);
    }
}
