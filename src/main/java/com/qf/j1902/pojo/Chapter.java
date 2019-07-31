package com.qf.j1902.pojo;

import lombok.Data;

@Data
public class Chapter {
    private Integer chapterid;  //章节id

    private Integer courseid;  //课程id

    private String chapterorder;  //章节顺序

    private String chaptername;  //章节名

    private String chapterurl;  //章节路径

    private Integer chaptertimes;  //章节时长

}