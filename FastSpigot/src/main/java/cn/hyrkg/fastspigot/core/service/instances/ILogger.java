package cn.hyrkg.fastspigot.core.service.instances;

import cn.hyrkg.fastspigot.core.service.IServiceProvider;

public interface ILogger extends IServiceProvider {
    public default void log(String str) {
        System.out.println(getClass().getSimpleName() + "> " + str);
    }
}
