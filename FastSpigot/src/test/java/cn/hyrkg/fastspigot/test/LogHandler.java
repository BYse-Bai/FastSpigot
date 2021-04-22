package cn.hyrkg.fastspigot.test;

import cn.hyrkg.fastspigot.innercore.annotation.Inject;
import cn.hyrkg.fastspigot.innercore.annotation.events.OnHandlerEnable;
import cn.hyrkg.fastspigot.spigot.service.ILoggerService;

public class LogHandler {

    @Inject
    TestHandler testHandler;
}
