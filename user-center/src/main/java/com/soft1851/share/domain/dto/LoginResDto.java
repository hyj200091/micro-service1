package com.soft1851.share.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName LoginResDto
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/12
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResDto {
    private UserRespDto user;
    private JwtTokenRespDto token;
    private Integer isUserSignin;
}