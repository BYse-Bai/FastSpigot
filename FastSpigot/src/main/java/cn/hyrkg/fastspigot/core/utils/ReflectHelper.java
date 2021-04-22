package cn.hyrkg.fastspigot.core.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectHelper {
    public static List<Field> findFieldIsAnnotated(Class clazz, Class<? extends Annotation> annotation) {
        ArrayList<Field> fields = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(annotation))
                fields.add(field);
        }
        return fields;
    }
}
