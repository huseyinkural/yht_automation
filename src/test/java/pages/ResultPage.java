package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage extends BasePage {

    //locators
    By seatBy = By.xpath("//*[text()=\"19:19\"]/ancestor::tr/td[5]/child::*/child::label");


    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public ResultPage checkRemaingSeat(){
        getText(seatBy);
        return this;
    }
}
