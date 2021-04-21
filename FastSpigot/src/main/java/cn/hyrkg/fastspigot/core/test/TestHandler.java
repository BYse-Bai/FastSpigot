package cn.hyrkg.fastspigot.core.test;

import cn.hyrkg.fastspigot.core.service.instances.ILogger;

public class TestHandler implements ILogger {
    public void say() {
        log("ahha");
    }
}
