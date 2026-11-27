package com.dataproviders;

import com.api.dataproviders.bean.UserBean;
import com.api.utils.CSVReaderUtility;
import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class DataProviderUtils {

    @DataProvider(name="LoginAPIDataProvider",parallel = true)
    public static Iterator<UserBean> loginAPIDataProvider(){
        return CSVReaderUtility.readCSV("testdata/LoginCred.csv");
    }
}
