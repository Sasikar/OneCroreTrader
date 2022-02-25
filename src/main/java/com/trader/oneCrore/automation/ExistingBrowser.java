package com.trader.oneCrore.automation;


import com.sun.xml.bind.v2.runtime.RuntimeUtil;
import com.trader.oneCrore.read.ReadCsv;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExistingBrowser {
    public static void main(String[] args)
            throws InterruptedException, AWTException, IOException {



        ExecutorService executor = Executors.newFixedThreadPool(20);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\latest\\chromedriver.exe");
        System.setProperty("TESSDATA_PREFIX", "C:\\Users\\Admin\\Downloads\\tessdata-3.04.00\\tessdata");

        //get browser capabilities in key value pairs

        ChromeOptions o = new ChromeOptions();
        o.setExperimentalOption("debuggerAddress", "127.0.0.1:9898");
        WebDriver driver = new ChromeDriver(o);
        //set implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://in.tradingview.com/chart/q8S2jrCs");
        Thread.sleep(7000);


        //div[@class='headerButton-uV8zMgPt button-1SoiPS-f apply-common-tooltip']//span//*[name()='svg']
        //div[@class='headerButton-uV8zMgPt button-1SoiPS-f apply-common-tooltip isOpened-1SoiPS-f']//span//*[name()='svg']

       /* driver.findElement(By.xpath("//div[@class='headerButton-uV8zMgPt button-1SoiPS-f apply-common-tooltip']//span//*[name()='svg']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='overlap-manager-root']//div[4]//div[2]//div[1]")).click();
        Thread.sleep(1000);*/
       /* driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Admin\\Downloads\\set1.txt");
        //  driver.close();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(1000);

         *//*   driver.findElement(By.xpath("//span[normalize-space()='VEDL']")).click();
            System.out.println(driver.getPageSource());*//* */

        Path path = Paths.get("C:\\Users\\Admin\\Downloads\\set1.txt");
        StringBuffer sb = new StringBuffer();
        try {

            Files.lines(path).
                    forEach(x -> {
                        // x = "'"+x.split("NSE:")[1].split(",")[0]+"'";
                        // String y = "'"+"JUBLFOOD"+"'";
                        //span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()='JUBLFOOD']
                        //driver.findElement(By.xpath("//span[normalize-space()="+y+"]")).click();
                        //span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()='JUBLFOOD']
                        String z = "'"+"UNITDSPR"+"'";
                        String z1 = "'"+"CAPPL"+"'";
                        String z2 = "'"+"VENKYS"+"'";
                        String z3 = "'"+"APOLLOPIPES"+"'";
                        String z4 = "'"+"PIXTRANS"+"'";
                        String z5  = "'"+"1.USSDT"+"'";


                        String y = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()="+z+"]";
                        String y1 = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()="+z1+"]";
                        String y2 = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()="+z2+"]";
                        String y3 = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()="+z3+"]";
                        String y4 = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()="+z4+"]";
                        String y5 = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()="+z5+"]";



                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

/*

                        WebElement copyrightAtEndOfPage = driver.findElement(By.xpath(y1));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", copyrightAtEndOfPage);

                        WebElement copyrightAtEndOfPage2 = driver.findElement(By.xpath(y2));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", copyrightAtEndOfPage2);

                        WebElement copyrightAtEndOfPage3 = driver.findElement(By.xpath(y3));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", copyrightAtEndOfPage3);

                        WebElement copyrightAtEndOfPage4 = driver.findElement(By.xpath(y3));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", copyrightAtEndOfPage4);

*/


                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException p) {
                            p.printStackTrace();
                        }

                        driver.findElement(By.xpath(y5)).click();
                        System.out.println("YOYO"+StringUtils.countMatches(driver.getPageSource(),"Golden_Before_Buy"));
/*

                       String menu = "//div[@class='button-2WfzAPA- button-2Vpz_LXc apply-common-tooltip isInteractive-2Vpz_LXc']//*[name()='svg']";
                        driver.findElement(By.xpath(menu)).click();

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException p) {
                            p.printStackTrace();
                        }

                        String excel = "//div[contains(text(),'Export chart data')]";
                        driver.findElement(By.xpath(excel)).click();


                        String dropdown = "//span[@id='time-format-select']//span[@class='icon-14c_DKWJ']//*[name()='svg']";
                        driver.findElement(By.xpath(dropdown)).click();

                        String isoTime = "//div[contains(text(),'ISO time')]";
                        driver.findElement(By.xpath(isoTime)).click();

                        String export = "//span[contains(text(),'Export')]";
                        driver.findElement(By.xpath(export)).click();
*/


                        String fileName  = x.replace(":","_") + ", 1D";
                     //  executor.execute(new ReadCsv("C:\\Users\\Admin\\Downloads\\"+fileName));


                    });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()='SUNPHARMA']
