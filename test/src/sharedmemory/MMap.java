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
			// 获得一个只读的随机存取文件对象
			file = new RandomAccessFile(filename, "r");
			// 获得相应的文件通道
			fc = file.getChannel();
			// 取得文件的实际大小，以便映像到共享内存
			long size = fc.size();
			// 获得共享内存缓冲区，该共享内存只读
			buf = fc.map(FileChannel.MapMode.READ_ONLY, 0, size);
			// // 获得一个可读写的随机存取文件对象
			// file = new RandomAccessFile(filename, "rw");
			// // 获得相应的文件通道
			// fc = file.getChannel();
			// // 取得文件的实际大小，以便映像到共享内存
			// size = fc.size();
			// // 获得共享内存缓冲区，该共享内存可读写
			// buf = fc.map(FileChannel.MapMode.READ_WRITE, 0, size);
			// 获取头部消息：存取权限
			// int mode = buf.getInt();

//			fc.close();
//			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean startWrite() {
		// 获取头部消息：存取权限
		int mode = buf.getInt();
		if (mode == 0) { // 标志为0，则表示可写
			mode = 1; // 置标志为1，意味着别的应用不可写该共享内存
			buf.flip();
			buf.putInt(mode); // 写如共享内存的头部信息
			return true;
		} else {
			try {
				/*
				 * 如果执行写操作的应用异常中止，那么映像文件的共享内存将不再能执行写操作。
				 * 为了在应用异常中止后，写操作禁止标志自动消除，必须让运行的应用获知退出的应用。
				 * 在多线程应用中，可以用同步方法获得这样的效果，但是在多进程中，同步是不起作用的。
				 * 方法可以采用的多种技巧，这里只是描述一可能的实现：
				 * 采用文件锁的方式。写共享内存应用在获得对一个共享内存写权限的时候，除了判断头部信息的写权限标志外，
				 * 还要判断一个临时的锁文件是否可以得到，如果可以得到，则即使头部信息的写权限标志为1（上述），也可以启动写权限。
				 * 其实这已经表明写权限获得的应用已经异常退出。
				 */
				// 获得文件的独占锁，该方法不产生堵塞，立刻返回
				FileLock flock = fc.tryLock();
				// 如果为空，则表明已经有应用占有该锁
				if (flock == null) {
					// 不能执行写操作
					return false;
				} else {
					// 可以执行写操作
					mode = 1; // 置标志为1，意味着别的应用不可写该共享内存
					buf.flip();
					buf.putInt(mode); // 写如共享内存的头部信息
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false; // 指明已经有应用在写该共享内存，本应用不可写该共享内存
		}
	}

	public boolean stopWrite() {
		int mode = buf.getInt();
		mode = 0; // 释放写权限
		buf.flip();
		buf.putInt(mode); // 写入共享内存头部信息
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
