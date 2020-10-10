package cn.api04007.services;

import cn.api04007.pojo.Article;

import java.util.HashMap;
import java.util.List;

public interface ArticleService {

    public List<Article> getArticleList(int cateId, int pageId);

    public Article getArticleDetail(int id);
}
