package cn.hyrkg.fastspigot.example;


import cn.hyrkg.fastspigot.example.player.PlayerHandler;
import cn.hyrkg.fastspigot.innercore.annotation.Inject;
import cn.hyrkg.fastspigot.spigot.FastPlugin;
import org.bukkit.plugin.java.annotation.plugin.Plugin;

@Plugin(name = "ExamplePlugin", version = "1")
public class ExamplePlugin extends FastPlugin {
    @Inject
    public static PlayerHandler playerHandler;
    @Inject
    public static PlayerHandler playerHandler2;
    @Inject
    public static PlayerHandler playerHandler3;
    @Inject
    public static PlayerHandler playerHandler4;
    @Inject
    public static PlayerHandler playerHandler5;
    @Inject
    public static PlayerHandler playerHandler6;
}
