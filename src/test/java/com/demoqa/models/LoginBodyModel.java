package com.demoqa.models;

import lombok.Data;

@Data
public class LoginBodyModel {
    private String userName, password;
}