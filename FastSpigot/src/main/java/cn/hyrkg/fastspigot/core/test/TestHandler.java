package cn.hyrkg.fastspigot.core.test;

import cn.hyrkg.fastspigot.core.annotation.InjectHandler;
import cn.hyrkg.fastspigot.core.service.instances.ILogger;

public class TestHandler implements ILogger {

    @InjectHandler
    public TestHandler2 handler2;


    public void say() {
        log("ahha");
        handler2.say();
    }
}
