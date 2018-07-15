package tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PwdRecoveryPage;
import utils.ExcelDataReader;

public class LoginPageTest
        extends TestBase
{
    @BeforeMethod
    void setUp(){
        _driver.get("<-PLEASE ENTER REQUIRED WEBSITE LINK->");
    }

    @Test(dataProvider = "Users_Data")
    void verifyLoginFeture(String email, String password){
        System.out.println("Navigate to Login Page");
        LoginPage _loginPage = new LoginPage(_driver, _wait);
        System.out.println("Fill the login form and submit.");
        _loginPage.loginToAccount(email, password);
    }

    @DataProvider(name = "Users_Data")
    public Object[][] passData(){
        ExcelDataReader excelDataReader = new ExcelDataReader("src/test/java/testdata/Users.xlsx");
        int total_row = excelDataReader.totalRow(0);

        Object[][] Users = new Object[total_row ][2];

        for(int i=0; i<total_row; i++){
            Users[i][0] = excelDataReader.getCellData(0,i,0);
            Users[i][1] = excelDataReader.getCellData(0,i,1);
        }
        return Users;
    }
}
