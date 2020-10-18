package com.soft1851.share.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("增加积分传输对象")
public class UserAddBonusDTO {
    @ApiModelProperty(name = "userId",value = "用户id")
    private Integer userId;
    /**
     * 积分
     */
    @ApiModelProperty(name = "bonus",value = "积分")
    private Integer bonus;
}