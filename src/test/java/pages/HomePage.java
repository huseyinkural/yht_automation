package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testdata.Constants;
import utility.SendEmailTLS;
import utility.TestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomePage extends BasePage {

    Properties properties;

    //locators
    By closePopupBy = By.className("modal-close");
    By fromBy = By.id("nereden");
    By toBy = By.id("nereye");
    By dateBy = By.id("trCalGid_input");
    By searchButtonBy = By.id("btnSeferSorgula");
    By date27By = By.xpath("//*[text()=\"30\"]");



    By seatBy1915 = By.xpath("//*[text()=\"11:04\"]/ancestor::tr/td[5]/child::*/child::label");

    ArrayList<By> seferler= new ArrayList<>();



    public HomePage(WebDriver driver) {
        super(driver);
        properties = TestUtils.getProperties();
    }

    public HomePage goToHomePage (){
        String baseURL = properties.getProperty("url");
        driver.get(baseURL);
        return this;
    }

    public HomePage closePopupWindow(){

        if ( isElementExist(closePopupBy)) click(closePopupBy);

        return this;
    }

    public HomePage search(String from, String to, String date){
        writeText(fromBy,from);
        writeText(toBy,to);
        clear(dateBy);
        writeText(dateBy,date);
        click(date27By);
        click(searchButtonBy);

        checkSeatBiggerThan2();

        return this;
    }

    private void checkSeatBiggerThan2(){


        seferler.add(seatBy1915);

        for (By sefer:seferler) {
            List<String> matchList = new ArrayList<String>();
            Pattern regex = Pattern.compile("\\((\\d+)\\)");
            Matcher regexMatcher = regex.matcher(getText(sefer));
            System.out.println(sefer.toString());
            while (regexMatcher.find()) {//Finds Matching Pattern in String

                matchList.add(regexMatcher.group(1));//Fetching Group from String
            }

            for(String str:matchList) {
                System.out.println(str);
                if(Integer.parseInt(str) > 1) SendEmailTLS.SendMail();
            }

        }

    }



}
