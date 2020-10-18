package com.soft1851.share.controller;

import com.soft1851.share.domain.dto.ShareAuditDto;
import com.soft1851.share.domain.entity.Share;
import com.soft1851.share.service.ShareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ShareAdminController
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/8
 **/
@RestController
@RequestMapping("/admin/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "兑换接口",value = "提供相关兑换积分的Rest API")
public class ShareAdminController {
    private final ShareService shareService;

    @ApiOperation(value = "兑换某个分享",notes = "兑换某个分享")
    @PutMapping(value = "/audit/{id}")
    public Share auditById(@PathVariable Integer id, @RequestBody ShareAuditDto shareAuditDto) {
        //此处需要认证授权
        return this.shareService.auditById(id, shareAuditDto);
    }

    @PutMapping(value = "/auditInsert/{id}")
    public Share auditInsertById(@PathVariable Integer id, @RequestBody ShareAuditDto shareAuditDto) {
        //此处需要认证授权
        return this.shareService.insertBlog(id, shareAuditDto);
    }
}