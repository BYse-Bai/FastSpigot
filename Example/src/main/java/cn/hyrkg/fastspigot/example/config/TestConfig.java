package cn.hyrkg.fastspigot.example.config;

import cn.hyrkg.fastspigot.innercore.annotation.events.OnHandlerInit;
import cn.hyrkg.fastspigot.innercore.annotation.events.OnHandlerPostInit;
import cn.hyrkg.fastspigot.spigot.service.config.AutoLoad;
import cn.hyrkg.fastspigot.spigot.service.config.instances.FastPluginConfig;

public class TestConfig extends FastPluginConfig {
    @AutoLoad
    public static String test;

    @OnHandlerPostInit
    public void onPostInit() {
        info("测试 " + test);
    }
}
