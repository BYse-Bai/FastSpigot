package cn.hyrkg.fastspigot.innercore;

import cn.hyrkg.fastspigot.spigot.service.ILogger;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FastInnerCore {

    @Getter
    private final ILogger creator;

    @Getter
    private final AsmInjector asmInjector = new AsmInjector(this);

    @Getter
    private final HandlerInjector handlerInjector = new HandlerInjector(this);

    @Getter
    private final FunctionInjector functionInjector = new FunctionInjector(this);

}
