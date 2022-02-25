package com.trader.oneCrore.read;

public class ReadCsv  implements  Runnable{
    private String filePath = null;

    public ReadCsv(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
System.out.println(this.filePath);
    }
}
