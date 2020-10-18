package com.soft1851.share.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ShareRequestDto
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/7
 **/
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("投稿详情")
public class ShareRequestDto {
    @ApiModelProperty(name = "userId", value = "分享人id")
    private Integer userId;

    @ApiModelProperty(name = "author", value = "分享作者")
    private String author;

    @ApiModelProperty(name = "downloadUrl", value = "下载链接")
    private String downloadUrl;

    @ApiModelProperty(name = "isOriginal", value = "是否原创")
    private int isOriginal;

    @ApiModelProperty(name = "price", value = "价格")
    private Integer price;

    @ApiModelProperty(name = "summary", value = "简介")
    private String summary;

    @ApiModelProperty(name = "title", value = "标题")
    private String title;

}