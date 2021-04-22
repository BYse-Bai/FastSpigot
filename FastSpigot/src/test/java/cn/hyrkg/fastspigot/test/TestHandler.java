package cn.hyrkg.fastspigot.test;

import cn.hyrkg.fastspigot.innercore.annotation.events.OnHandlerEnable;
import cn.hyrkg.fastspigot.spigot.service.ILoggerService;
import cn.hyrkg.fastspigot.spigot.service.command.FastCommandExecutor;
import cn.hyrkg.fastspigot.spigot.service.command.IFastCommandExecutor;

public class TestHandler implements ILoggerService, IFastCommandExecutor {

    public void say() {
        FastCommandExecutor fastCommandExecutor = getImplementation(IFastCommandExecutor.class);
        System.out.println(fastCommandExecutor + "!!");
    }

    @Override
    public String getCommand() {
        return "test";
    }
}
