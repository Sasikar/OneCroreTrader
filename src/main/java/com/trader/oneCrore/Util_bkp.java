/*
package com.trader.oneCrore;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;

public class Util_bkp {
    public  void individualSet(String port,ExecutorService executorService,String driverNo)
            throws InterruptedException, AWTException, IOException {

             final int no = Integer.parseInt(driverNo);
      //  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\latest\\chromedriver"+"_"+driverNo+".exe");

       // System.setProperty("webdriver.chrome.driver", "G:\\Batch\\chromedriver_win32\\chromedriver.exe");

        //get browser capabilities in key value pairs

    */
/*    ChromeOptions o = new ChromeOptions();
     //   o.setExperimentalOption("debuggerAddress", "127.0.0.1:"+port);4
        o.setExperimentalOption("debuggerAddress", "127.0.0.1:9191");
*//*

        //o.addArguments("disable-blink-features=AutomationControlled");
     */
/*   WebDriver driver = new ChromeDriver();


        //set implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://in.tradingview.com/chart/q8S2jrCs");
        Thread.sleep(2000);

      *//*
*/
/*  Dimension d = new Dimension(300,1080);
        //Resize current window to the set dimension
        driver.manage().window().setSize(d);
*//*
*/
/*
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(3000);

       *//*
*/
/* driver.manage().window().setSize(d);
        Thread.sleep(3000);*//*
*/
/*

        driver.manage().window().maximize();


        String currentWindowHandle = driver.getWindowHandle();

//run your javascript and alert code
        ((JavascriptExecutor)driver).executeScript("alert('Test')");
        driver.switchTo().alert().accept();*//*


//Switch back to to the window using the handle saved earlier
       // driver.switchTo().window(currentWindowHandle);

        //div[@class='headerButton-uV8zMgPt button-1SoiPS-f apply-common-tooltip']//span//*[name()='svg']
        //div[@class='headerButton-uV8zMgPt button-1SoiPS-f apply-common-tooltip isOpened-1SoiPS-f']//span//*[name()='svg']

       */
/* driver.findElement(By.xpath("//div[@class='headerButton-uV8zMgPt button-1SoiPS-f apply-common-tooltip']//span//*[name()='svg']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='overlap-manager-root']//div[4]//div[2]//div[1]")).click();
        Thread.sleep(1000);*//*

       */
/* driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Admin\\Downloads\\set1.txt");
        //  driver.close();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(1000);

         *//*
*/
/*   driver.findElement(By.xpath("//span[normalize-space()='VEDL']")).click();
            System.out.println(driver.getPageSource());*//*
*/
/* *//*


         CommonLogin c = new CommonLogin();
         WebDriver driver = c.login(driverNo);


        Path path = Paths.get("C:\\Users\\Admin\\Downloads\\set1_1.txt");
        StringBuffer sb = new StringBuffer();
        try {

            Files.lines(path).
                    forEach(x -> {
                          x = "'"+x.split("NSE:")[1]+"'";
                        // String y = "'"+"JUBLFOOD"+"'";
                        //span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()='JUBLFOOD']
                        //driver.findElement(By.xpath("//span[normalize-space()="+y+"]")).click();
                        //span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()='JUBLFOOD']
                        String z = "'"+"UNITDSPR"+"'";
                        String z1 = "'"+"CAPPL"+"'";
                        String z2 = "'"+"VENKYS"+"'";
                        String z3 = "'"+"APOLLOPIPES"+"'";
                        String z4 = "'"+"PIXTRANS"+"'";
                        String z5  = "'"+"5PAISA"+"'";


                        String y = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()="+x+"]";
                        String y1 = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()="+z1+"]";
                        String y2 = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()="+z2+"]";
                        String y3 = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()="+z3+"]";
                        String y4 = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()="+z4+"]";
                        String y5 = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()="+z5+"]";



                        try {
                            Thread.sleep(9000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        WebElement copyrightAtEndOfPage = null;
                        System.out.println("==================="+no);
                        System.out.println("==================="+y);
                        System.out.println("==================="+y5);
                        if(no%2==0){
                             copyrightAtEndOfPage = driver.findElement(By.xpath(y));
                        } else {
                            copyrightAtEndOfPage = driver.findElement(By.xpath(y5));

                       }
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", copyrightAtEndOfPage);

                        copyrightAtEndOfPage.click();
                    */
/*    WebElement copyrightAtEndOfPage2 = driver.findElement(By.xpath(y2));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", copyrightAtEndOfPage2);

                        WebElement copyrightAtEndOfPage3 = driver.findElement(By.xpath(y3));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", copyrightAtEndOfPage3);

                        WebElement copyrightAtEndOfPage4 = driver.findElement(By.xpath(y3));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", copyrightAtEndOfPage4);
*//*




                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException p) {
                            p.printStackTrace();
                        }

                       // WebDriverWait wait = new WebDriverWait(driver, 40);
                       // wait.until(ExpectedConditions.elementToBeClickable(By.xpath(y5)));

                        */
/*driver.findElement(By.xpath(y)).click();
                        System.out.println("YOYO"+StringUtils.countMatches(driver.getPageSource(),"Golden_Before_Buy"));
*//*

                       String menu = "//div[@class='button-2WfzAPA- button-2Vpz_LXc apply-common-tooltip isInteractive-2Vpz_LXc']//*[name()='svg']";
                        driver.findElement(By.xpath(menu)).click();

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException p) {
                            p.printStackTrace();
                        }

                        String excel = "//div[contains(text(),'Export chart data')]";
                        driver.findElement(By.xpath(excel)).click();

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        String dropdown = "//span[@id='time-format-select']//span[@class='icon-14c_DKWJ']//*[name()='svg']";
                        driver.findElement(By.xpath(dropdown)).click();


                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        String isoTime = "//div[contains(text(),'ISO time')]";
                        driver.findElement(By.xpath(isoTime)).click();

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        String export = "//span[contains(text(),'Export')]";
                        driver.findElement(By.xpath(export)).click();



                        String fileName  = x.replace(":","_") + ", 1D";
                        //  executor.execute(new ReadCsv("C:\\Users\\Admin\\Downloads\\"+fileName));

                     //
                        // throw new RuntimeException();

                    });
              //  executorService.shutdown();
               // driver.close();


        } catch (IOException |  RuntimeException r) {

           // r.printStackTrace();
        }
    }
}

//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()='SUNPHARMA']
*/
