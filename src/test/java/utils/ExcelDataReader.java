package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataReader {

    public XSSFWorkbook workbook;
    public XSSFSheet sheet;

    public ExcelDataReader(String file_path){

        File file_src = new File(file_path);
        try {
            FileInputStream file_stream = new FileInputStream(file_src);
            workbook = new XSSFWorkbook(file_stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCellData(int sheetNumber, int row, int col){
        sheet = workbook.getSheetAt(sheetNumber);
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }

    public int totalRow(int sheetNumber){
        return workbook.getSheetAt(sheetNumber).getLastRowNum()+1;
    }
}
