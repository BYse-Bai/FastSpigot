package cn.hyrkg.fastspigot.core.framework.handler;

import cn.hyrkg.fastspigot.core.service.IServiceProvider;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
@Getter
public class HandlerInfo {
    private final HandlerInfo parentInfo;
    private final Class<?> originClass;
    private final Class<?> injectedClass;
    private final Object object;

    private final ArrayList<HandlerInfo> childInfo = new ArrayList<>();

    private boolean isDone = false;

    public void addChildInfo(HandlerInfo info) {
        if (!isDone)
            childInfo.add(info);
    }

    public void done() {
        isDone = true;
    }
}
