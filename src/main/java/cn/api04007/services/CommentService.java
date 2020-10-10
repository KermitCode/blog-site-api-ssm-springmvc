package cn.api04007.services;

import cn.api04007.pojo.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> getComment(int page);
}
