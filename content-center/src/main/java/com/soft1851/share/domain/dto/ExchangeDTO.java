package com.soft1851.share.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ExchangeDTO
 * @Description 兑换数据传输对象
 * @Author hyj
 * @Date 2020/10/15
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("兑换分享详情")
public class ExchangeDTO {
    @ApiModelProperty(name = "id", value = "用户id")
    private Integer userId;
    @ApiModelProperty(name = "id", value = "分享id")
    private Integer shareId;
}