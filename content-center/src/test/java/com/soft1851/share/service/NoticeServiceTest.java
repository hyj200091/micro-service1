package com.soft1851.share.service;

import com.soft1851.share.domain.entity.Notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoticeServiceTest {
@Autowired
private NoticeService noticeService;
    @org.junit.jupiter.api.Test
    void getLatest() {
        Notice notice = noticeService.getLatest();
        System.out.println(notice);
    }
}