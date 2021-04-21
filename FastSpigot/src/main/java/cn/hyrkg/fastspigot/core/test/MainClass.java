package cn.hyrkg.fastspigot.core.test;

import cn.hyrkg.fastspigot.asm.ASMHelper;
import cn.hyrkg.fastspigot.core.FastInnerCore;
import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.tree.ClassNode;
import lombok.SneakyThrows;

public class MainClass {
    @SneakyThrows
    public static void main(String[] args) {
        FastInnerCore fastInnerCore = new FastInnerCore();
        fastInnerCore.onEnable();

        fastInnerCore.getAsmInjector().create(TestHandler.class).say();

    }

}
