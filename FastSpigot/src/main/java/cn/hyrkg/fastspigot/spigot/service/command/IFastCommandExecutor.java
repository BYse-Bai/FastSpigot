package cn.hyrkg.fastspigot.spigot.service.command;

import cn.hyrkg.fastspigot.innercore.annotation.ImpService;
import cn.hyrkg.fastspigot.innercore.framework.interfaces.IServiceProvider;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@ImpService(impClass = FastCommandExecutor.class)
public interface IFastCommandExecutor extends IServiceProvider {


    String getCommand();

    default String getCmdDescription() {
        return getCommand();
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
            ((FastCommandExecutor) getImplementation(IFastCommandExecutor.class)).throwError(null, playerName + "不在线!");
        return player;
    }
    

}
