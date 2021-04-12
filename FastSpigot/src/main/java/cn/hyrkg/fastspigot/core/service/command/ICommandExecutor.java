package cn.hyrkg.fastspigot.core.service.command;

import cn.hyrkg.fastspigot.core.service.IServiceProvider;

public interface ICommandExecutor extends IServiceProvider {
    String getCommandTable();
}
