package cn.hyrkg.fastspigot.core.service;

public interface ILogger extends IServiceProvider{
    default void log(String info) {
        if(getInnerCore().isPresent())
            getInnerCore().get();
    }
}
