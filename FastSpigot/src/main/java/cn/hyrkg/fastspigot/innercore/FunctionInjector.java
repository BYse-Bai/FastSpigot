package cn.hyrkg.fastspigot.innercore;

import cn.hyrkg.fastspigot.innercore.annotation.ImpService;
import cn.hyrkg.fastspigot.innercore.framework.HandlerInfo;
import cn.hyrkg.fastspigot.innercore.framework.interfaces.IImplementation;
import cn.hyrkg.fastspigot.innercore.framework.interfaces.IServiceProvider;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 * 该类对处理器进行功能注入
 **/
@RequiredArgsConstructor
public class FunctionInjector {
    public final FastInnerCore innerCore;

    private HashMap<Object, HashMap<Class, Object>> impMap = new HashMap<>();
    private final HashMap<String, BiConsumer<Object, HandlerInfo>> inspireMap = new HashMap<>();

    public void addInspire(String inspireName, BiConsumer<Object, HandlerInfo> biConsumer) {
        this.inspireMap.put(inspireName, biConsumer);
    }

    @SneakyThrows
    public void inspireHandler(Object handler, HandlerInfo handlerInfo) {
        //TODO 查看接口实现，并对接实现
        Class clazz = handlerInfo.originClass;
        for (Class interfaceClazz : clazz.getInterfaces()) {
            if (interfaceClazz.isAnnotationPresent(ImpService.class)) {
                ImpService impService = (ImpService) interfaceClazz.getAnnotation(ImpService.class);
                IImplementation implementation = impService.impClass().newInstance();

                //create implementation
                implementation.handleHandler(handler, handlerInfo);

                //put into map
                if (!impMap.containsKey(handler))
                    impMap.put(handler, new HashMap<>());
                impMap.get(handler).put(interfaceClazz, implementation);
            }
        }
        inspireMap.values().forEach(j -> j.accept(handler, handlerInfo));

    }

    public <T> T getImplementation(Object handler, Class<? extends IServiceProvider> implementationService) {
        if (impMap.containsKey(handler))
            return (T) impMap.get(handler).get(implementationService);
        return null;
    }

}
