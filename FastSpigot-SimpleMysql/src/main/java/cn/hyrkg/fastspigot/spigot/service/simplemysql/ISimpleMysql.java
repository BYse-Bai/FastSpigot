package cn.hyrkg.fastspigot.spigot.service.simplemysql;

import cn.hyrkg.fastspigot.innercore.annotation.ImpService;
import cn.hyrkg.fastspigot.innercore.framework.interfaces.IServiceProvider;
import me.kg.fast.inject.mysql2_2.SimpleMysqlPool;
import me.kg.fast.inject.mysql2_2.UnsafeQuery;

@ImpService(impClass = SimpleMysqlImp.class)
public interface ISimpleMysql extends IServiceProvider {

    default UnsafeQuery mysql(String value) throws Exception {
        return new UnsafeQuery(value, getPool());
    }

    SimpleMysqlPool getPool();

}
