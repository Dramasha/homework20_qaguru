package com.demoqa.data;

import com.github.javafaker.Faker;

public class DataFaker {
    public String getBookId() {
        String[] bookId = {"9781491904244", "9781491950296", "9781593275846", "9781593277574",
                "9781449331818", "9781449337711", "9781449365035", "9781449325862"};
        return new Faker().options().option(bookId);
    }
}

