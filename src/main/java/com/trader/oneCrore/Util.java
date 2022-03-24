package com.trader.oneCrore;


import com.sun.xml.bind.v2.runtime.RuntimeUtil;
import com.trader.oneCrore.read.ReadCsv;
import com.trader.oneCrore.repository.CHILDRepository;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
import java.util.stream.IntStream;

public class Util {

    public void individualSet(ExecutorService executorService, String driverNo, CHILDRepository childRepository)
            throws InterruptedException, AWTException {

        final int no = Integer.parseInt(driverNo);

        CommonLogin c = new CommonLogin();
        WebDriver driver = c.login(driverNo);

        Path path = null;
        if (no % 2 == 0) {
            String set2 = "//div[@class='button-1SoiPS-f button-pg6Iiu-y apply-common-tooltip']//div[@class='arrow-1SoiPS-f']";
            driver.findElement(By.xpath(set2)).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[normalize-space()='set2']")).click();
            path = Paths.get("C:\\Users\\Admin\\Downloads\\set2.txt");
        } else {
            path = Paths.get("C:\\Users\\Admin\\Downloads\\set1_1.txt");
        }


        StringBuffer sb = new StringBuffer();


        try {
            Files.lines(path).
                    forEach(x -> {
                        String x1 = "'" + x.split("NSE:")[1] + "'";
                        String y = "//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()=" + x1 + "]";
                        sleep(Thread.currentThread(), 1000);

                        if(findElementWithExceptionHandling(driver, y, x1, no, true))return;
                        sleep(Thread.currentThread(), 100);

                        String percentageString = "'"+x+"'";
                       System.out.println("=========="+driver.findElement(By.xpath("//div[contains(@data-symbol-full,"+percentageString+")]//span[contains(@class,'changeInPercents-EJ_LFrif')]")).getText());

                        String menu = "//div[@class='button-2WfzAPA- button-2Vpz_LXc apply-common-tooltip isInteractive-2Vpz_LXc']//*[name()='svg']";
                        if(findElementWithExceptionHandling(driver, menu, x1, no, false))return;
                        sleep(Thread.currentThread(), 100);


                        String excel = "//div[contains(text(),'Export chart data')]";
                        if(findElementWithExceptionHandling(driver, excel, x1, no, false))return;
                        sleep(Thread.currentThread(), 100);

                        String dropdown = "//span[@id='time-format-select']//span[@class='icon-14c_DKWJ']//*[name()='svg']";
                        if(findElementWithExceptionHandling(driver, dropdown, x1, no, false))return;
                        sleep(Thread.currentThread(), 100);

                        String isoTime = "//div[contains(text(),'ISO time')]";
                        if(findElementWithExceptionHandling(driver, isoTime, x1, no, false))return;
                        sleep(Thread.currentThread(), 100);

                        String export = "//span[contains(text(),'Export')]";
                        if(findElementWithExceptionHandling(driver, export, x1, no, false))return;


                        String fileName = x.replace(":", "_") + ", 1D";
                        executorService.execute(new ReadCsv(fileName, no, childRepository, x1));


                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean findElementWithExceptionHandling(WebDriver driver, String path, String iteratedEle, int batchNo, boolean scrollView) {
        try {
            if (scrollView) {
                var actEle = driver.findElement(By.xpath(path));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", actEle);
                actEle.click();
            } else {
                driver.findElement(By.xpath(path)).click();
            }
        } catch (Exception e) {
            System.out.println("=======> rerun===>" + batchNo + "===>" + iteratedEle);
            System.out.println(e);
            return true;
        }
        return false;
    }

    public void sleep(Thread thread, int time) {
        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//span[@class='inner-EJ_LFrif symbolNameText-EJ_LFrif'][normalize-space()='SUNPHARMA']
