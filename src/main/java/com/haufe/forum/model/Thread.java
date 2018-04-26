package com.haufe.forum.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by StolojescuI
 */
@Document
@Data
public class Thread {
    @Id
    private String id = ObjectId.get().toHexString();
    private String title;
    private String description;
    private Integer views;
    private List<Comment> comments = new ArrayList<>();
    private User author = new User();

    public Thread(){}

    public Thread(String title, String description, int views, List<Comment> comments, User author){
        this.title = title;
        this.description = description;
        this.views = views;
        this.comments = comments;
        this.author = author;

    };


    public int getReplies(){
        return this.comments.size();
    }

}
