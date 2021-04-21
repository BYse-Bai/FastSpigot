package cn.hyrkg.fastspigot.core.test;

import cn.hyrkg.fastspigot.core.FastInnerCore;
import cn.hyrkg.fastspigot.core.annotation.InjectHandler;
import lombok.SneakyThrows;

public class MainClass {
    @InjectHandler
    public TestHandler testHandler;


    @SneakyThrows
    public static void main(String[] args) {
        FastInnerCore fastInnerCore = new FastInnerCore();
        fastInnerCore.onEnable();

        MainClass mainClass;
        fastInnerCore.getHandlerInjector().handleInstance(mainClass = new MainClass());

        mainClass.testHandler.say();

    }

}
