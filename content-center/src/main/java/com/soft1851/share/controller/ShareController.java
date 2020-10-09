package com.soft1851.share.controller;

import com.soft1851.share.domain.dto.ShareDto;
import com.soft1851.share.domain.dto.ShareRequestDto;
import com.soft1851.share.domain.entity.Share;
import com.soft1851.share.service.ShareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @ClassName ShareController
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/26
 **/
@RestController
@RequestMapping(value = "/shares")
@Api(tags = "分享接口",value = "提供分享相关的Rest API")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {

    private final ShareService shareService;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "查询指定id的分享详情",notes = "查询指定id的分享详情")
    public ShareDto findById(@PathVariable Integer id){
        return this.shareService.findById(id);
    }

    @GetMapping(value = "/query")
    @ApiOperation(value = "分享列表",notes = "分享列表")
    public List<Share> query(
            @RequestParam(required = false) String title,
            @RequestParam(required = false,defaultValue = "1") Integer pageNo,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) Integer userId) throws Exception{
        if (pageSize > 100){
            pageSize = 100;
        }
        return this.shareService.query(title,pageNo,pageSize,userId).getList();
    }

    @GetMapping(value = "/hello")
    @ApiIgnore
    public String getHello(){
        return this.shareService.getHello();
    }

    @PostMapping(value = "/contribute")
    @ApiOperation(value = "投稿接口",notes = "投稿接口")
    public Share insertShare(@RequestBody ShareRequestDto shareRequestDto){
       return this.shareService.insertShare(shareRequestDto);
    }
    @GetMapping("/all")
    @ApiIgnore
    public List<Share> getAll(){
        return shareService.selectAll();
    }

}