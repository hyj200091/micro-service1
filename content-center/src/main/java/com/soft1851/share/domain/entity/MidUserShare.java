package com.soft1851.share.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName MidUserShare
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/29
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "mid_user_share")
@ApiModel("用户分享")
public class MidUserShare {
    @Id
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(name = "id", value = "id")
    private Integer id;

    /**
     * share.id
     */
    @Column(name = "share_id")
    @ApiModelProperty(name = "id", value = "分享id")
    private Integer shareId;

    /**
     * user.id
     */
    @Column(name = "user_id")
    @ApiModelProperty(name = "id", value = "用户id")
    private Integer userId;
}