package com.haufe.forum.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by StolojescuI
 */
@Data
public class User {
    private String id;
    private String userName;
    private Date joinDate;

    public User(){}
    public User(String userName){
        this.userName = userName;
    }
}
