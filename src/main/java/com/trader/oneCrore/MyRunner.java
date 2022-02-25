package com.trader.oneCrore;

import com.trader.oneCrore.entity.Stock;
import com.trader.oneCrore.read.ReadAllStocks;
import com.trader.oneCrore.repository.CHILDRepository;
import com.trader.oneCrore.repository.STOCKRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner  implements CommandLineRunner {
    @Autowired
    private STOCKRepository stockRepository;

    @Autowired
    private CHILDRepository childRepository;
    @Override
    public void run(String... args) throws Exception {
      //  stockRepository.saveAll(ReadAllStocks.getAllIndianStocks());





    }
}
