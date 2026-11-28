package com.api.utils;

import com.api.request.model.*;
import com.github.javafaker.Faker;

import java.util.*;

public class FakerDataGenerator {

    private static Faker faker=new Faker(new Locale("en-IND"));
    private static final String COUNTRY="INDIA";
    private static Random random=new Random();
    private static int validProblemsId[]={1,2,3,4,5,6,7,8,9,10,11,12,15,16,17,19,20,22,24,26,27,28,29};

    private FakerDataGenerator(){

    }

    public static Customer generateFakeCustomerData(){
        String fname=faker.name().firstName();
        String lname=faker.name().lastName();
        String mobileNumber=faker.numerify("70########");
        String altMobileNumber=faker.numerify("70########");
        String emailId=faker.internet().emailAddress();
        String altEmailId=faker.internet().emailAddress();

        return new Customer(fname,lname,mobileNumber,altMobileNumber,emailId,altEmailId);
    }

    public static CustomerAddress generateFakeCustomerAddressData(){
        String flatNumber=faker.numerify("###");
        String apartmentName=faker.address().streetName();
        String streetName=faker.address().streetName();
        String landmark=faker.address().streetName();
        String area=faker.address().streetName();
        String pincode=faker.numerify("#####");
        String state=faker.address().state();

        return new CustomerAddress(flatNumber,apartmentName,
                streetName,landmark,area,pincode,COUNTRY,state);
    }

    public static CustomerProduct generateFakeCustomerProductData(){

        String dop=DateTimeUtil.getTimeWithDaysAgo(10);
        String imeiSerialNumber=faker.numerify("###############");
        String popUrl=faker.internet().url();

                return new CustomerProduct(dop,imeiSerialNumber,imeiSerialNumber,
                        imeiSerialNumber,popUrl,1,1);
    }

    public static List<Problems> generateFakeProblems(){

        int count =random.nextInt(3)+1;
        int randomIndex;
        String fakeRemarks;
        Problems problems;
        List<Problems> problemsList=new ArrayList<Problems>();

        for(int i=0;i<count;i++){
        randomIndex=random.nextInt(validProblemsId.length);
        fakeRemarks=faker.lorem().sentence(5);

        problems=new Problems(validProblemsId[randomIndex], fakeRemarks);
        problemsList.add(problems);
        }
        return problemsList;
    }

    public static CreateJobPayload generateFakeCreateJobData(){

        Customer customer=generateFakeCustomerData();
        CustomerAddress customerAddress=generateFakeCustomerAddressData();
        CustomerProduct customerProduct=generateFakeCustomerProductData();
        List<Problems> problemsList=generateFakeProblems();

        CreateJobPayload payload=new CreateJobPayload(0,2,1,1,customer,customerAddress,customerProduct,problemsList);
        return payload;
    }

    public static Iterator<CreateJobPayload> generateFakeCreateJobData(int count){

        List<CreateJobPayload> payloadList=new ArrayList<CreateJobPayload>();
        for (int i=0;i<count;i++) {
            Customer customer = generateFakeCustomerData();
            CustomerAddress customerAddress = generateFakeCustomerAddressData();
            CustomerProduct customerProduct = generateFakeCustomerProductData();
            List<Problems> problemsList = generateFakeProblems();

            CreateJobPayload payload = new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customerProduct, problemsList);
            payloadList.add(payload);
        }
        return payloadList.iterator();
    }
}
