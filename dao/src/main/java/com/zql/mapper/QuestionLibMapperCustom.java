package com.zql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zql.pojo.QuestionLib;
import com.zql.vo.QuestionLibVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 面试题库表（每个数字人面试官都会对应一些面试题） Mapper 接口
 * </p>
 *
 * @author 风间影月
 * @since 2025-12-02
 */
public interface QuestionLibMapperCustom {

    public List<QuestionLibVo> queryQuestionLibList(@Param("paramMap") Map<String, Object> map);
}
