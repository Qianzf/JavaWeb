package com.senchuuhi.iweb.wsk.atiface;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WS {

    public String command() default "ping";

    public String role() default "all";
}
