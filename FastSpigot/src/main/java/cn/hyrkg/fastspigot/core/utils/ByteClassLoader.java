package cn.hyrkg.fastspigot.core.utils;

public class ByteClassLoader extends ClassLoader {


    public static Class<?> defineClass(byte[] code) {
        return new ByteClassLoader().defineClass(null, code, 0, code.length);
    }

}