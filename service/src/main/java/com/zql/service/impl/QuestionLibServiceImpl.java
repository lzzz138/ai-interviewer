package com.zql.service.impl;

import com.github.pagehelper.PageHelper;
import com.mysql.cj.util.StringUtils;
import com.zql.bo.QuestionLibBo;
import com.zql.enums.YesOrNo;
import com.zql.mapper.QuestionLibMapper;
import com.zql.mapper.QuestionLibMapperCustom;
import com.zql.pojo.QuestionLib;
import com.zql.service.QuestionLibService;
import com.zql.service.base.BaseInfoProperties;
import com.zql.utils.PagedGridResult;
import com.zql.vo.QuestionLibVo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class QuestionLibServiceImpl extends BaseInfoProperties implements QuestionLibService {

    @Resource
    private QuestionLibMapper questionLibMapper;

    @Resource
    private QuestionLibMapperCustom questionLibMapperCustom;


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

    @Override
    public PagedGridResult queryList(String question, String aiName, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        Map<String, Object> map = new HashMap<>();
        map.put("question", question);
        map.put("aiName", aiName);

        List<QuestionLibVo> list = questionLibMapperCustom.queryQuestionLibList(map);

        return setterPagedGrid(list, page);
    }
}
