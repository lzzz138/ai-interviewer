package com.zql.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateVo {


    private String candidateId;

    private String realName;

    private String identityNum;

    private String mobile;

    private Integer sex;

    private String email;

    private LocalDate birthday;

    private String jobId;

    private LocalDateTime createdTime;

    private String jobName;

}
