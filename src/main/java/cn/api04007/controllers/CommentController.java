package cn.api04007.controllers;

import cn.api04007.pojo.Article;
import cn.api04007.pojo.Comment;
import cn.api04007.services.CommentService;
import cn.api04007.utils.DateUtil;
import cn.api04007.utils.HtmlUtil;
import cn.api04007.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@RestController
//评论数据返回接口
public class CommentController {

    private CommentService commentService;

    @GetMapping("/comment/list/{pageId}")
    //评论列表页：需要页数参数pageId
    public String getCommentList(@PathVariable("pageId") Integer pageId){

        List<Comment> commentList = commentService.getComment(pageId);


        for(int i=0; i<commentList.size(); i++){
            Comment comment = commentList.get(i);

            //将评论中的时间戳值转换为可读的日期时间
            comment.setComDatetime(DateUtil.toDatetime(comment.getComTime()));

            commentList.set(i, comment);
        }

        //统一返回json
        HashMap hashMap = new HashMap();
        hashMap.put("comment", commentList);

        return JsonUtil.jsonOk(hashMap);
    }

}
