package cn.hyrkg.fastspigot.spigot.service.config.instances;

import cn.hyrkg.fastspigot.innercore.annotation.events.OnHandlerInit;
import cn.hyrkg.fastspigot.spigot.service.IPluginProvider;
import cn.hyrkg.fastspigot.spigot.service.config.IFastYamlConfig;
import org.bukkit.configuration.ConfigurationSection;

public abstract class FastPluginConfig implements IFastYamlConfig, IPluginProvider {


    @OnHandlerInit
    public void onFastPluginConfigInit() {
        getPlugin().saveDefaultConfig();
    }


    @Override
    public void reload() {
        getPlugin().reloadConfig();
        IFastYamlConfig.super.reload();
    }

    @Override
    public ConfigurationSection getConfigSection() {
        return getPlugin().getConfig();
    }
}
