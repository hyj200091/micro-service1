package com.soft1851.share.service;

import com.github.pagehelper.PageInfo;
import com.soft1851.share.domain.entity.Share;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class ShareServiceTest {
@Autowired
private ShareService shareService;
    @Test
    void query() {
        PageInfo<Share> query  = shareService.query(null,1,10,1);
        List<Share> list = query.getList();
        list.forEach(item-> System.out.println(item.getTitle()+','+item.getDownloadUrl()));
    }
}