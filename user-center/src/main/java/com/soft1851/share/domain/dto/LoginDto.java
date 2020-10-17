package com.soft1851.share.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName 用户登录时传输对象(客户端->后台)
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/12
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoginDto {
    private String openId;
    private String wxNickname;
    private String avatarUrl;
    private String loginCode;
}
