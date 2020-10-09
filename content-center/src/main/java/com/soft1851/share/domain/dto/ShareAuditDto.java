package com.soft1851.share.domain.dto;

import com.soft1851.share.domain.enums.AuditStatusEnum;
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
public class ShareAuditDto {
    /**
     * 审核状态
     */
    private AuditStatusEnum auditStatusEnum;

    /**
     * 原因
     */
    private String reason;
}