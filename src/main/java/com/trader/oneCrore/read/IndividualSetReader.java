package com.trader.oneCrore.read;

import com.trader.oneCrore.Util;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IndividualSetReader implements Runnable{

    private String fileName;
    private String threadName;
    private String port;
    private String driver;
    private ExecutorService executor = Executors.newFixedThreadPool(200);

    public IndividualSetReader(String fileName, String threadName, String port, String driver) {
        this.fileName = fileName;
        this.threadName = threadName;
        this.port = port;
        this.driver = driver;
    }

    @Override
    public void run() {
       Thread.currentThread().setName(this.threadName);
        System.out.println(Thread.currentThread().getName());
        try {
            Util util = new Util();
            util.individualSet(this.port,executor,driver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
