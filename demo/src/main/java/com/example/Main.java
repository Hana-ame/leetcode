package com.example;

import java.util.ArrayList;

public class Main {
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

        ArrayList arr = Utils.getDataFromJsonFile("5TxKek.json");
        System.out.println(arr);
        System.out.println(arr.getClass());
        System.out.println(arr.get(1).getClass());
        
    }
}