package sharedmemory;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class MMap {

	private MappedByteBuffer buf = null;

	private FileChannel fc = null;

	private RandomAccessFile file = null;

	public static void main(String[] args) {

	}

	public MMap() {
		this.init();
	}

	private void init() {
		try {

			String filename = "D:\\test\\sx.txt";
			// ���һ��ֻ���������ȡ�ļ�����
			file = new RandomAccessFile(filename, "r");
			// �����Ӧ���ļ�ͨ��
			fc = file.getChannel();
			// ȡ���ļ���ʵ�ʴ�С���Ա�ӳ�񵽹����ڴ�
			long size = fc.size();
			// ��ù����ڴ滺�������ù����ڴ�ֻ��
			buf = fc.map(FileChannel.MapMode.READ_ONLY, 0, size);
			// // ���һ���ɶ�д�������ȡ�ļ�����
			// file = new RandomAccessFile(filename, "rw");
			// // �����Ӧ���ļ�ͨ��
			// fc = file.getChannel();
			// // ȡ���ļ���ʵ�ʴ�С���Ա�ӳ�񵽹����ڴ�
			// size = fc.size();
			// // ��ù����ڴ滺�������ù����ڴ�ɶ�д
			// buf = fc.map(FileChannel.MapMode.READ_WRITE, 0, size);
			// ��ȡͷ����Ϣ����ȡȨ��
			// int mode = buf.getInt();

//			fc.close();
//			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean startWrite() {
		// ��ȡͷ����Ϣ����ȡȨ��
		int mode = buf.getInt();
		if (mode == 0) { // ��־Ϊ0�����ʾ��д
			mode = 1; // �ñ�־Ϊ1����ζ�ű��Ӧ�ò���д�ù����ڴ�
			buf.flip();
			buf.putInt(mode); // д�繲���ڴ��ͷ����Ϣ
			return true;
		} else {
			try {
				/*
				 * ���ִ��д������Ӧ���쳣��ֹ����ôӳ���ļ��Ĺ����ڴ潫������ִ��д������
				 * Ϊ����Ӧ���쳣��ֹ��д������ֹ��־�Զ����������������е�Ӧ�û�֪�˳���Ӧ�á�
				 * �ڶ��߳�Ӧ���У�������ͬ���������������Ч���������ڶ�����У�ͬ���ǲ������õġ�
				 * �������Բ��õĶ��ּ��ɣ�����ֻ������һ���ܵ�ʵ�֣�
				 * �����ļ����ķ�ʽ��д�����ڴ�Ӧ���ڻ�ö�һ�������ڴ�дȨ�޵�ʱ�򣬳����ж�ͷ����Ϣ��дȨ�ޱ�־�⣬
				 * ��Ҫ�ж�һ����ʱ�����ļ��Ƿ���Եõ���������Եõ�����ʹͷ����Ϣ��дȨ�ޱ�־Ϊ1����������Ҳ��������дȨ�ޡ�
				 * ��ʵ���Ѿ�����дȨ�޻�õ�Ӧ���Ѿ��쳣�˳���
				 */
				// ����ļ��Ķ�ռ�����÷������������������̷���
				FileLock flock = fc.tryLock();
				// ���Ϊ�գ�������Ѿ���Ӧ��ռ�и���
				if (flock == null) {
					// ����ִ��д����
					return false;
				} else {
					// ����ִ��д����
					mode = 1; // �ñ�־Ϊ1����ζ�ű��Ӧ�ò���д�ù����ڴ�
					buf.flip();
					buf.putInt(mode); // д�繲���ڴ��ͷ����Ϣ
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false; // ָ���Ѿ���Ӧ����д�ù����ڴ棬��Ӧ�ò���д�ù����ڴ�
		}
	}

	public boolean stopWrite() {
		int mode = buf.getInt();
		mode = 0; // �ͷ�дȨ��
		buf.flip();
		buf.putInt(mode); // д�빲���ڴ�ͷ����Ϣ
		return true;
	}

	public void close() {
		try {
			fc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
