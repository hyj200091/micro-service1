package com.soft1851.share.service;

import com.soft1851.share.entity.Share;

import java.util.List;

/**
 * @ClassName ShareService
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/26
 **/
public interface ShareService {
    /**
     * 查询所有的share
     * @return list
     */
    List<Share> selectAll();
}
