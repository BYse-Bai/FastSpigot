package cn.hyrkg.fastspigot.spigot.service.simplemysql;

import cn.hyrkg.fastspigot.innercore.annotation.ImpService;
import cn.hyrkg.fastspigot.innercore.framework.interfaces.IServiceProvider;
import me.kg.fast.inject.mysql3.SimpleMysqlPool;
import me.kg.fast.inject.mysql3.UnsafeQuery;

public interface ISimpleMysql extends IServiceProvider {

    default UnsafeQuery mysql(String value) throws Exception {
        return new UnsafeQuery(value, getPool());
    }

    SimpleMysqlPool getPool();

}
