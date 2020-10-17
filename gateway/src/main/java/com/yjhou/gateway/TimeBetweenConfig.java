package com.yjhou.gateway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

/**
 * @ClassName 定义开始和结束的两个参数
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/9
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeBetweenConfig  {
    private LocalTime start;
    private LocalTime end;
}