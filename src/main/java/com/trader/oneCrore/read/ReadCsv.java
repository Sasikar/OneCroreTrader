package com.trader.oneCrore.read;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.trader.oneCrore.repository.CHILDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.text.ParseException;
import java.util.List;


public class ReadCsv implements Runnable {
    private String filePath = null;

    private int no;

    @Autowired
    private CHILDRepository childRepository;

    private String symbolName;

    public ReadCsv(String filePath, int no, CHILDRepository childRepository, String symbolName) {
        this.filePath = filePath;
        this.no = no;
        this.childRepository = childRepository;
        this.symbolName = symbolName;
    }

    @Override
    public void run() {
       // System.out.println(this.filePath);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String fullPath = null;
        if (no % 2 == 0) {
            fullPath = "G:\\Batch_2\\"+this.filePath+".csv";
        } else {
            fullPath = "G:\\Batch_1\\"+this.filePath+".csv";
        }
        try {
            Reader reader = new BufferedReader(new FileReader(fullPath));
            CsvToBean<CsvHelper> csvReader = new CsvToBeanBuilder(reader)
                    .withType(CsvHelper.class)
                    .withSeparator(',')
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();
            List<CsvHelper> results = csvReader.parse();
          CsvHelper csvFinal = results.stream().skip(results.size()-1).findFirst().get();
            csvFinal.setSymbolName(this.symbolName);
            childRepository.save(DBMapper.rowMapper(csvFinal));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(fullPath);
    }
}
