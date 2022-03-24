package com.trader.oneCrore.read;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CsvHelper {

    private String symbolName;

    @CsvBindByName(column = "Super_Buy")
    private String superBuy;

    @CsvBindByName(column = "Golden_Before_Buy")
    private String goldenBeforeBuy;

    @CsvBindByName(column = "Orginal_Golden_Cross")
    private String orginalGoldenCross;

    @CsvBindByName(column = "time")
    private String time;


}
