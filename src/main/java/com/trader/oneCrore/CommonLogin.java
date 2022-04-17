package com.trader.oneCrore;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.HashMap;
import java.util.Set;

public class CommonLogin {

    @Value("classpath:/batch")
    private Resource batch;

    public WebDriver login(String driverNo) throws InterruptedException {


        //String chromedriver = System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\chromedriver.exe";

        String filePath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"batch";

        System.out.println("========================Filepath============="+filePath);


        int no = Integer.parseInt(driverNo);



 /*     String chromedriver = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromedriver);*/



        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        try {
            chromePrefs.put("download.default_directory", filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChromeOptions options = new ChromeOptions();

    //   options.addArguments("--headless");
     /*  options.addArguments("--disable-gpu");
        options.addArguments("start-maximized");*/
        options.addArguments("--window-size=1400,600");
       /* options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-setuid-sandbox");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");*/
        options.setExperimentalOption("prefs", chromePrefs);



        WebDriver driver = null;
        try {

            driver = new RemoteWebDriver(new URL("http://172.17.0.3:4444/wd/hub"),options);

          //  driver = new ChromeDriver(options);

            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }

      //  driver.manage().window().maximize();

        // Launch Website
        driver.navigate().to("https://in.tradingview.com/");


        var accountLogin = "//button[@class='tv-header__user-menu-button tv-header__user-menu-button--anonymous js-header-user-menu-button']";
        commonJs(driver, accountLogin);

        Thread.sleep(500);
        var signIn = "//div[contains(text(),'Sign in')]";
        commonJs(driver, signIn);


        String mainWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }


        Thread.sleep(500);
        var emailBox = "//span[@class='tv-signin-dialog__social tv-signin-dialog__toggle-email js-show-email']";
        commonJs(driver, emailBox);


        Thread.sleep(500);
        var name = " //input[contains(@id,'email-signin__user-name-input')]";
        driver.findElement(By.xpath(name)).sendKeys("nundewend@instaddr.win");

        Thread.sleep(500);
        var pass = "//input[contains(@id, 'email-signin__password-input')]";
        driver.findElement(By.xpath(pass)).sendKeys("nundewend@instaddr.win12");


        var buttonSubmit = "//span[@class='tv-button__loader']";
        commonJs(driver, buttonSubmit);
        Thread.sleep(4000);

        String excel = "//*[name()='path' and contains(@d,'M0 12h18v-')]";
        commonJs(driver, excel);

        Thread.sleep(1000);
        String chart =  "//div[contains(text(),'Chart')]";
        commonJs(driver, chart);


        Thread.sleep(9000);
        String mainWindow1 = driver.getWindowHandle();
        Set<String> handles1 = driver.getWindowHandles();
        for (String handle : handles1) {
            if (!handle.equals(mainWindow1)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        //driver.findElement(By.xpath(y1)).click();

        return driver;


    }

    public void commonJs(WebDriver driver, String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

}