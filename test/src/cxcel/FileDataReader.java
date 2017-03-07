/**
 * @Date: Jan 5, 2009 - 8:56:00 PM
 */
package cxcel;

import java.util.Set;


/**
 * ���ļ��Ķ�ȡ���������
 * @author Cris YANG
 *
 */
abstract public class FileDataReader implements DataReader {
	/**
	 * ����ȡ��Դ�ļ�·��
	 * @author Cris YANG
	 */
	protected String srcFilepath;
	
	/**
	 * ȱʡ��ʼ������
	 * @author Cris YANG
	 * @param srcFilepath	����ȡ��Դ�ļ�·��
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
