package cn.hyrkg.fastspigot.test;

import cn.hyrkg.fastspigot.innercore.annotation.events.OnHandlerEnable;
import cn.hyrkg.fastspigot.spigot.service.ILogger;
import cn.hyrkg.fastspigot.spigot.service.command.FastCommandExecutor;
import cn.hyrkg.fastspigot.spigot.service.command.IFastCommandExecutor;

public class TestHandler implements ILogger, IFastCommandExecutor {
    @OnHandlerEnable
    public void onEnable() {

    }

    public void say() {
        FastCommandExecutor fastCommandExecutor = getImplementation(IFastCommandExecutor.class);
        System.out.println(fastCommandExecutor + "!!");
    }

    @Override
    public String getCommand() {
        return "test";
    }
}
