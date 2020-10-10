package cn.api04007.services;

import cn.api04007.conf.BaseConfig;
import cn.api04007.dao.CommentMapper;
import cn.api04007.pojo.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    //读取评论数据：参数页数
    public List<Comment> getComment(int page){

        page = Math.max(page, 1);
        int start = (page-1) * BaseConfig.COMMENT_PAGESIZE;

        return commentMapper.getComment(start, BaseConfig.COMMENT_PAGESIZE);
    }

}
