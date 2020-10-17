package com.soft1851.share.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @ClassName CheckAuthorization
 * @Description TODO
 * @Author hyj
 * @Date 2020/10/13
 **/
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckAuthorization {
    String value();
}
