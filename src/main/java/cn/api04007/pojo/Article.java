package cn.api04007.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private int id;
    private short arCid;
    private String arTitle;
    private String arTags;

    @JsonIgnore
    private int arTime;
    private String arText;
    private int arView;
    private int arComments;

    //文章分类对象
    private Category arCate;

    private String arDatetime;
}
