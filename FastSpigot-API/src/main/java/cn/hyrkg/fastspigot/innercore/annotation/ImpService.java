package cn.hyrkg.fastspigot.innercore.annotation;

import cn.hyrkg.fastspigot.innercore.framework.interfaces.IImplementation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ImpService {

    Class<? extends IImplementation> impClass();
}
