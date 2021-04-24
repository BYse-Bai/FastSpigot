package cn.hyrkg.fastspigot.spigot;

import cn.hyrkg.fastspigot.innercore.FastInnerCore;
import cn.hyrkg.fastspigot.innercore.ICoreCreator;
import cn.hyrkg.fastspigot.innercore.annotation.Inject;
import cn.hyrkg.fastspigot.innercore.framework.HandlerInfo;
import cn.hyrkg.fastspigot.spigot.service.ILoggerService;
import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.annotation.Annotation;

public class FastPlugin extends JavaPlugin implements ICoreCreator, ILoggerService {

    @Getter
    private FastInnerCore innerCore;//主要的核心

    private HandlerInfo thisInfo;

    @Inject
    @Getter
    private DebugHandler debugHandler;

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
        warm("正在加载插件...");
        innerCore.getFunctionInjector().addInspire("ListenerInspire", (j, k) -> {
            if (j instanceof Listener)
                getServer().getPluginManager().registerEvents((Listener) j, this);
        });

        warm("注入处理器中...");
        innerCore.getHandlerInjector().handleInstance(this, FastPlugin.class, thisInfo);
        innerCore.getHandlerInjector().handleInstance(this, getClass(), thisInfo);

        warm("加载完毕! (" + (System.currentTimeMillis() - timeStart) + "ms)");

    }


    @Override
    public void onDisable() {
        long timeStart = System.currentTimeMillis();

        warm("正在卸载处理器...");
        innerCore.disable();
        warm("卸载完毕! (" + (System.currentTimeMillis() - timeStart) + "ms)");
    }

    public FastInnerCore getInnerCore() {
        return innerCore;
    }

    public HandlerInfo getHandlerInfo() {
        return thisInfo;
    }

    public String getPluginName() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean isDebugging(Class info) {
        return debugHandler.isDebugging(info);
    }
}
