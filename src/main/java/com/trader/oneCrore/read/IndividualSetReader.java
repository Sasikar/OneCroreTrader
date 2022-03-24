package com.trader.oneCrore.read;

import com.trader.oneCrore.Util;
import com.trader.oneCrore.repository.CHILDRepository;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IndividualSetReader implements Runnable{


    private String threadName;
    private String driver;
    private CHILDRepository childRepository;
    private ExecutorService executor = Executors.newFixedThreadPool(200);

    public IndividualSetReader(String threadName, String driver, CHILDRepository childRepository) {
        this.threadName = threadName;
        this.driver = driver;
        this.childRepository = childRepository;
    }

    @Override
    public void run() {
       Thread.currentThread().setName(this.threadName);
        System.out.println(Thread.currentThread().getName());
        try {
            Util util = new Util();
            util.individualSet(executor,driver,childRepository);
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
