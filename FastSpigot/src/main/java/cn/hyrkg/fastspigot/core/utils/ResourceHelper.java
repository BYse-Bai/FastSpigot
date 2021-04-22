package cn.hyrkg.fastspigot.core.utils;

public class ResourceHelper {

    public static String getPathAsUrl(Class<?> clazz) {
        return getPath(clazz).replaceAll("\\.", "\\/");
    }

    public static String getPath(Class<?> clazz) {
        String path = clazz.getPackage().getName() + "." + clazz.getSimpleName();
        return path;
    }
}
