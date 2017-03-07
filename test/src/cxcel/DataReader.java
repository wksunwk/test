/**
 * @Date: Jan 5, 2009 - 6:44:33 PM
 */
package cxcel;

import java.util.Set;

/**
 * 数据读取器的基本接口定义
 * @author Cris YANG
 *
 */
public interface DataReader {
//	static Logger logger = Logger.getLogger(DataReader.class);
	/**
	 * 读取一行数据
	 * @author Cris YANG
	 * @return	一行数据对应的字符串数组
	 */
	public Object[] readLine();
	
	/**
	 * 读取一行数据到一个集合中,该代码将清除Set并加入新的数据
	 * @author Cris YANG
	 * @param dataSet	一行数据的数据集合
	 * @return	读取是否成功
	 */
	public boolean readLine(Set dataSet);
	
	/**
	 * 读取器
	 * @author Cris YANG
	 * @return 是否还有下一行数据
	 */
	public boolean next();
	
	/**
	 * 关闭文件
	 * @author Cris YANG
	 * @return	是否关闭成功
	 */
	public boolean close();
}
