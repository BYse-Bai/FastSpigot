package cn.hyrkg.fastspigot.spigotplugin;


import cn.hyrkg.fastspigot.fast.easygui.EasyGuiHandler;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginLoadOrder;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.LoadOrder;
import org.bukkit.plugin.java.annotation.plugin.Plugin;

@Plugin(name = "fastspigot", version = "0.1.0")
@LoadOrder(PluginLoadOrder.STARTUP)
public class PluginFastSpigot extends JavaPlugin {
    @Override
    public void onEnable() {
        EasyGuiHandler.init(this);
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[FASTSPIGOT] SUPPORT ENABLED!");
    }
}
