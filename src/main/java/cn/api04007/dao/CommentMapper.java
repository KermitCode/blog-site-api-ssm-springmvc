package cn.api04007.dao;

import cn.api04007.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    //取得评论列表
    public List<Comment> getComment(@Param("start") int start, @Param("pageSize") int pageSize);

}
