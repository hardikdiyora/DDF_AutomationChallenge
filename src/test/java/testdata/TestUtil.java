package testdata;

import utils.ExcelDataReader;

public class TestUtil {
    public static void main(String args[]) {
        ExcelDataReader excelDataReader = new ExcelDataReader("src/test/java/testdata/Users.xlsx");
        int total_row = excelDataReader.totalRow(0);

        Object[][] Users = new Object[total_row][2];

        for (int i = 0; i < total_row; i++) {
            Users[i][0] = excelDataReader.getCellData(0, i, 0);
            Users[i][1] = excelDataReader.getCellData(0, i, 1);
        }
        for (int i = 0; i < total_row; i++) {
            System.out.println(Users[i][0]);
            System.out.println(Users[i][1]);
        }
    }
}


