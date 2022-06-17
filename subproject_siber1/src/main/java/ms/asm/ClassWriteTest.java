package ms.asm;

import jdk.internal.org.objectweb.asm.ClassWriter;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class ClassWriteTest {

    public static void main(String[] args) {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_5,ACC_PUBLIC+ACC_ABSTRACT+ACC_INTERFACE,"pkg/Comparable",null,"java/lang/object",null);
        cw.visitField(ACC_PUBLIC+ACC_FINAL+ACC_STATIC,"LESS","I",null,-1).visitEnd();
        cw.visitMethod(ACC_PUBLIC+ACC_ABSTRACT,"compareTo","(Ljava/lang/Object;)I",null,null).visitEnd();
        cw.visitEnd();
        byte[] b = cw.toByteArray();

    }
}
