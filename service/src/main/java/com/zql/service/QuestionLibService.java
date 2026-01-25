package com.zql.service;

import com.zql.bo.QuestionLibBo;
import com.zql.utils.PagedGridResult;

public interface QuestionLibService {

    public void createOrUpdate(QuestionLibBo questionLibBo);

    public PagedGridResult queryList(String question, String aiName, Integer page, Integer pageSize);

    public void setDisplayOrShow(String questionLibId, Integer isOn);
}
