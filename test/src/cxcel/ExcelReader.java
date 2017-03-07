/**
 * @Date: Jan 5, 2009 - 9:01:45 PM
 */
package cxcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.DateUtil;
/**
 * Excel文件的读取类
 * @author wang chengming
 *
 */
public class ExcelReader extends FileDataReader {
    HSSFSheet sheet;
    HSSFWorkbook wb;
    InputStream myxls;
    int sheetCount = 1;
    String[] buffer = null;
    
    static final int DATE_FORMAT_YYYY_MM_dd = 14;
    static final int DATE_FORMAT_YYYYMD = 31;
    static final int DATE_FORMAT_YYYYM = 57;
    static final int DATE_FORMAT_MD = 58;
    static final int DATE_FORMAT_HHMM = 20;
    static final int DATE_FORMAT_HMM = 32;
    
    static Set<Integer> DATE_FORMAT_CODE_SET = new HashSet<Integer>();
    static{
    	DATE_FORMAT_CODE_SET.add(DATE_FORMAT_YYYY_MM_dd);
    	DATE_FORMAT_CODE_SET.add(DATE_FORMAT_YYYYMD);
    	DATE_FORMAT_CODE_SET.add(DATE_FORMAT_YYYYM);
    	DATE_FORMAT_CODE_SET.add(DATE_FORMAT_MD);
    	DATE_FORMAT_CODE_SET.add(DATE_FORMAT_HHMM);
    	DATE_FORMAT_CODE_SET.add(DATE_FORMAT_HMM);
    }
    
	/**
	 * 缺省构造函数
	 * @author Cris YANG
	 * @param srcFilepath Excel文件路径
	 * @throws IOException 
	 */
	public ExcelReader(String srcFilepath) throws IOException {
		super(srcFilepath);
		myxls = new FileInputStream(srcFilepath);
		this.wb = new HSSFWorkbook(myxls);
		this.sheetCount = this.wb.getNumberOfSheets();
		this.sheet =this.wb.getSheetAt(0);       
	}

	/* (non-Javadoc)
	 * @see stat2.common.filesystem.reader.FileDataReader#close()
	 */
	public boolean close() {
		// TODO Auto-generated method stub
	    try {
            this.myxls.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
	}

	/* (non-Javadoc)
	 * @see stat2.common.filesystem.reader.FileDataReader#next()
	 */
	public boolean next() {
		// TODO Auto-generated method stub
        return false;
	}

	/* (non-Javadoc)
	 * @see stat2.common.filesystem.reader.FileDataReader#readLine()
	 */
	public String[] readLine() {
		// TODO Auto-generated method stub
	    return buffer;
	}

	/* (non-Javadoc)
	 * @see stat2.common.filesystem.reader.FileDataReader#readLine(java.util.Set)
	 */
	public boolean readLine(Set dataSet) {
        return false;
	}
	
	public void exportRow() {
		int rowNum = 1;
		
		HSSFRow row = sheet.getRow(rowNum);
		while (row != null) {
			HSSFCell cell1 = row.getCell(3);
			HSSFCell cell2 = row.getCell(4);
			HSSFCell cell3 = row.getCell(5);
			String code = cell1.getRichStringCellValue().toString();
			if (code != null && code.length() == 4) {
				String name = cell2.getStringCellValue().replaceAll(" ", "").replaceAll("\n", "");
				String desc = cell3.getStringCellValue().replaceAll(" ", "").replaceAll("\n", "");
				System.out.println("insert into industry_code_s (code,name,memo) values ('" + code + "','" + name + "','" + desc + "');");
			}
			row = sheet.getRow(++rowNum);
		}
	}
	
	public String getCellContent(int rowNum, int cellNum) {
		String cellContent = "";
	    HSSFRow row = sheet.getRow(rowNum);        // 第三行
	    if (row != null)
	    {
	    	HSSFCell cell = row.getCell((short)cellNum);
	    	if(cell != null) {
	    		if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
	    			cellContent = cell.getRichStringCellValue().toString();
	    		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC || cell.getCellType() == HSSFCell.CELL_TYPE_FORMULA) {
	    			try{
		    			double cellValue = cell.getNumericCellValue();
		    			
		    			int dateFormat = cell.getCellStyle().getDataFormat();
		    			if (DATE_FORMAT_CODE_SET.contains(dateFormat)){
		    				//这是一个日期格式
		    				DateFormat df;
		    				switch (dateFormat){
		    				case DATE_FORMAT_YYYYMD:
		    					df = new SimpleDateFormat("yyyy年M月d日");
		    					break;
		    					
		    				case DATE_FORMAT_YYYYM:
		    					df = new SimpleDateFormat("yyyy年M月");
		    					break;
		    					
		    				case DATE_FORMAT_MD:
		    					df = new SimpleDateFormat("M月d日");
		    					break;
		    					
		    				case DATE_FORMAT_HHMM:
		    					df = new SimpleDateFormat("HH:mm");
		    					break;
		    					
		    				case DATE_FORMAT_HMM:
		    					df = new SimpleDateFormat("h时mm分");
		    					break;
		    					
		    				case DATE_FORMAT_YYYY_MM_dd:
		    				default:
		    					df = new SimpleDateFormat("yyyy-MM-dd");
		    				}
		    				Date date = DateUtil.getJavaDate(cellValue);
		    				cellContent = df.format(date);
		    			}
		    			else{
		    				if (Double.isNaN(cellValue)) {
		    					cellContent = cell.getRichStringCellValue().toString();
		    				} else {
		    					DecimalFormat df = new DecimalFormat("####################.##########");
		    					cellContent = df.format(cellValue);
		    					cellContent = cellContent.replaceAll("\\.0$", "");
		    				}
		    			}
	    			}catch (Exception e){
	    				cellContent = cell.getRichStringCellValue().toString();
	    			}
	    		}
	    	}	    
	    }
	    return cellContent;
	}
	
