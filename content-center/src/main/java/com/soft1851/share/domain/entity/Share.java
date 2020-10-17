package com.soft1851.share.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.util.Date;

/**
 * @ClassName Share
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/26
 **/
@Table(name = "share")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("分享")
public class Share {
    @Id
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(name = "id", value = "分享id")
    private Integer id;

    @ApiModelProperty(name = "userId", value = "分享人id")
    @Column(name = "user_id")
    private Integer userId;

    @ApiModelProperty(name = "title", value = "分享内容标题")
    @Column(name = "title")
    private String title;


    @Column(name = "create_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "updateTime", value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;

    @ApiModelProperty(name = "isOriginal", value = "是否原创 0:否 1:是")
    @Column(name = "is_original")
    private int isOriginal;

    @ApiModelProperty(name = "author", value = "作者")
    @Column(name = "author")
    private String author;

    @ApiModelProperty(name = "cover", value = "封面")
    @Column(name = "cover")
    private String cover;

    @ApiModelProperty(name = "summary", value = "概要信息")
    @Column(name = "summary")
    private String summary;

    @ApiModelProperty(name = "price", value = "价格(需要的积分)")
    @Column(name = "price")
    private Integer price;

    @ApiModelProperty(name = "downloadUrl", value = "下载url")
    @Column(name = "download_url")
    private String downloadUrl;

    @ApiModelProperty(name = "buyCount", value = "下载数")
    @Column(name = "buy_count")
    private Integer buyCount;

    @ApiModelProperty(name = "showFlag", value = "是否显示 0:否 1:是")
    @Column(name = "show_flag")
    private int showFlag;

    @ApiModelProperty(name = "auditStatus", value = "审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过")
    @Column(name = "audit_status")
    private String auditStatus;

    @ApiModelProperty(name = "reason", value = "审核不通过原因")
    @Column(name = "reason")
    private String reason;
}