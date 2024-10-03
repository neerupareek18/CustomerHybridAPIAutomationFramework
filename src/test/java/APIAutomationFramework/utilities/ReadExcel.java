package APIAutomationFramework.utilities;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class ReadExcel {

    //Data provider to the TestNG
    //Read from the Excel and give you the data in 2d matrix

    public static String fileName ="src/test/resource/DataSheet.xlsx";
    public static Workbook book;
    public static Sheet sheet;

    public static Object[][] getTestData(String sheetName){
        FileInputStream f = null;
        try{
            f = new FileInputStream(fileName);
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
book = WorkbookFactory.create(f);
        }
        catch(IOException e){
           throw new RuntimeException(e);
        }

        sheet = book.getSheet(sheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for(int i =0 ; i<sheet.getLastRowNum();i++){
            for(int j =0 ; j<sheet.getRow(0).getLastCellNum();j++){
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;

    }

    @DataProvider
    public Object[][] getData(){
        return getTestData("Sheet1");
    }
}
