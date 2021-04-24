package cn.hyrkg.fastspigot.spigot;

import cn.hyrkg.fastspigot.innercore.FastInnerCore;
import cn.hyrkg.fastspigot.innercore.annotation.Inject;
import cn.hyrkg.fastspigot.innercore.framework.HandlerInfo;
import cn.hyrkg.fastspigot.spigot.service.ILoggerService;
import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.annotation.Annotation;

public abstract class FastPlugin extends JavaPlugin implements ILoggerService {

    @Getter
    private FastInnerCore innerCore;//主要的核心

    private HandlerInfo thisInfo;

    @Override
    public void onEnable() {
        //pre init
        thisInfo = new HandlerInfo(new Inject() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return Inject.class;
            }

            @Override
            public String name() {
                return getPluginName();
            }
        }, innerCore, null, getClass(), getClass(), this);
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

//    @Override
//    public void onDisable() {
//        innerCore.onDisable();
//    }

    public FastInnerCore getInnerCore() {
        return innerCore;
    }

    @Override
    public HandlerInfo getHandlerInfo() {
        return thisInfo;
    }

    public String getPluginName() {
        return getClass().getSimpleName();
    }
}
