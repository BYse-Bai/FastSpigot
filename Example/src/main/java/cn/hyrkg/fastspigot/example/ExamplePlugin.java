package cn.hyrkg.fastspigot.example;

import cn.hyrkg.fastspigot.core.FastPlugin;
import cn.hyrkg.fastspigot.core.annotation.InjectHandler;
import cn.hyrkg.fastspigot.example.command.CommandsHandler;

public class ExamplePlugin extends FastPlugin {
    @InjectHandler
    public CommandsHandler commands;
}
