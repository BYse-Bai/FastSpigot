package cn.hyrkg.fastspigot.spigot;

import cn.hyrkg.fastspigot.innercore.FastInnerCore;
import cn.hyrkg.fastspigot.innercore.framework.HandlerInfo;
import cn.hyrkg.fastspigot.spigot.service.ILogger;
import cn.hyrkg.fastspigot.spigot.service.ILoggerService;
import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class FastPlugin extends JavaPlugin implements ILoggerService {

    @Getter
    private FastInnerCore innerCore;//主要的核心

    private HandlerInfo thisInfo;

    @Override
    public void onEnable() {
        //pre init
        thisInfo = new HandlerInfo(innerCore, null, getClass(), getClass(), this);
        innerCore = new FastInnerCore(this);

        //init
        long timeStart = System.currentTimeMillis();
        warm("Loading plugin " + getClass().getSimpleName() + "...");
        innerCore.getFunctionInjector().addInspire("ListenerInspire", (j, k) -> {
            if (j instanceof Listener)
                getServer().getPluginManager().registerEvents((Listener) j, this);
        });

        warm("Injecting handlers...");
        innerCore.getHandlerInjector().handleInstance(this, getClass(), thisInfo);

        warm("" + getClass().getSimpleName() + " loading completed! (" + (System.currentTimeMillis() - timeStart) + "ms)");

    }

    @Override
    public void onDisable() {
        innerCore.onDisable();
    }

    public FastInnerCore getInnerCore() {
        return innerCore;
    }

    @Override
    public HandlerInfo getHandlerInfo() {
        return thisInfo;
    }
}
