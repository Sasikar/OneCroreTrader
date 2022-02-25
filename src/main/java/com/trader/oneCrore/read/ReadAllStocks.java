package com.trader.oneCrore.read;

import com.trader.oneCrore.entity.Stock;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadAllStocks {


    public static List<Stock> getAllIndianStocks() {

        List list = new ArrayList<Stock>();


        Path path = Paths.get("C:\\Users\\Admin\\Downloads\\stocks.csv");
        try {
            AtomicInteger counter = new AtomicInteger(0);
            Files.lines(path).skip(1).filter(x -> {
                String[] s = x.split(",");
                return !s[0].isEmpty();
            }).forEach(x -> {
                counter.incrementAndGet();
                String s[] = x.split(",");
                final Stock stock = new Stock();
                stock.setSymbol(s[0]);
                list.add(stock);
            });
            System.out.println("=================counter" + counter.get());


        } catch (IOException ex) {
            ex.printStackTrace();//handle exception here
        }
        return list;
    }

    public static void main(String args[]) {

        Path path = Paths.get("C:\\Users\\Admin\\Downloads\\stocks.csv");
        Path write1 = Paths.get("C:\\Users\\Admin\\Downloads\\set1.txt");
        Path write2 = Paths.get("C:\\Users\\Admin\\Downloads\\set2.txt");
        Path write3 = Paths.get("C:\\Users\\Admin\\Downloads\\set3.txt");
        Path write4 = Paths.get("C:\\Users\\Admin\\Downloads\\set4.txt");
        StringBuffer set1 = new StringBuffer();
        StringBuffer set2 = new StringBuffer();
        StringBuffer set3 = new StringBuffer();
        StringBuffer set4 = new StringBuffer();
        try {
            AtomicInteger counter = new AtomicInteger(1);
            Files.lines(path).skip(1).filter(x -> {
                String[] s = x.split(",");
                return !s[0].isEmpty(); //bcz csv has empties after removing spaces
            }).forEach(x -> {
                counter.incrementAndGet();
                String s[] = x.split(",");
                if(counter.get()<1000) {
                    set1.append("NSE:" + s[0] + ",");
                }
                else if(counter.get()<2000) {
                    set2.append("NSE:" + s[0] + ",");
                }
                else if(counter.get()<3000) {
                    set3.append("NSE:" + s[0] + ",");
                }
                else  {
                    set4.append("NSE:" + s[0] + ",");
                }

            });
           String s1 = set1.substring(0,set1.length()-1);
            Files.write(write1, s1.getBytes(StandardCharsets.UTF_8));
            String s2 = set2.substring(0,set2.length()-1);
            Files.write(write2, s2.getBytes(StandardCharsets.UTF_8));
            String s3 = set3.substring(0,set3.length()-1);
            Files.write(write3, s3.getBytes(StandardCharsets.UTF_8));
            String s4 = set4.substring(0,set4.length()-1);
            Files.write(write4, s4.getBytes(StandardCharsets.UTF_8));
           // System.out.println("=================counter" + counter.get());


        } catch (IOException ex) {
            ex.printStackTrace();//handle exception here
        }
    }
}
