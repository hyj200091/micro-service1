package com.soft1851.share.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName wxLoginDto
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/13
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class wxLoginDto {
    private String openId;
    private String wxNickname;
    private String avatarUrl;
    private String code;
}