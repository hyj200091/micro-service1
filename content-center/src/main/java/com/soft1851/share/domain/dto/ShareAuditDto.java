package com.soft1851.share.domain.dto;

import com.soft1851.share.domain.enums.AuditStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ShareAuditDto
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/8
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("审核详情")
public class ShareAuditDto {
    /**
     * 审核状态
     */
    @ApiModelProperty(name = "auditStatusEnum",value = "返回状态")
    private AuditStatusEnum auditStatusEnum;

    /**
     * 原因
     */

    @ApiModelProperty(name = "reason",value = "审核原因")
    private String reason;
}