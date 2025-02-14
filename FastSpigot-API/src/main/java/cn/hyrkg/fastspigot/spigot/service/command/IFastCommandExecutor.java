package cn.hyrkg.fastspigot.spigot.service.command;

import cn.hyrkg.fastspigot.innercore.annotation.ImpService;
import cn.hyrkg.fastspigot.innercore.framework.interfaces.IServiceProvider;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@ImpService(impClass = FastCommandImp.class)
public interface IFastCommandExecutor extends IServiceProvider {


    String[] getCommands();

    default String getCmdDescription() {
        return getCommands()[0];
    }

    default void handleException(Exception e) {
        e.printStackTrace();
    }

    default boolean isOp(CommandSender sender) {
        return sender.isOp();
    }

    default Player checkPlayer(String playerName) {
        Player player = Bukkit.getPlayer(playerName);
        if (player == null)
            ((FastCommandImp) getImplementation(IFastCommandExecutor.class)).throwError(null, playerName + "不在线!");
        return player;
    }


}
