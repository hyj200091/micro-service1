package com.soft1851.share.service.impl;

import com.soft1851.share.entity.Share;
import com.soft1851.share.mapper.ShareMapper;
import com.soft1851.share.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ShareServiceImpl
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/26
 **/
@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareMapper shareMapper;

    @Override
    public List<Share> selectAll() {
        List<Share> shareList = shareMapper.selectAll();
        return shareList;
    }
}