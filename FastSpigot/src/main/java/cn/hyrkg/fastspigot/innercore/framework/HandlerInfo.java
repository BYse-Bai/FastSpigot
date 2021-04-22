package cn.hyrkg.fastspigot.innercore.framework;

import cn.hyrkg.fastspigot.innercore.FastInnerCore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class HandlerInfo {
    public final FastInnerCore innerCore;
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
