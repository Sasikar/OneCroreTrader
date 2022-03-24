package com.trader.oneCrore.read;

import com.trader.oneCrore.repository.CHILDRepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadMultiSets {
    public  void main(CHILDRepository childRepository) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for(int i=1;i<=2;i++) {
            executor.execute(new IndividualSetReader("Sasi"+i,i+"",childRepository));
        }
        //executor.shutdown();
    }


}
