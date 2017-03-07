package asm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class Generator {

	public static void main(String[] args) {
		try {
			ClassReader cr = new ClassReader("asm/C");
			ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
			ClassAdapter classAdapter = new AddTimeClassAdapter(cw);
			// ʹ�����ķ����߷���Java���ClassReader
			cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
			byte[] data = cw.toByteArray();
			File file = new File(System.getProperty("user.dir")
					+ "\\bin\\asm\\C.class");
			FileOutputStream fout = new FileOutputStream(file);
			fout.write(data);
			fout.close();
			System.out.println("success!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
