package cn.hyrkg.fastspigot.spigot.service.config;

import cn.hyrkg.fastspigot.innercore.annotation.ImpService;
import cn.hyrkg.fastspigot.innercore.framework.interfaces.IServiceProvider;
import cn.hyrkg.fastspigot.spigot.service.ILoggerService;
import org.bukkit.configuration.ConfigurationSection;

@ImpService(impClass = FastConfigImp.class)
public interface IFastYamlConfig extends IServiceProvider, ILoggerService {
    default void reload() {
        ((FastConfigImp) getImplementation(IFastYamlConfig.class)).reload();
    }

    ConfigurationSection getConfigSection();


}
