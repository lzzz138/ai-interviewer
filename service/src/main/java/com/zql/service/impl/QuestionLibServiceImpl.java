package com.zql.service.impl;

import com.mysql.cj.util.StringUtils;
import com.zql.bo.QuestionLibBo;
import com.zql.enums.YesOrNo;
import com.zql.mapper.QuestionLibMapper;
import com.zql.pojo.QuestionLib;
import com.zql.service.QuestionLibService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class QuestionLibServiceImpl implements QuestionLibService {

    @Resource
    private QuestionLibMapper questionLibMapper;


    @Override
    public void createOrUpdate(QuestionLibBo questionLibBo) {
        QuestionLib questionLib = new QuestionLib();
        BeanUtils.copyProperties(questionLibBo, questionLib);
        questionLib.setUpdatedTime(LocalDateTime.now());


        if(StringUtils.isNullOrEmpty(questionLib.getId())){
            questionLib.setCreateTime(LocalDateTime.now());
            questionLib.setIsOn(YesOrNo.YES.type);
            questionLibMapper.insert(questionLib);
        }
        else{
            questionLibMapper.updateById(questionLib);
        }

    }
}
