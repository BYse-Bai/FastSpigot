package cn.hyrkg.fastspigot.core;

import cn.hyrkg.fastspigot.core.asm.AsmInjector;
import cn.hyrkg.fastspigot.core.service.IServiceProvider;
import lombok.Getter;

public class FastInnerCore {

    /**
     * 负责进行动态注入
     */
    @Getter
    private AsmInjector asmInjector;

    public void onEnable() {
        asmInjector = new AsmInjector(this);
    }



}
