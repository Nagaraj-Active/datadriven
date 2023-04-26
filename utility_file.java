package Datadriven;

import java.io.FileInputStream ;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Formatter;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utility_file
{
public static int getrowcount(String xlfile, String xlsheet ) throws IOException
    {
	  FileInputStream fi = new FileInputStream(xlfile);
	 XSSFWorkbook wb = new XSSFWorkbook(fi);
	                  XSSFSheet sheets=wb.getSheet(xlsheet);
	                  int rows = sheets.getLastRowNum();
	                  wb.close();
	                  fi.close();
	 return rows;
    }
public static int getcellcount(String xlfile, String xlsheet,int rownum) throws IOException
    {
	 FileInputStream fi = new FileInputStream(xlfile);
	 XSSFWorkbook wb=new XSSFWorkbook(fi);
	 XSSFSheet sheet=wb.getSheet(xlsheet);
	    XSSFRow rows=sheet.getRow(rownum);
	       int cells=rows.getLastCellNum();
	              wb.close();
	              fi.close();
	    return cells;
    }
public static String get_celldata(String xlfile,String xlsheet,int rownum,int column) throws IOException
    {
	FileInputStream fi= new FileInputStream(xlfile);
	XSSFWorkbook wb= new XSSFWorkbook(fi);
	XSSFSheet sheet=wb.getSheet(xlsheet);
	XSSFRow rows=sheet.getRow(rownum);
	XSSFCell cells = rows.getCell(column);
	String data;
	try
	{
		DataFormatter fm=new DataFormatter();
		data=fm.formatCellValue(cells);
		return data;
	}
	catch(Exception e)
	{
		data="";
	}
	wb.close();
	fi.close();
	return data;
    }
public static void setCellData(String xlfile,String xlsheet,int rownum,int column,String data)throws IOException
    {
	FileInputStream fi = new FileInputStream(xlfile);
	XSSFWorkbook workbook = new XSSFWorkbook(fi);
	XSSFSheet sheet = workbook.getSheet(xlsheet);

	XSSFRow rows = sheet.getRow(rownum);
	XSSFCell cells = rows.createCell(column);
	cells.setCellValue(data);
	FileOutputStream fo = new FileOutputStream(xlsheet);
	workbook.write(fo);
	workbook.close();
	fi.close();
	fo.close();
    }
public static void fillGreenColour(String xlfile,String xlsheet,int rownum,int column) throws IOException
    {
	FileInputStream fi = new FileInputStream(xlfile);
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	XSSFSheet sheet=wb.getSheet(xlsheet);
	XSSFRow rows=sheet.getRow(rownum);
	XSSFCell cells=rows.getCell(column);
	XSSFCellStyle style = wb.createCellStyle();
	style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
	cells.setCellStyle(style);
	FileOutputStream fo = new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
    }
public static void fillRedColour(String xlfile,String xlsheet,int rownum,int column) throws IOException
    {
	FileInputStream fi = new FileInputStream(xlfile);
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	XSSFSheet sheet=wb.getSheet(xlsheet);
	XSSFRow rows=sheet.getRow(rownum);
	XSSFCell cells=rows.getCell(column);
	XSSFCellStyle style = wb.createCellStyle();
	style.setFillForegroundColor(IndexedColors.RED.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
	cells.setCellStyle(style);
	FileOutputStream fo = new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
    }

}
