package com.zql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zql.pojo.Candidate;
import com.zql.vo.CandidateVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 应聘者表 Mapper 接口
 * </p>
 *
 * @author 风间影月
 * @since 2025-12-02
 */
public interface CandidateMapperCustom {
    public List<CandidateVo> queryList(@Param("paramMap") Map<String, Object> map);
}
