package cn.hyrkg.fastspigot.spigot.service.command;

import cn.hyrkg.fastspigot.innercore.framework.interfaces.IImplementation;
import cn.hyrkg.fastspigot.innercore.framework.HandlerInfo;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FastCommandExecutor implements IImplementation<IFastCommandExecutor>, CommandExecutor {

    private IFastCommandExecutor executorInstance;

    @Override
    public void handleHandler(IFastCommandExecutor executor, HandlerInfo handlerInfo) {
        executorInstance = executor;
        System.out.println("rr1!!");
//        FastPlugin plugin = (FastPlugin) handlerInfo.innerCore.getCreator();
//        plugin.getCommand(executor.getCommand()).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}
