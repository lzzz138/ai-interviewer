package com.zql.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobVo {


    private String jobId;

    /**
     * 职位名称
     */
    private String jobName;

    /**
     * 职位描述
     */
    private String jobDesc;

    /**
     * 1：职位开启
2：职位关闭
     */
    private Integer status;

    /**
     * 分配的数字人面试官id，每个职位需要对应的面试官来进行面试
     */
    private String interviewerId;


    private String interviewerName;

    /**
     * 该职位的面试结果最终发给ChatGLM的前缀提示词
     */
    private String prompt;

    private LocalDateTime createTime;

    private LocalDateTime updatedTime;


}
