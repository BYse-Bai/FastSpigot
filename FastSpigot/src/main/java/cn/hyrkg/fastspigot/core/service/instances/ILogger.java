package cn.hyrkg.fastspigot.core.service.instances;

import cn.hyrkg.fastspigot.core.framework.handler.HandlerInfo;
import cn.hyrkg.fastspigot.core.service.IServiceProvider;

public interface ILogger extends IServiceProvider {
    public default void log(String str) {
        HandlerInfo info = getInnerCore().getHandlerInjector().getHandlerInfo(getClass());

        String combine = info.getOriginClass().getSimpleName();
        HandlerInfo head = info;
        while (head.getParentInfo() != null) {
            head = head.getParentInfo();
            combine = head.getOriginClass().getSimpleName() + ">" + combine;
        }

        System.out.println(combine + ": " + str);
    }
}
