package com.soft1851.share.service.impl;

import com.soft1851.share.domain.entity.Share;
import com.soft1851.share.service.ShareService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class ShareServiceImplTest {
    private ShareService shareService;
    @Test
    void getApply() {
        List<Share> list = this.shareService.getApply(10);
        System.out.println(list);
    }
}