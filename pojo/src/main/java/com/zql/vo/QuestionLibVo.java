package com.zql.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionLibVo {


    private String questionLibId;

    private String question;

    private String referenceAnswer;

    private String aiSrc;

    private String interviewerId;

    private String interviewerName;

    private Integer isOn;

    private LocalDateTime createTime;

    private LocalDateTime updatedTime;


}
