package cn.hyrkg.fastspigot.innercore.framework.interfaces;

import cn.hyrkg.fastspigot.innercore.framework.HandlerInfo;

public interface IImplementation<T> {
    void handleHandler(T handlerInstance, HandlerInfo handlerInfo);

}
