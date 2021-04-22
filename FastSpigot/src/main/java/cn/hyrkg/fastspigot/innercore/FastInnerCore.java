package cn.hyrkg.fastspigot.innercore;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FastInnerCore {

    @Getter
    private final Object creator;

    @Getter
    private final AsmInjector asmInjector = new AsmInjector(this);

    @Getter
    private final HandlerInjector handlerInjector = new HandlerInjector(this);

    @Getter
    private final FunctionInjector functionInjector = new FunctionInjector(this);

    public void onEnable() {

    }

    public void onDisable() {

    }

    public void warm(String string) {
        System.out.println(string);
    }

}
