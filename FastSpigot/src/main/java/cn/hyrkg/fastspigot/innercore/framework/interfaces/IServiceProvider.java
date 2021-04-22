package cn.hyrkg.fastspigot.innercore.framework.interfaces;

import cn.hyrkg.fastspigot.innercore.FastInnerCore;
import cn.hyrkg.fastspigot.innercore.framework.HandlerInfo;

public interface IServiceProvider {
    /**
     * 返回当前插件域中的InnerCode,若当前方法为空,则调用会失效。
     **/
    default FastInnerCore getInnerCore() {
        return null;
    }

    default HandlerInfo getHandlerInfo() {
        return getInnerCore().getHandlerInjector().getHandlerInfo(getClass());
    }

    default <T> T getImplementation(Class<? extends IServiceProvider> impService) {
        return getInnerCore().getFunctionInjector().getImplementation(this, impService);
    }
}
