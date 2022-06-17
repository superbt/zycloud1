package ms.asm;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.FieldVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.io.IOException;

import static jdk.internal.org.objectweb.asm.Opcodes.ASM4;

public class ClassPrinter extends ClassVisitor {
    public ClassPrinter() {
        super(ASM4);

    }
    public ClassPrinter(int i) {
        super(i);
    }

    public ClassPrinter(int i, ClassVisitor classVisitor) {
        super(i, classVisitor);
    }

    @Override
    public void visit(int i, int i1, String s, String s1, String s2, String[] strings) {
        System.out.println(s+" extends "+s2+" {");
    }

    @Override
    public FieldVisitor visitField(int i, String s, String s1, String s2, Object o) {
        System.out.println(" "+s);
        return null;
    }

    @Override
    public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
        System.out.println(" "+s+" ()");
        return null ;
    }

    @Override
    public void visitEnd() {
        System.out.println(" }");
    }

    public static void main(String[] args) {
        ClassPrinter printer = new ClassPrinter();
        try {
            ClassReader reader = new ClassReader("java.lang.Runnable");
            reader.accept(printer,0);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
