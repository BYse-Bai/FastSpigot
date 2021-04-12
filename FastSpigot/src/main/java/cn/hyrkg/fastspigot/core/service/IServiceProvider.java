package cn.hyrkg.fastspigot.core.service;

import cn.hyrkg.fastspigot.core.FastInnerCore;

import java.util.Optional;

public interface IServiceProvider {
    /**
     * 返回当前插件域中的InnerCode,若当前方法为空,则调用会失效。
     **/
    default Optional<FastInnerCore> getInnerCore() {
        return Optional.empty();
    }

    /**
     * 如果当前InnerCore注入成功，则调用执行函数。
     **/
    default void invokeIfInnerCoreIsPresent(Class<? extends IServiceProvider> provider, String method, Object thisObject) {
        if (getInnerCore().isPresent())
            getInnerCore().get().invokeServiceImplementation(provider, method, thisObject);
    }
}
