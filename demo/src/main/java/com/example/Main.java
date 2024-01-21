package com.example;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

// import io.github.cdimascio.dotenv.Dotenv;
// import io.github.cdimascio.dotenv.DotenvEntry;


public class Main {
    public static int whoami() {
        System.out.println("in main");
        return 1;
    }
    public static void main(String[] args) {
        try {
            String easyString = FileUtils.readFileToString(new File("example.json"), StandardCharsets.UTF_8);  
            Type mapType = new TypeToken<Map<String, Object>>(){}.getType();  
            Map<String, Object> json = new Gson().fromJson(easyString, mapType);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(123);

    }
}