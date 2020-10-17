package com.soft1851.share.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserSignInDTO
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/16
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSignInDTO {
    private Integer userId;
}