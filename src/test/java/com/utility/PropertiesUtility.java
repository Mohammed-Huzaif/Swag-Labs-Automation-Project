package com.utility;

import com.constants.Env;
import com.ui.pages.ProductsPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

    //read property file

   public static String readProperty(Env env, String propertyName){
       File propFile = new File(System.getProperty("user.dir") + "//config//" + env + ".properties" );
       FileReader fileReader;
       Properties properties = new Properties();
       try {
           fileReader = new FileReader(propFile);
           properties.load(fileReader);
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       }
       catch (IOException e) {
           throw new RuntimeException(e);
       }

       return properties.getProperty(propertyName.toUpperCase());

   }
}
