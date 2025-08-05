package com.inabananami.japanesedemo.dao.pojo;

import com.inabananami.japanesedemo.vo.WordVo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Word {
    @NotNull(groups = {Get.class,Update.class})
    private Integer id;
    @Pattern(regexp = "^[\\u3040-\\u309F\\u30A0-\\u30FFー\\u4E00-\\u9FFF]+$", message = japaneseMessage)
    private String japaneseWord;
    @Pattern(regexp = "^[\\u4E00-\\u9FFF，]+$",message = "只能输入中文汉字")
    private String chineseWord;
    @Pattern(regexp = "^[a-z]+$",message = "只能输入小写英文字母")
    private String romaji;
    @Pattern(regexp = "^[\\u3040-\\u309F\\u30A0-\\u30FFー]+$", message = "只能输入假名")
    private String kana;
    @Pattern(regexp = "^[\\u3040-\\u309F\\u30A0-\\u30FFー\\u4E00-\\u9FFF・]+$",message = japaneseMessage)
    private String type;
    @Pattern(regexp = "^[\\u3040-\\u309F\\u30A0-\\u30FFー\\u4E00-\\u9FFF。、]+$",message = japaneseMessage)
    private String exampleSentence;
    private Integer createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private static final String japaneseMessage = "只能输入日语汉字和假名";

    public WordVo toVo() {
        return new WordVo (
            this.japaneseWord, this.chineseWord, this.romaji, this.kana, this.type, this.exampleSentence
        );
    }


    public interface Get {}
    public interface Update {}
}