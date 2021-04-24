package cn.hyrkg.fastspigot.spigot.service.config.instances;

import cn.hyrkg.fastspigot.innercore.annotation.events.OnHandlerInit;
import cn.hyrkg.fastspigot.spigot.service.IPluginProvider;
import cn.hyrkg.fastspigot.spigot.service.config.IFastYamlConfig;
import lombok.Getter;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class FastPluginConfig implements IFastYamlConfig, IPluginProvider {

    @Getter
    private JavaPlugin plugin;

    @OnHandlerInit
    public void onFastPluginConfigInit() {
        this.plugin = getJavaPlugin();
        plugin.saveDefaultConfig();
    }


    @Override
    public void reload() {
        plugin.reloadConfig();
        IFastYamlConfig.super.reload();
    }

    @Override
    public ConfigurationSection getConfigSection() {
        return plugin.getConfig();
    }
}
