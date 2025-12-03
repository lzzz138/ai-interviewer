package com.zql.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 数字人面试官表
 * </p>
 *
 * @author 风间影月
 * @since 2025-12-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewerBo {


    private String id;

    /**
     * 数字人面试官的名称
     */
    private String aiName;

    /**
     * 数字人形象图照片
     */
    private String image;


}
