package cn.hyrkg.fastspigot.core;

import cn.hyrkg.fastspigot.core.annotation.InjectHandler;
import cn.hyrkg.fastspigot.core.framework.handler.HandlerInfo;
import cn.hyrkg.fastspigot.core.utils.ReflectHelper;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
public class HandlerInjector {
    public final FastInnerCore innerCore;

    private static HashMap<Class, HandlerInfo> handlerInfoHashMap = new HashMap<>();

    public HandlerInfo getHandlerInfo(Class handlerClass) {
        return handlerInfoHashMap.get(handlerClass);
    }


    public void handleInstance(Object instance) {
        handleInstance(instance, instance.getClass(), null);
    }


    public void handleInstance(Object instance, Class rawClass, HandlerInfo parentInfo) {

        List<Field> fieldList = ReflectHelper.findFieldIsAnnotated(rawClass, InjectHandler.class);

        for (Field field : fieldList) {
            try {
                if (field.getType() == rawClass) {
                    innerCore.warm(rawClass.getName() + ">" + field.getName() + " is same handler!");
                    continue;
                }

                field.setAccessible(true);
                //TODO read handler
//                InjectHandler injectHandler = field.getAnnotation(InjectHandler.class);

                Object handler = innerCore.getAsmInjector().create(field.getType());

                field.set(instance, handler);

                HandlerInfo info = new HandlerInfo(parentInfo, field.getType(), handler.getClass(), handler);
                handlerInfoHashMap.put(handler.getClass(), info);
                if (parentInfo != null)
                    parentInfo.addChildInfo(info);

                handleInstance(handler, field.getType(), info);
            } catch (Exception exception) {
                exception.printStackTrace();

            }
        }
    }
}
