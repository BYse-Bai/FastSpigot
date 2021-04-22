package cn.hyrkg.fastspigot.test;

import cn.hyrkg.fastspigot.innercore.FastInnerCore;
import cn.hyrkg.fastspigot.innercore.annotation.Inject;
import lombok.SneakyThrows;

public class MainClass {
    @Inject
    public TestHandler testHandler;

    @SneakyThrows
    public static void main(String[] args) {
        FastInnerCore fastInnerCore = new FastInnerCore(null);

        MainClass mainClass;
        fastInnerCore.getHandlerInjector().handleInstance(mainClass = new MainClass(), MainClass.class);

        mainClass.testHandler.say();

    }

}
