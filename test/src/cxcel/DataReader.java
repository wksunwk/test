/**
 * @Date: Jan 5, 2009 - 6:44:33 PM
 */
package cxcel;

import java.util.Set;

/**
 * ���ݶ�ȡ���Ļ����ӿڶ���
 * @author Cris YANG
 *
 */
public interface DataReader {
//	static Logger logger = Logger.getLogger(DataReader.class);
	/**
	 * ��ȡһ������
	 * @author Cris YANG
	 * @return	һ�����ݶ�Ӧ���ַ�������
	 */
	public Object[] readLine();
	
	/**
	 * ��ȡһ�����ݵ�һ��������,�ô��뽫���Set�������µ�����
	 * @author Cris YANG
	 * @param dataSet	һ�����ݵ����ݼ���
	 * @return	��ȡ�Ƿ�ɹ�
	 */
	public boolean readLine(Set dataSet);
	
	/**
	 * ��ȡ��
	 * @author Cris YANG
	 * @return �Ƿ�����һ������
	 */
	public boolean next();
	
	/**
	 * �ر��ļ�
	 * @author Cris YANG
	 * @return	�Ƿ�رճɹ�
	 */
	public boolean close();
}
