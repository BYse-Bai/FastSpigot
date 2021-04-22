package cn.hyrkg.fastspigot.spigot.service.command;

import cn.hyrkg.fastspigot.innercore.annotation.ImpService;
import cn.hyrkg.fastspigot.innercore.framework.interfaces.IServiceProvider;
import org.bukkit.entity.Player;

@ImpService(impClass = FastCommandExecutor.class)
public interface IFastCommandExecutor extends IServiceProvider {

    String getCommand();

    default boolean isOp(Player player) {
        return player.isOp();
    }

}
