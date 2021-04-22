package cn.hyrkg.fastspigot.spigot.service.command;

import cn.hyrkg.fastspigot.innercore.framework.interfaces.IImplementation;
import cn.hyrkg.fastspigot.innercore.framework.HandlerInfo;

import cn.hyrkg.fastspigot.spigot.FastPlugin;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.lang.reflect.Method;

public class FastCommandExecutor implements IImplementation<IFastCommandExecutor>, CommandExecutor {

    private Multimap<String, CommandMethod> commandInfoMultimap = ArrayListMultimap.create();

    @Override
    public void handleHandler(IFastCommandExecutor executor, HandlerInfo handlerInfo) {
        if (handlerInfo.innerCore.getCreator() instanceof FastPlugin) {
            FastPlugin plugin = (FastPlugin) handlerInfo.innerCore.getCreator();
            plugin.getCommand(executor.getCommand()).setExecutor(this);

            //todo parser commands
            parserCommands(executor, handlerInfo);
        }
    }

    private void parserCommands(IFastCommandExecutor executor, HandlerInfo handlerInfo) {
        for (Method method : executor.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(FastCommand.class)) {
                //is command!
                FastCommand command = method.getAnnotation(FastCommand.class);
                CommandMethod commandInfo = new CommandMethod(command).readMethod(method);
                if (commandInfo == null) {
                    executor.getInnerCore().getCreator().error(executor.getClass() + " error when load command method" + method.getName() + " : wrong parameters");
                    continue;
                }

                commandInfoMultimap.put(command.index(), commandInfo);
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}
