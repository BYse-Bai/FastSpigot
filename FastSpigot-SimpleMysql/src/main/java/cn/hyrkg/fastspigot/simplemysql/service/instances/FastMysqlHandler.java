package cn.hyrkg.fastspigot.simplemysql.service.instances;

import cn.hyrkg.fastspigot.innercore.annotation.events.OnHandlerInit;
import cn.hyrkg.fastspigot.simplemysql.service.ISimpleMysql;
import cn.hyrkg.fastspigot.spigot.service.IPluginProvider;
import cn.hyrkg.fastspigot.spigot.service.config.FastConfigImp;
import cn.hyrkg.fastspigot.spigot.service.config.IFastYamlConfig;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import me.kg.fast.inject.mysql2_2.SimpleMysqlPool;
import me.kg.fast.inject.mysql2_2.UnsafeQuery;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

@RequiredArgsConstructor
public abstract class FastMysqlHandler implements ISimpleMysql, IFastYamlConfig, IPluginProvider {

    public final String poolName;

    private ConfigurationSection configurationSection;
    @Getter
    protected SimpleMysqlPool pool;

    @OnHandlerInit
    @SneakyThrows
    public void onInit() {
        if (!getPlugin().getDataFolder().exists())
            getPlugin().getDataFolder().mkdirs();

        File file = new File(getPlugin().getDataFolder(), "mysql.yml");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        if (!cfg.contains(getMysqlPoolName())) {
            configurationSection = cfg.createSection(getMysqlPoolName());
            configurationSection.set("url", "localhost:3306/yourDatabase");
            configurationSection.set("user", "root");
            configurationSection.set("pwd", "");
            configurationSection.set("label", "defaultLabel");
            cfg.save(file);
        }
        configurationSection = cfg.getConfigurationSection(getMysqlPoolName());

        if (pool != null)
            pool.closePool();
        pool = SimpleMysqlPool.init(10, configurationSection.getString("url"), configurationSection.getString("user"), configurationSection.getString("pwd"));
    }

    public String getMysqlPoolName() {
        return poolName;
    }

    @Override
    public ConfigurationSection getConfigSection() {
        return configurationSection;
    }

    public void reload() {
        onInit();
        ((FastConfigImp) getImplementation(IFastYamlConfig.class)).reload();
    }


    @Override
    public SimpleMysqlPool getPool() {
        return pool;
    }
}
