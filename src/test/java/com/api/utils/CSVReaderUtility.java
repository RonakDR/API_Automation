package com.api.utils;

import com.api.dataproviders.bean.UserBean;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {

    private CSVReaderUtility(){}

    public static <T> Iterator<T> readCSV(String path,Class<T> bean){

            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
            InputStreamReader isr = new InputStreamReader(is);
            CSVReader csvr = new CSVReader(isr);

        CsvToBean<T> csvToBean=new CsvToBeanBuilder(csvr)
                .withType(bean)
                .withIgnoreEmptyLine(true)
                .build();

        List<T> list=csvToBean.parse();
        return list.iterator();
    }
}
