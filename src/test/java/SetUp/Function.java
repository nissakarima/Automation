package SetUp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static SetUp.MyConfig.*;

public class Function {
    public static void set_spesific_testcase(String strValue) {
        strTestCase = strValue;
    }

    public static void start_chromedriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        options.addArguments("--js-flags=--expose-gc");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("test-type=browser");
        options.addArguments("disable-infobars");
        ChromeDriver cdriver = new ChromeDriver(options);
        driver = cdriver;
        cdriver.manage().deleteAllCookies();
    }

    public static void change_iframe(String strObjectName) {
        getElement(strObjectName);
        driver.switchTo().frame(getElement(strObjectName));
    }

    public static void change_iframe_default(String strObjectName) {
        getElement(strObjectName);
        driver.switchTo().defaultContent();
    }

    public static void go_to_url(String strValue) {
        driver.get(strValue);
    }

    public static void click(String strObjectName) {
        getElement(strObjectName).click();
    }

    public static void set_text(String strObjectName, String strValue) {
        getElement(strObjectName).clear();
        getElement(strObjectName).sendKeys(strValue);

    }

    public static void screenshot() {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream( "src\\test\\java\\Configuration\\configuration.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String strPathScreenshot = properties.getProperty("strPathScreenshot");
        File f = new File(strPathScreenshot);
        if (f.mkdirs()) {
            System.out.println("Directory is created");
        }

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            intCountScreenshot = intCountScreenshot + 1;
            FileHandler.copy(scrFile, new File(strPathScreenshot + strTestCase + "_" + String.valueOf(intCountScreenshot) + ".png"));
        } catch (IOException e) {
        }
    }

    public static void wait_until_element_exists(String strObjectName) {
        String strXpath = loadXpath(strObjectName);
        int intIfExist = driver.findElements(By.xpath(strXpath)).size();
        while (intIfExist == 0) {
            intIfExist = driver.findElements(By.xpath(strXpath)).size();
        }
    }

    public static void wait_until_element_gone(String strObjectName) {
        String strXpath = loadXpath(strObjectName);
        int intIfExist = driver.findElements(By.xpath(strXpath)).size();
        while (intIfExist > 0) {
            intIfExist = driver.findElements(By.xpath(strXpath)).size();
        }
    }

    public static void wait_for_seconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }

    public static void debug() {
        System.out.println("");
    }

    public static void click_js(String strObjectName) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement element = getElement(strObjectName);
        executor.executeScript("arguments[0].click();", element);
    }

    public static void hover(String strObjectName) {
        Actions action = new Actions(driver);
        WebElement we = getElement(strObjectName);
        action.moveToElement(we).build().perform();
    }

    public static void quit_driver() {
        driver.quit();
        driver = null;
    }

    public static void assert_equals(String strObjectName, String expected){
        String actual = getElement(strObjectName).getText().trim();
        if (expected.equals(actual)){
            System.out.println("'" + actual + "' is displayed");
        } else {
            System.out.println("'" + actual + "' is not displayed");
        }

    }

    //=========================//
    protected static String loadXpath(String objectName) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream( "src\\test\\java\\Configuration\\xpath.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String strXpathElement = properties.getProperty(objectName);
        return strXpathElement;
    }

    protected static WebElement getElement(String objectName) {
        WebElement element = null;
        try {
            String strXpath = loadXpath(objectName);
            element = driver.findElement(By.xpath(strXpath));
        } catch (Exception e) {
            System.out.println("Element objectName not found!");
            e.printStackTrace();
        }

        return element;
    }

}