	public int[] getCellSpan(int rowNum, int cellNum){
		int[] cellSpan = new int[]{1,1};
		for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
			Region region = sheet.getMergedRegionAt(i);
			if (region.getRowFrom() <= rowNum && rowNum <= region.getRowTo()) {
				if (region.getColumnFrom() <= cellNum && cellNum <= region.getColumnTo()) {
					cellSpan[0] += region.getRowTo() - region.getRowFrom();
					cellSpan[1] += region.getColumnTo() - region.getColumnFrom();
					break;
				}
			}
		}
	    return cellSpan;
	}
	
	public int[] getCellDownRightSpan(int rowNum, int cellNum){
		int[] cellSpan = new int[]{1,1};
		for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
			Region region = sheet.getMergedRegionAt(i);
			if (region.getRowFrom() <= rowNum && rowNum <= region.getRowTo()) {
				if (region.getColumnFrom() <= cellNum && cellNum <= region.getColumnTo()) {
					cellSpan[0] += region.getRowTo() - rowNum;
					cellSpan[1] += region.getColumnTo() - cellNum;
					break;
				}
			}
		}
	    return cellSpan;
	}
	
	public int firstCellNumOnRow(int rowNum) {
	    HSSFRow row = sheet.getRow(rowNum);
	    if (row != null){
	    	return row.getFirstCellNum();
	    }
	    else{
	    	return 0;
	    }
	}
	
	public int lastCellNumOnRow(int rowNum) {
        HSSFRow row = sheet.getRow(rowNum);
        int lastCellNum = -1;
        if(row != null) {
            lastCellNum = row.getLastCellNum();
        }
        return lastCellNum;
    }
	
	public int firstRowNum() {
	    return this.sheet.getFirstRowNum();
	}
	
	public int lastRowNum() {
	    return this.sheet.getLastRowNum();
	}
	
	public boolean isEmptyRow(int rowNum, int colNum) {
	    boolean isEmptyRow = true;
	    HSSFRow row = sheet.getRow(rowNum);        // 第三行
	    for (int j = 0; j < colNum; j++) {
            HSSFCell cell   = row.getCell((short)j);
            String cellContent = "";
            if(cell != null) {
                if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                    cellContent = cell.getRichStringCellValue().toString();
                } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                    cellContent = String.valueOf(cell.getNumericCellValue());
                }
                if(!"".equals(cellContent)) {
                    isEmptyRow = false;
                    break;
                }
            }       
	    }
	    return isEmptyRow;
	}

	public void setSheet(int sheetNumber) {
		this.sheet = this.wb.getSheetAt(sheetNumber); ;
	}

	public int getSheetCount() {
		return sheetCount;
	}
	
	public String getSheetName(int sheetIx) {
		return this.wb.getSheetName(sheetIx);
	}
	
	public static void main(String[] args) throws IOException{
		ExcelReader reader = new ExcelReader("D:\\test\\2011.xls");
		reader.exportRow();
//		System.out.println (reader.getCellContent(0, 1));
	}
}
