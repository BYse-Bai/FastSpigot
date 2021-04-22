package cn.hyrkg.fastspigot.spigot;

import cn.hyrkg.fastspigot.innercore.FastInnerCore;
import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Plugin;

public class FastPlugin extends JavaPlugin {

    @Getter
    private FastInnerCore innerCore;//主要的核心

    @Override
    public final void onEnable() {
        innerCore = new FastInnerCore(this);

        innerCore.getFunctionInjector().addInspire("ListenerInspire", (j, k) -> {
            if (j instanceof Listener)
                getServer().getPluginManager().registerEvents((Listener) j, this);
        });

        innerCore.getHandlerInjector().handleInstance(this, getClass());
    }

    @Override
    public final void onDisable() {
        innerCore.onDisable();
    }
}
