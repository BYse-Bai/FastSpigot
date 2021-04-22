package cn.hyrkg.fastspigot.test;

import cn.hyrkg.fastspigot.spigot.service.command.FastCommand;
import cn.hyrkg.fastspigot.spigot.service.command.IFastCommandExecutor;
import com.google.common.collect.Multimap;

public class CmdExample implements IFastCommandExecutor {

    @FastCommand()
    public void onCmd() {

    }

    @Override
    public String getCommand() {
        return "example";
    }
}
