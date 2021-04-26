package cn.hyrkg.fastspigot.example.mysql;

import cn.hyrkg.fastspigot.innercore.annotation.Instance;
import cn.hyrkg.fastspigot.innercore.annotation.events.OnHandlerPostInit;
import cn.hyrkg.fastspigot.simplemysql.service.instances.FastMysqlHandler;
import cn.hyrkg.fastspigot.spigot.service.config.AutoLoad;
import lombok.Getter;
import lombok.SneakyThrows;

import java.sql.ResultSet;

public class MysqlHandler extends FastMysqlHandler {

    @Instance
    private static MysqlHandler instance;

    @AutoLoad
    public String label;

    @OnHandlerPostInit
    @SneakyThrows
    public void onPostInit() {
       ResultSet set= mysql("SELECT * FROM xx;").executeQuery();
    }

    public MysqlHandler() {
        super("test");
    }
}
