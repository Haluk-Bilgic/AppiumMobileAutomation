package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
   static XSSFWorkbook workbook;
   static  XSSFSheet sheet;

   public  ExcelUtils(String excelPath,String sheetName){
       try {
           workbook = new XSSFWorkbook(excelPath);
           sheet=workbook.getSheet(sheetName);
       } catch (Exception e) {
           System.out.println(e.getMessage());
           System.out.println(e.getCause());
           e.printStackTrace();
       }
   }
       public static void getRowCount(){
               int rowCount=sheet.getPhysicalNumberOfRows();
               System.out.println("RowCount:"+rowCount);
    }
        public static void getCellDataString(int rowNum,int columnNum){
            String cellData=sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
              System.out.println(cellData);
        }
    public static void getCellDataNumber(int rowNum,int columnNum){
            double cellData=sheet.getRow(rowNum).getCell(columnNum).getNumericCellValue();
            System.out.println(cellData);
    }

}
