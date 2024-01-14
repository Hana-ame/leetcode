package com.example;

import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Dotenv dotenv = Dotenv.load();
        String env = dotenv.get("MY_ENV_VAR1");
        System.out.println(env);

    }
}