package org.example;

import org.junit.Test;
import utils.ExcelUtils;

public class ExcelUtilsTest {

    @Test
    public void readExcel(){
        String projectPath=System.getProperty("user.dir");
        ExcelUtils excel= new ExcelUtils(projectPath+"\\excel\\data.xlsx","Sheet1");

        excel.getRowCount();
        excel.getCellDataString(0,0);
        excel.getCellDataNumber(1,1);
    }
}
