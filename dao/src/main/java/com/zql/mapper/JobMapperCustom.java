package com.zql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zql.pojo.Job;
import com.zql.vo.JobVo;
import com.zql.vo.QuestionLibVo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface JobMapperCustom{
    public List<JobVo> queryList(@Param("paramMap") Map<String, Object> map);

    public List<HashMap<String, String>> nameList(@Param("paramMap") Map<String, Object> map);
}
