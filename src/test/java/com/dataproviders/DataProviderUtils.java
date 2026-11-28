package com.dataproviders;

import com.api.dataproviders.bean.CreateJobBean;
import com.api.dataproviders.bean.UserBean;
import com.api.request.model.CreateJobPayload;
import com.api.utils.CSVReaderUtility;
import com.api.utils.CreateJobBeanMapper;
import com.api.utils.FakerDataGenerator;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUtils {

    @DataProvider(name="LoginAPIDataProvider",parallel = true)
    public static Iterator<UserBean> loginAPIDataProvider(){
        return CSVReaderUtility.readCSV("testData/LoginCred.csv", UserBean.class);
    }

    @DataProvider(name="CreateJobDataProvider",parallel = true)
    public static Iterator<CreateJobPayload> createJobDataProvider(){
        Iterator<CreateJobBean> createJobBeanIterator=CSVReaderUtility.readCSV("testData/CreateJobData.csv", CreateJobBean.class);

        List<CreateJobPayload> payloadList=new ArrayList<CreateJobPayload>();
        CreateJobBean tempBean;
        CreateJobPayload tempPayload;
        while(createJobBeanIterator.hasNext()){
            tempBean=createJobBeanIterator.next();
            tempPayload= CreateJobBeanMapper.mapper(tempBean);
            payloadList.add(tempPayload);
        }
        return payloadList.iterator();
    }


    @DataProvider(name="CreateJobFakerDataProvider",parallel = true)
    public static Iterator<CreateJobPayload> createJobFakerDataProvider(){
        return FakerDataGenerator.generateFakeCreateJobData(10);
    }
}
