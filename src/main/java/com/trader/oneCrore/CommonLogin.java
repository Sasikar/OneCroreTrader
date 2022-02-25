package com.trader.oneCrore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.Set;

public class CommonLogin {

    public WebDriver login() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "G:\\Batch\\chromedriver_win32\\chromedriver.exe");

        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();

        //Maximize the browser
        driver.manage().window().maximize();

        // Launch Website
        driver.navigate().to("https://in.tradingview.com/");


        var accountLogin = "//button[@class='tv-header__user-menu-button tv-header__user-menu-button--anonymous js-header-user-menu-button']";
        driver.findElement(By.xpath(accountLogin)).click();

        Thread.sleep(500);
        var signIn = "//div[contains(text(),'Sign in')]";
        driver.findElement(By.xpath(signIn)).click();


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
        driver.findElement(By.xpath(emailBox)).click();


        Thread.sleep(500);
        var name = " //input[contains(@id,'email-signin__user-name-input')]";
        driver.findElement(By.xpath(name)).sendKeys("dopot21931@goonby.com");

        Thread.sleep(500);
        var pass = "//input[contains(@id, 'email-signin__password-input')]";
        driver.findElement(By.xpath(pass)).sendKeys("dopot21931@goonby.com12");


        var buttonSubmit = "//span[@class='tv-button__loader']";
        driver.findElement(By.xpath(buttonSubmit)).click();

        String z = "'" + "5PAISA" + "'";

        String y = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()=" + z + "]";

        Thread.sleep(15000);
        driver.findElement(By.xpath(y)).click();

        String excel = "//span[contains(text(),'See more on advanced chart')]";

        Thread.sleep(9000);
        driver.findElement(By.xpath(excel)).click();


        String z1 = "'" + "3MINDIA" + "'";

        String y1 = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()=" + z1 + "]";

        Thread.sleep(9000);
        String mainWindow1 = driver.getWindowHandle();
        Set<String> handles1 = driver.getWindowHandles();
        for (String handle : handles1) {
            if (!handle.equals(mainWindow1)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        driver.findElement(By.xpath(y1)).click();

        return driver;


    }

}