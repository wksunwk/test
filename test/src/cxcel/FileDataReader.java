/**
 * @Date: Jan 5, 2009 - 8:56:00 PM
 */
package cxcel;

import java.util.Set;


/**
 * 对文件的读取器抽象基类
 * @author Cris YANG
 *
 */
abstract public class FileDataReader implements DataReader {
	/**
	 * 欲读取的源文件路径
	 * @author Cris YANG
	 */
	protected String srcFilepath;
	
	/**
	 * 缺省初始化函数
	 * @author Cris YANG
	 * @param srcFilepath	欲读取的源文件路径
	 */
	public FileDataReader(String srcFilepath)
	{
		this.srcFilepath = srcFilepath;
	}
	

	/* (non-Javadoc)
	 * @see stat2.common.filesystem.reader.DataReader#next()
	 */
	abstract public boolean next();
	/* (non-Javadoc)
	 * @see stat2.common.filesystem.reader.DataReader#readLine()
	 */
	abstract public String[] readLine();

	/* (non-Javadoc)
	 * @see stat2.common.filesystem.reader.DataReader#readLine(java.util.Set)
	 */
	abstract public boolean readLine(Set dataSet);
	
	/* (non-Javadoc)
	 * @see stat2.common.filesystem.reader.DataReader#close()
	 */
	abstract public boolean close();
}
