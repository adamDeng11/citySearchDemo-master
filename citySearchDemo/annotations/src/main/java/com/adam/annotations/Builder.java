package com.adam.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by adamDeng on 2019/10/24
 * Copyright © 2019年 . All rights reserved.
 */
//标注类型
@Target(ElementType.TYPE)
//在什么时候用
@Retention(RetentionPolicy.CLASS)
public @interface Builder {
}
