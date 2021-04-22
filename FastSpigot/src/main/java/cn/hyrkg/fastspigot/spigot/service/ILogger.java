package cn.hyrkg.fastspigot.spigot.service;

import cn.hyrkg.fastspigot.innercore.framework.HandlerInfo;
import cn.hyrkg.fastspigot.innercore.framework.interfaces.IServiceProvider;

public interface ILogger extends IServiceProvider {
    default void log(String str) {
        HandlerInfo info = getHandlerInfo();

        String combine = info.originClass.getSimpleName();
        HandlerInfo head = info;
        while (head.parentInfo != null) {
            head = head.parentInfo;
            combine = head.originClass.getSimpleName() + ">" + combine;
        }

        System.out.println(combine + ": " + str);
    }
}
