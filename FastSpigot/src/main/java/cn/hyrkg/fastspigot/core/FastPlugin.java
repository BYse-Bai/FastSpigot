package cn.hyrkg.fastspigot.core;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class FastPlugin extends JavaPlugin {

    @Getter
    private FastInnerCore innerCore;//主要的核心

    @Override
    public final void onEnable() {
    }

    @Override
    public final void onDisable() {
    }
}
