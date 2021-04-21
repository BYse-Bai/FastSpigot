package cn.hyrkg.fastspigot.core.framework.handler;

import cn.hyrkg.fastspigot.core.service.IServiceProvider;

public class HandlerInfo {
    public HandlerInfo ownerInfo;
    public Object ownerObj;

    public Class<?> originClass;
    public Class<?> injectedClass;
}
