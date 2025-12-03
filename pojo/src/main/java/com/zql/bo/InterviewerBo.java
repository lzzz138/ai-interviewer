package com.zql.bo;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "数字人面试官名称不能为空")
    private String aiName;

    /**
     * 数字人形象图照片
     */
    @NotBlank(message = "数字人形象图照片不能为空")
    private String image;


}
