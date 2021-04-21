package cn.hyrkg.fastspigot.asm;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.tree.ClassNode;
import jdk.internal.org.objectweb.asm.tree.MethodNode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class FastASM {
    @Getter
    private final ClassReader classReader;

    private ClassNode classNode;


    public MethodNode findMethod(String name) {
        for (MethodNode node : classNode.methods) {
            if (node.name.equalsIgnoreCase(name))
                return node;
        }
        return null;
    }

    public List<MethodNode> findMethods(String name) {
        ArrayList<MethodNode> methodNodes = new ArrayList<>();
        for (MethodNode node : classNode.methods) {
            if (node.name.equalsIgnoreCase(name))
                methodNodes.add(node);
        }
        return methodNodes;
    }

    public boolean deleteMethods(String name) {
        List<MethodNode> nodes = findMethods(name);
        if (nodes.isEmpty())
            return false;
        nodes.forEach(j -> classNode.methods.remove(j));
        return true;
    }


    public FastASM cast() throws FileNotFoundException, IOException {
        classNode = new ClassNode();
        classReader.accept(classNode, 0);
        return this;
    }

    public FastASM writeToFile(File target) throws IOException {
        ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_FRAMES);
        classNode.accept(classWriter);

        FileOutputStream out = new FileOutputStream(target);
        out.write(classWriter.toByteArray());
        out.close();
        return this;
    }

    public byte[] writeAsBytes() {
        ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_FRAMES);
        classNode.accept(classWriter);
        return classWriter.toByteArray();
    }

    public ClassNode getNode() {
        return classNode;
    }

    @SneakyThrows
    public static FastASM ofFile(File file) throws FileNotFoundException {
        ClassReader classReader = new ClassReader(new FileInputStream(file));
        return new FastASM(classReader).cast();
    }

    @SneakyThrows
    public static FastASM ofPath(String path) throws FileNotFoundException {
        ClassReader classReader = new ClassReader(path);
        return new FastASM(classReader).cast();
    }

}
