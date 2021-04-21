package cn.hyrkg.fastspigot.core;

import cn.hyrkg.fastspigot.core.utils.ResourceHelper;
import cn.hyrkg.fastspigot.core.utils.ByteClassLoader;
import jdk.internal.org.objectweb.asm.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.HashMap;

@RequiredArgsConstructor
public class AsmInjector {
    public final FastInnerCore innerCore;

    private HashMap<Class<?>, Class<?>> injectedClass = new HashMap<>();

    @SneakyThrows
    public <T> Class<T> inject(Class<T> clazz) {
        String urlPath = ResourceHelper.getPathAsUrl(clazz);
        String tag = "$inject";
        String tagPath = urlPath + tag;
        String clazzName = clazz.getSimpleName();
        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(52, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, tagPath, null, urlPath, null);

        cw.visitSource(clazzName + tag + ".java", null);

        {
            fv = cw.visitField(Opcodes.ACC_PRIVATE, "$innerCore", "Lcn/hyrkg/fastspigot/core/FastInnerCore;", null, null);
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(5, l0);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, urlPath, "<init>", "()V", false);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(6, l1);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitInsn(Opcodes.ACONST_NULL);
            mv.visitFieldInsn(Opcodes.PUTFIELD, tagPath, "$innerCore", "Lcn/hyrkg/fastspigot/core/FastInnerCore;");
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLineNumber(5, l2);
            mv.visitInsn(Opcodes.RETURN);
            Label l3 = new Label();
            mv.visitLabel(l3);
            mv.visitLocalVariable("this", "L" + tagPath + ";", null, l0, l3, 0);
            mv.visitMaxs(2, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "getInnerCore", "()Lcn/hyrkg/fastspigot/core/FastInnerCore;", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(10, l0);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitFieldInsn(Opcodes.GETFIELD, tagPath, "$innerCore", "Lcn/hyrkg/fastspigot/core/FastInnerCore;");
            mv.visitInsn(Opcodes.ARETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "L" + tagPath + ";", null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        cw.visitEnd();
        Class<T> injectedClazz = (Class<T>) ByteClassLoader.defineClass(cw.toByteArray());

        injectedClass.put(clazz, injectedClazz);
        return injectedClazz;
    }

    @SneakyThrows
    public <T> T create(Class<T> clazz) {
        T obj = null;

        if (findInjected(clazz) != null)
            obj = (T) findInjected(clazz).newInstance();
        else
            obj = (T) inject(clazz).newInstance();

        Field field = obj.getClass().getDeclaredField("$innerCore");
        field.setAccessible(true);
        field.set(obj, innerCore);
        return obj;
    }

    public <T> Class<T> findInjected(Class<T> originClass) {
        return (Class<T>) injectedClass.get(originClass);
    }


}
