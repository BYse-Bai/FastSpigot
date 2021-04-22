package cn.hyrkg.fastspigot.example.player;

import cn.hyrkg.fastspigot.innercore.annotation.events.OnHandlerEnable;
import cn.hyrkg.fastspigot.spigot.service.ILoggerService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerHandler implements Listener, ILoggerService {


    @OnHandlerEnable
    public void onEnable() {
        info("my info!"+this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("你加入了!");
    }
}
