package com.soft1851.share.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserAddBonusDTO
 * @Description 用户增加积分的数据传输对象
 * @Author hyj
 * @Date 2020/10/15
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddBonusDTO {
    private Integer userId;
    /**
     * 积分
     */
    private Integer bonus;
}