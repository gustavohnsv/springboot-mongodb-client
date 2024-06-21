package com.gustavohnsv.clients.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "clients")
public class Client {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String email;
    private String address;

}
