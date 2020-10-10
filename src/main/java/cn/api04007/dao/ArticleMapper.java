package cn.api04007.dao;

import cn.api04007.pojo.Article;

import java.util.HashMap;
import java.util.List;

public interface ArticleMapper {

    //文章分页列表，可按文章分类筛选
    public List<Article> getArticleList(HashMap map);

    //取文章详情
    public Article getArticleDetail(int id);
}
