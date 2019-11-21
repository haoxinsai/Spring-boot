package com.test.tests_b.model;

import lombok.Data;

@Data
public class Quesstion {
    private Integer Id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String  tag;

}
