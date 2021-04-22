package cn.hyrkg.fastspigot.test;

import cn.hyrkg.fastspigot.innercore.FastInnerCore;
import cn.hyrkg.fastspigot.innercore.annotation.Inject;
import lombok.SneakyThrows;

public class MainClass {

    @Inject
    public static LogHandler handler;


    public static void main(String[] args) {
        FastInnerCore core = new FastInnerCore(null);
        core.getHandlerInjector().handleInstance(new MainClass(), MainClass.class);

        handler.testHandler.info("hahha");
    }
}
