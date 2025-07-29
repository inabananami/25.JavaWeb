package com.itheima.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itheima.anno.State;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @NotNull(groups = {Update.class, Detail.class, Delete.class})
    private Integer id;//主键ID
    @Pattern(regexp = "^\\S{1,10}$", groups = {Add.class, Update.class})
    private String title;//文章标题
    @NotNull(groups = {Add.class, Update.class})
    private String content;//文章内容
    //url状态的图像
    @Pattern(regexp = "https?://[^\s]+", groups = {Add.class, Update.class})
    private String coverImg;//封面图像
    @State(groups = {Add.class, Update.class})
    private String state;//发布状态 已发布|草稿
    @NotNull(groups = {Add.class, Update.class})
    private Integer categoryId;//文章分类id
    private Integer createUser;//创建人ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;//更新时间

    public interface Add {}
    public interface Detail {}
    public interface Update {}
    public interface Delete {}
}
