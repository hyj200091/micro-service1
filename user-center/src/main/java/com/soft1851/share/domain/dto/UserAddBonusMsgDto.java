package com.soft1851.share.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserAddBonusMsgDto
 * @Description 用户增加积分消息数据传输对象
 * @Author hyj
 * @Date 2020/10/8
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddBonusMsgDto {
    /**
     * 为谁加积分
     */
    private Integer userId;
    /**
     * 加多少积分
     */
    private Integer bonus;

    /**
     * 描述
     */
    private String description;

    /**
     * 事件
     */
    private String event;
}