package cn.hyrkg.fastspigot.core.framework.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class HandlerInfo {
    public final HandlerInfo parentInfo;
    public final Class<?> originClass;
    public final Class<?> injectedClass;
    public final Object object;
    @Getter
    private final ArrayList<HandlerInfo> childInfo = new ArrayList<>();

    public void addChildInfo(HandlerInfo info) {
        childInfo.add(info);
    }

}
