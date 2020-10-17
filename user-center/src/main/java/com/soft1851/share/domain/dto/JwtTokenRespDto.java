package com.soft1851.share.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName 返回结果中心的JWT数据对象
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/13
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JwtTokenRespDto {
private String token;
private Long expirationTime;
}