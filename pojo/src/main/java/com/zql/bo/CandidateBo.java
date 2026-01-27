package com.zql.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateBo {


    private String id;

    private String realName;

    private String identityNum;

    private String mobile;

    private Integer sex;

    private String email;

    private LocalDate birthday;


}
