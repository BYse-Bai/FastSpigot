package cn.hyrkg.fastspigot.spigot.service;

import cn.hyrkg.fastspigot.innercore.framework.HandlerInfo;
import cn.hyrkg.fastspigot.innercore.framework.interfaces.IServiceProvider;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public interface ILoggerService extends IServiceProvider, ILogger {
    default void info(String str) {
        String combine = locatePath();

        Object creator = getInnerCore().getCreatorAsLogger();
        if (creator instanceof Plugin) {
            ((Plugin) creator).getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "(INFO)" + combine + ": " + str);
        } else {
            System.out.println(combine + ": " + str);
        }
    }

    default void warm(String str) {

        String combine = locatePath();

        Object creator = getInnerCore().getCreatorAsLogger();
        if (creator instanceof Plugin) {
            ((Plugin) creator).getServer().getConsoleSender().sendMessage(ChatColor.COLOR_CHAR + "6" + "(WARM)" + combine + ": " + str);
        } else {
            System.out.println(combine + ": " + str);
        }
    }

    default void error(String str) {
        String combine = locatePath();

        Object creator = getInnerCore().getCreatorAsLogger();
        if (creator instanceof Plugin) {
            ((Plugin) creator).getServer().getConsoleSender().sendMessage(ChatColor.COLOR_CHAR + "c" + ChatColor.COLOR_CHAR + "l" + "(ERROR)" + combine + ": " + str);
        } else {
            System.out.println(combine + ": " + str);
        }
    }

    default void debug(String str) {
        if (getInnerCore().isDebugging(getClass()))
            error(str);
    }

    default String locatePath() {
        HandlerInfo info = getHandlerInfo();
        String combine = (info.injectInfo.name().isEmpty() ? info.originClass.getSimpleName() : info.injectInfo.name());
        HandlerInfo head = info;
        while (head.parentInfo != null) {
            head = head.parentInfo;
            combine = (head.injectInfo.name().isEmpty() ? head.originClass.getSimpleName() : head.injectInfo.name()) + ">" + combine;
        }
        return combine;
    }
}
