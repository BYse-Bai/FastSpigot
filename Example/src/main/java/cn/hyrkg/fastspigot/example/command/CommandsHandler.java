package cn.hyrkg.fastspigot.example.command;

import cn.hyrkg.fastspigot.core.annotation.InjectHandler;
import cn.hyrkg.fastspigot.core.service.command.Command;
import cn.hyrkg.fastspigot.core.service.command.ICommandExecutor;
import cn.hyrkg.fastspigot.example.command.instances.CommandTest1;
import cn.hyrkg.fastspigot.example.command.instances.CommandTest2;
import org.bukkit.entity.Player;

public class CommandsHandler {
    @InjectHandler
    public CommandTest1 commandTest1;
    @InjectHandler
    public CommandTest2 commandTest2;
}
