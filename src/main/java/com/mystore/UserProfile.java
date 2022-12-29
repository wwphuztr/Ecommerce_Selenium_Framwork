package com.mystore;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.util.List;

@Data
public class UserProfile {
    @CsvBindByName
    private String user;
    @CsvBindByName
    private String pwd;
    @CsvBindByName
    private String exp;
}
