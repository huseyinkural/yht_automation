package tests.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utility.TestUtils;

import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public Properties properties;


    public BaseTest(){
        properties = TestUtils.getProperties();
    }
    public WebDriver getDriver() {
        return driver;
    }
    @BeforeClass
    public void setup(){
        String browserName = properties.getProperty("browser");

        switch (browserName){
            case "firefox":
                System.setProperty("webdriver.gecko.driver","drivers/firefox");
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--disable-notifications");
                //options.addArguments("--headless");
                options.addArguments("--remote-allow-origins=*");

                driver = new ChromeDriver(options);

                //driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

        }




    }



    @AfterClass
    public void teardown () {

        driver.quit();
    }
}
