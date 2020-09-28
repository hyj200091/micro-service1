package com.soft1851.share.controller;

import com.soft1851.share.entity.Share;
import com.soft1851.share.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ShareController
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/26
 **/
@RestController
@RequestMapping(value = "/api")
public class ShareController {
    @Autowired
    private  ShareService shareService;

    @GetMapping("/sharelist")
    public List<Share> getShareList(){
        return shareService.selectAll();
    }
}