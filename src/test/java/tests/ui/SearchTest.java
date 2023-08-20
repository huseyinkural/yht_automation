package tests.ui;

import org.testng.annotations.Test;
import pages.HomePage;
import testdata.Constants;

import java.lang.reflect.Method;



public class SearchTest extends BaseTest {


    @Test(priority = 1)
    public void searchTest (Method method) {

        HomePage homePage = new HomePage(driver);
        homePage
                .goToHomePage()
                .search("ERYAMAN YHT","İstanbul(Söğütlü Ç.)","31.08.2023");


    }


}
