package com.inabananami.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    public static final Integer Article_TOP = 1;
    public static final Integer Article_Common = 0;
    private Long id;
    private String title;
    private Integer summary;
    private Integer commentCounts;
    private Integer viewCounts;
//    作者id
    private Long anthorId;
//    内容id
    private Long bodyId;
//    类别id
    private Long categoryId;
//    置顶
    private Integer weight = Article_Common;
//    创建时间
    private LocalDate createDate;
}
