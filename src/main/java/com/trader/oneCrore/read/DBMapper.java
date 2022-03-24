package com.trader.oneCrore.read;

import com.trader.oneCrore.entity.Child;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DBMapper {

    public static Child rowMapper(CsvHelper csvHelper) throws ParseException {
        Child child = new Child();
        String pattern = "yyyy-MM-dd'T'HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        child.setCreationDate(new Timestamp(df.parse(csvHelper.getTime()).getTime()));
        child.setSasiBuy(csvHelper.getGoldenBeforeBuy());
        child.setGoldenBuy(csvHelper.getOrginalGoldenCross());
        child.setSuperBuy(csvHelper.getSuperBuy());
        child.setSymbol(csvHelper.getSymbolName());
        return child;

    }
}
