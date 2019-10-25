package com.adam.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by adamDeng on 2019/10/24
 * Copyright © 2019年 . All rights reserved.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface Optional {
    String stringValue() default "";
    int intValue() default 0;
    float floatValue() default 0f;
    boolean booleanValue() default false;
}
