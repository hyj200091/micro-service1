package com.soft1851.share.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/16
 **/
@Slf4j
public class DateUtil {
    public static  int checkAllotSign(Date date) throws Exception {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 将时间格式类型转换成string
        String time = sdf.format(date);
        log.info("转换后的时间：" + time);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localTime = LocalDateTime.parse(time, dtf);
        LocalDateTime startTime = LocalDate.now().atTime(0, 0, 0);
        log.info("startTime:" + startTime);
        LocalDateTime endTime = LocalDate.now().atTime(23, 59, 59);
        log.info("endTime:" + endTime);
        System.out.println(localTime.isBefore(startTime));
        //如果时间时间小于今天的开始日期
        if (localTime.isBefore(startTime)) {
            log.info("数据库的数据小于今天的开始日期，没有签到，可以签到");
            return 0;
        }
        // 如果大于今天的开始日期，小于今天的结束日期
        if (localTime.isAfter(startTime) && localTime.isBefore(endTime)) {
            log.info("大于今天的开始日期，小于今天的结束日期，已经签到");
            result = 1;
        }
        // 如果大于今天的结束日期
        if (localTime.isAfter(endTime)) {
            log.info("大于今天的结束日期，数据乱了？？？");
            result = 2;
        }
        return result;
    }
}