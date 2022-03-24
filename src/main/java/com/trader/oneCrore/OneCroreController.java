package com.trader.oneCrore;

import com.trader.oneCrore.entity.Child;
import com.trader.oneCrore.repository.CHILDRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@RestController
public class OneCroreController {

    @Autowired
    private CHILDRepository childRepository;

    @GetMapping("/getPercentagesForGoldenBeforeBuy")
    public void getPercentagesGBB() throws ParseException, IOException, InterruptedException, AWTException {
        Timestamp t = parseDate("2022-03-04T9:14");
      //  System.out.println(  childRepository.findBySuperBuyGreaterThanAndCreationDateGreaterThan("0",t));
        StringBuffer sb = new StringBuffer();
        System.out.println("===="+childRepository.findBySasiBuyNotAndCreationDateGreaterThan("NaN",t));
        childRepository.findBySasiBuyNotAndCreationDateGreaterThan("NaN",t).stream().map(Child::getSymbol)
                .forEach(x ->  {
                    sb.append("NSE:"+x.replace("'","")+",");
                });
        String s1 = sb.substring(0,sb.length()-1);

        System.out.println("============"+s1.length());

        Path write = Paths.get("G:\\common\\GBB_"+LocalDate.now()+".txt");
        Files.write(write, s1.getBytes(StandardCharsets.UTF_8));
       CommonLogin c = new CommonLogin();
        var driver = c.login("1");
        uploadFile(driver,"GBB");

        //====================
        getPercentagesSuprBuy();
        getPercentagesForAGB();

    }
    @GetMapping("/getPercentagesForSuperBuy")
    public void getPercentagesSuprBuy() throws ParseException, IOException, InterruptedException, AWTException {
        Timestamp t =
                parseDate("2022-03-04T9:14");

        StringBuffer sb = new StringBuffer();
        childRepository.findBySuperBuyGreaterThanAndCreationDateGreaterThan("0",t).stream().map(Child::getSymbol)
                .forEach(x ->  {
                    sb.append("NSE:"+x.replace("'","")+",");
                });
        String s1 = sb.substring(0,sb.length()-1);

        System.out.println("============"+s1.length());

        Path write = Paths.get("G:\\common\\SB_"+LocalDate.now()+".txt");
        Files.write(write, s1.getBytes(StandardCharsets.UTF_8));
        CommonLogin c = new CommonLogin();
        var driver = c.login("1");
        uploadFile(driver,"SB");

    }
    @GetMapping("/getPercentagesForActualGoldenBuy")
    public void getPercentagesForAGB() throws ParseException, IOException, InterruptedException, AWTException {
        Timestamp t =
                parseDate("2022-03-04T9:14");

        StringBuffer sb = new StringBuffer();
        childRepository.findByGoldenBuyNotAndCreationDateGreaterThan("NaN",t).stream().map(Child::getSymbol)
                .forEach(x ->  {
                    sb.append("NSE:"+x.replace("'","")+",");
                });
        if(sb.length() > 0) {
            String s1 = sb.substring(0, sb.length() - 1);
            System.out.println("============" + s1.length());

            Path write = Paths.get("G:\\common\\AGB_" + LocalDate.now() + ".txt");
            Files.write(write, s1.getBytes(StandardCharsets.UTF_8));
            CommonLogin c = new CommonLogin();
            var driver = c.login("1");
            uploadFile(driver, "AGB");
        }
    }

    public void updatePercentage() throws ParseException {
        String pattern = "yyyy-MM-dd'T'HH:mm";
        DateFormat df = new SimpleDateFormat(pattern);
        Timestamp t = new Timestamp(df.parse("2022-03-04T9:15").getTime());
        childRepository.updatePercentage("'PVP'",t,"20%");
    }

    public  void uploadFile(WebDriver driver,String file) throws InterruptedException, AWTException {
        driver.findElement(By.xpath("//div[@class='headerButton-uV8zMgPt button-1SoiPS-f apply-common-tooltip']//span//*[name()='svg']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='overlap-manager-root']//div[4]//div[2]//div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("G:\\common\\"+file+"_"+LocalDate.now()+".txt");
        //  driver.close();
        System.setProperty("java.awt.headless", "false");
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            Thread.sleep(1000);

        driver.close();

    }
    public Timestamp parseDate(String date) throws ParseException {
        String pattern = "yyyy-MM-dd'T'HH:mm";
        DateFormat df = new SimpleDateFormat(pattern);
        Timestamp t = new Timestamp(df.parse(date).getTime());
        return t;
    }
}
