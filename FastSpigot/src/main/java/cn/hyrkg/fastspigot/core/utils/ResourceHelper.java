package cn.hyrkg.fastspigot.core.utils;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.tree.ClassNode;

public class ResourceHelper {

    public static String getPathAsUrl(Class<?> clazz) {
        return getPath(clazz).replaceAll("\\.", "\\/");
    }

    public static String getPath(Class<?> clazz) {
        String path = clazz.getPackage().getName() + "." + clazz.getSimpleName();
        return path;
    }
}
