package asm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/**
 * ͨ��asm��������ֽ���
 * 
 * @author Administrator
 * 
 */
public class GeneratorClass {

	public static void main(String[] args) {
		// ����һ����ֻ��ҪClassWriter�������
		ClassWriter cw = new ClassWriter(0);
		// ͨ��visit����ȷ�����ͷ����Ϣ
		cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT
				+ Opcodes.ACC_INTERFACE, "asm/Comparable", null,
				"java/lang/Object", new String[] { "asm/Mesurable" });

		// �����������
		cw.visitField(
				Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC,
				"LESS", "I", null, new Integer(-1)).visitEnd();
		cw.visitField(
				Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC,
				"EQUAL", "I", null, new Integer(0)).visitEnd();
		cw.visitField(
				Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC,
				"GREATER", "I", null, new Integer(1)).visitEnd();
		// ������ķ���
		cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "compareTo",
				"(Ljava/lang/Object;)I", null, null).visitEnd();
		cw.visitEnd(); // ʹcw���Ѿ����
		// ��cwת�����ֽ�����д���ļ�����ȥ
		byte[] data = cw.toByteArray();
		File file = new File("D://test//Comparable.class");
		try {
			FileOutputStream fout = new FileOutputStream(file);
			fout.write(data);
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
