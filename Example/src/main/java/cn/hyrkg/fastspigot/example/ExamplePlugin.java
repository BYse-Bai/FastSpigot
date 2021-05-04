package cn.hyrkg.fastspigot.example;


import cn.hyrkg.fastspigot.example.cmd.CommandExample;
import cn.hyrkg.fastspigot.example.config.TestConfig;
import cn.hyrkg.fastspigot.innercore.annotation.Inject;
import cn.hyrkg.fastspigot.spigot.FastPlugin;
import org.bukkit.plugin.java.annotation.command.Command;
import org.bukkit.plugin.java.annotation.command.Commands;
import org.bukkit.plugin.java.annotation.dependency.SoftDependency;
import org.bukkit.plugin.java.annotation.dependency.SoftDependsOn;
import org.bukkit.plugin.java.annotation.plugin.Plugin;

@Plugin(name = "ExamplePlugin", version = "1")
@Commands(@Command(name = "example"))
@SoftDependsOn(@SoftDependency("saosamsara"))
public class ExamplePlugin extends FastPlugin {
    @Inject(name = "指令")
    public static CommandExample commandExample;

    @Inject(name = "配置测试")
    public static TestConfig testConfig;

    @Override
    public String getPluginName() {
        return "测试插件";
    }
}
