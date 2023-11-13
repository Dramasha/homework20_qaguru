package com.demoqa.data;

public class DataTest {
    public DataFaker dataFaker = new DataFaker();
    public String bookId = dataFaker.getBookId();
    public String login = "QAGuruUser";
    public String password = "Password123!";
}