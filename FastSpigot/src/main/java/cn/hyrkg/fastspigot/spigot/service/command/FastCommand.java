package cn.hyrkg.fastspigot.spigot.service.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FastCommand {
    String index() default "";

    boolean requireOp() default false;

    String[] paramsName() default {};

    String desc();

    int order() default 0;
}
