package com.senchuuhi.iweb.wsk.atiface;

import java.lang.annotation.*;

/**
 * wobsocket 通道
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WSPIPE {

    // 通道优先级
    public int priority() default -1;

}
