package com.haufe.forum.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by StolojescuI
 */
@ToString
@Document
@Data
public class Forum {
    @Id
    private String id;
    private String title;
    private String description;
    private String pictureUri;
    private List<Thread> threads = new ArrayList<>();

}
