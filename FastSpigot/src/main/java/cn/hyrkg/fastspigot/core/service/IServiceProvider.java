package cn.hyrkg.fastspigot.core.service;

import cn.hyrkg.fastspigot.core.FastInnerCore;

public interface IServiceProvider {
    /**
     * 返回当前插件域中的InnerCode,若当前方法为空,则调用会失效。
     **/
    default FastInnerCore getInnerCore() {
        return null;
    }

}
