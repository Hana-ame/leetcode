package com.example;

import java.io.File;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

public class Utils {
  // number -> Double
  // 
  public static <T> T getDataFromJsonFile(String pathname) {
    T json = null;
    try {
      String easyString = FileUtils.readFileToString(new File(pathname), StandardCharsets.UTF_8);  
      Type jsonType = new TypeToken<T>(){}.getType();  
      json = new Gson().fromJson(easyString, jsonType);
      return json;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return json;
  }
}
