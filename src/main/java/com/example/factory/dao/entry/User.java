package com.example.factory.dao.entry;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private  int type;
}
