package com.example;

import java.io.File;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

// import io.github.cdimascio.dotenv.Dotenv;
// import io.github.cdimascio.dotenv.DotenvEntry;


public class Main {
    public static void main(String[] args) {
        try {
            String exampleRequest = FileUtils.readFileToString(new File("example.json"), StandardCharsets.UTF_8);  
            System.out.println(exampleRequest);          
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}