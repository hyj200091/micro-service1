package com.soft1851.share.domain.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserAddBonusMsgDto
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/8
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Api("积分传输信息")
public class UserAddBonusMsgDto {
    /**
     * 为谁加积分
     */
    @ApiModelProperty(name = "userId",value = "用户id")
    private Integer userId;

    /**
     * 加多少积分
     */
    @ApiModelProperty(name = "bonus",value = "增加多少积分")
    private Integer bonus;
}