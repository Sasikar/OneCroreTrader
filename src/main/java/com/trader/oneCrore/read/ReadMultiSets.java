package com.trader.oneCrore.read;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadMultiSets {
    public static void main(String args[]) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for(int i=1;i<=2;i++) {
            executor.execute(new IndividualSetReader("gala.txt","Sasi"+i,"919"+i,i+""));
        }
        //executor.shutdown();
    }


}
