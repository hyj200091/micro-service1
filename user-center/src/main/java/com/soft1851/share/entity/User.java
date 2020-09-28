package com.soft1851.share.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName User
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/27
 **/
@Table(name = "t_user")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name ="name")
    private String name;

    @Column(name = "avatar")
    private String avatar;
}