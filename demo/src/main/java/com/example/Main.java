package com.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList arr = Utils.getDataFromJsonFile("5TxKek.json");
        System.out.println(arr);
        System.out.println(arr.getClass());
        System.out.println(arr.get(1).getClass());
        
    }
}