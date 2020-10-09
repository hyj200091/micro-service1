package com.soft1851.share.service;

import com.soft1851.share.domain.entity.Notice;

/**
 * @ClassName NoticeService
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/5
 **/
public interface NoticeService {

    /**
     * 查询最新公告
     * @return Notices
     */
    Notice getLatest();
}
