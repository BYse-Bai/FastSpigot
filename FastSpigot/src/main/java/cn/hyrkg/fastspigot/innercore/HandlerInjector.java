package cn.hyrkg.fastspigot.innercore;

import cn.hyrkg.fastspigot.innercore.annotation.Inject;
import cn.hyrkg.fastspigot.innercore.annotation.events.OnHandlerEnable;
import cn.hyrkg.fastspigot.innercore.framework.HandlerInfo;
import cn.hyrkg.fastspigot.innercore.utils.ReflectHelper;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
/**
 * 该类对处理器声明的变量进行注入处理
 * */
public class HandlerInjector {
    public final FastInnerCore innerCore;

    private static ArrayList<Object> handlers = new ArrayList<>();
    private static HashMap<Class, HandlerInfo> handlerInfoHashMap = new HashMap<>();

    public HandlerInfo getHandlerInfo(Class handlerClass) {
        return handlerInfoHashMap.get(handlerClass);
    }


    /**
     * 处理实例
     **/
    public void handleInstance(Object instance, Class rawClass) {
        handleInstance(instance, rawClass, null);
    }

    /**
     * 处理实例，并对包含InjectHandler标签的变量进行动态注入
     **/
    public void handleInstance(Object instance, Class rawClass, HandlerInfo parentInfo) {

        List<Field> fieldList = ReflectHelper.findFieldIsAnnotated(rawClass, Inject.class);

        for (Field field : fieldList) {
            try {
                if (field.getType() == rawClass) {
                    innerCore.getCreatorAsLogger().warm(rawClass.getName() + ">" + field.getName() + " is same handler!");
                    continue;
                }

                field.setAccessible(true);
                //TODO read handler
//                InjectHandler injectHandler = field.getAnnotation(InjectHandler.class);

                Object handler = innerCore.getAsmInjector().createWithInjection(field.getType());

                field.set(instance, handler);

                HandlerInfo info = new HandlerInfo(innerCore, parentInfo, field.getType(), handler.getClass(), handler);
                handlerInfoHashMap.put(handler.getClass(), info);
                if (parentInfo != null)
                    parentInfo.addChildInfo(info);

                handlers.add(handler);
                handleInstance(handler, field.getType(), info);
                innerCore.getFunctionInjector().inspireHandler(handler, info);
                ReflectHelper.findAndInvokeMethodIsAnnotated(field.getType(), handler, OnHandlerEnable.class);
            } catch (Exception exception) {
                exception.printStackTrace();

            }
        }
    }

    public void onDisable() {
        handlers.forEach(j -> {
            ReflectHelper.findAndInvokeMethodIsAnnotated(getHandlerInfo(j.getClass()).originClass, j, OnHandlerEnable.class);
        });
    }
}
