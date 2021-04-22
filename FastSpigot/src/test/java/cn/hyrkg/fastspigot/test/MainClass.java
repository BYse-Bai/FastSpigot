package cn.hyrkg.fastspigot.test;

import cn.hyrkg.fastspigot.innercore.FastInnerCore;
import cn.hyrkg.fastspigot.innercore.annotation.Inject;
import cn.hyrkg.fastspigot.innercore.framework.HandlerInfo;
import cn.hyrkg.fastspigot.innercore.framework.interfaces.IImplementation;
import lombok.SneakyThrows;

public class MainClass implements IImplementation {
    @Inject
    public TestHandler testHandler;



    @SneakyThrows
    public static void main(String[] args) {
        FastInnerCore fastInnerCore = new FastInnerCore(null);
        fastInnerCore.onEnable();

        MainClass mainClass;
        fastInnerCore.getHandlerInjector().handleInstance(mainClass = new MainClass(), MainClass.class);

        mainClass.testHandler.say();

    }

    @Override
    public void handleHandler(Object object, HandlerInfo handlerInfo) {

    }
}
