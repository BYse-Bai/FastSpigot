package cn.hyrkg.fastspigot.core;

import lombok.Getter;

public class FastInnerCore {

    /**
     * 负责进行动态注入
     */
    @Getter
    private AsmInjector asmInjector;

    @Getter
    private HandlerInjector handlerInjector;

    public void onEnable() {
        asmInjector = new AsmInjector(this);
        handlerInjector = new HandlerInjector(this);
    }

    public void warm(String string) {
        System.out.println(string);
    }

}
