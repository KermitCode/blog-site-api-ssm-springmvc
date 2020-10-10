package cn.api04007.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int id;
    private String comUid;
    private int comArid;
    private String comText;
    @JsonIgnore
    private int comTime;
    private String comIp;
    private String comDatetime;
}
