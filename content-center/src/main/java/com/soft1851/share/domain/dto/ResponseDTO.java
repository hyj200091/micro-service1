package com.soft1851.share.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResponseDTO
 * @Description 统一返回结果封装对象
 * @Author hyj
 * @Date 2020/10/15
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("统一返回结果详情")
public class ResponseDTO {
    @ApiModelProperty(name = "succ",value = "返回类型 true 或者是false")
    private Boolean succ;
    @ApiModelProperty(name = "code", value = "返回状态码")
    private String code;
    @ApiModelProperty(name = "msg", value = "返回消息")
    private String msg;
    @ApiModelProperty(name = "data", value = "返回数据")
    private Object data;
    @ApiModelProperty(name = "ts", value = "耗时")
    private Long ts;
}