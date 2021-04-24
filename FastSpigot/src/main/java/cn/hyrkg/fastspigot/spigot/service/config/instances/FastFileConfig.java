package cn.hyrkg.fastspigot.spigot.service.config.instances;

import cn.hyrkg.fastspigot.innercore.annotation.events.OnHandlerInit;
import cn.hyrkg.fastspigot.spigot.service.config.IFastYamlConfig;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public abstract class FastFileConfig implements IFastYamlConfig {

    private File file;

    @OnHandlerInit
    public void onFastPluginConfigInit() {
        file = getFile();

    }

    public abstract File getFile();

    @Override
    public ConfigurationSection getConfigSection() {
        return YamlConfiguration.loadConfiguration(file);
    }
}
