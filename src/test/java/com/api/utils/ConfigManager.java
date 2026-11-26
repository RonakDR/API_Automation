package com.api.utils;

import java.io.*;
import java.net.StandardSocketOptions;
import java.util.Properties;

public class ConfigManager {

    private static Properties prop;
    private static String path="config/config.prop";
    private static String env;
    static {
        env=System.getProperty("env","QA");

        prop=new Properties();

        //File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.prop");
        InputStreamReader isr=new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(path));
        if(isr==null){
            throw new RuntimeException("Can not read the file at path :"+path);
        }
        try {
            prop.load(isr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
       // System.out.println("Env value is : "+env);
        return prop.getProperty(env+"."+key);
    }

}
