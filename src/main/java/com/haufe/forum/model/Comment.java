package com.haufe.forum.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by StolojescuI
 */
@Data
public class Comment {
    private String id;
    private String content;
    private Date publishedDate;
    private User author;
}
