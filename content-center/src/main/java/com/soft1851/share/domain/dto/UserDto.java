package com.soft1851.share.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/27
 **/
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("登录详情DTO")
public class UserDto {
    /**
     * Id
     */
    @ApiModelProperty(name = "id", value = "id")
    private Integer id;

    /**
     * 微信id
     */
    @ApiModelProperty(name = "wxId", value = "微信id")
    private String wxId;

    /**
     * 微信昵称
     */
    @ApiModelProperty(name = "wxNickname", value = "微信昵称")
    private String wxNickname;

    /**
     * 角色
     */
    @ApiModelProperty(name = "roles", value = "用户角色")
    private String roles;

    /**
     * 头像地址
     */
    @ApiModelProperty(name = "avatarUrl", value = "头像")
    private String avatarUrl;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(name = "updateTime", value = "更新时间")
    private Date updateTime;

    /**
     * 积分
     */
    @ApiModelProperty(name = "bonus", value = "积分")
    private Integer bonus;
}