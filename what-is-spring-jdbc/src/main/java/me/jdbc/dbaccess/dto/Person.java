package me.jdbc.dbaccess.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    private int id;
    private String name;
    private String workAt;
    private String speciality;
    private int age;
    private String phoneNumber;
}
