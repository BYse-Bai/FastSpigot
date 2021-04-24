package cn.hyrkg.fastspigot.example;


import cn.hyrkg.fastspigot.example.cmd.CommandExample;
import cn.hyrkg.fastspigot.innercore.annotation.Inject;
import cn.hyrkg.fastspigot.spigot.FastPlugin;
import org.bukkit.plugin.java.annotation.command.Command;
import org.bukkit.plugin.java.annotation.command.Commands;
import org.bukkit.plugin.java.annotation.plugin.Plugin;

@Plugin(name = "ExamplePlugin", version = "1")
@Commands(@Command(name = "example"))
public class ExamplePlugin extends FastPlugin {
    @Inject
    public static CommandExample commandExample;
}
