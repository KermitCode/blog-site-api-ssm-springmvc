package cn.api04007.services;


import cn.api04007.conf.BaseConfig;
import cn.api04007.dao.ArticleMapper;
import cn.api04007.pojo.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    //文章分类service接口：参数分类ID和页数
    public List<Article> getArticleList(int cateId, int pageId){

        int page = Math.max(pageId, 1);
        HashMap map = new HashMap();
        map.put("start", (pageId-1) * BaseConfig.ARTICLE_PAGESIZE);
        map.put("pageSize", BaseConfig.ARTICLE_PAGESIZE);
        map.put("cateId", cateId);

        return articleMapper.getArticleList(map);

    }

    @Override
    //文章详情接口：参数文章ID
    public Article getArticleDetail(int id) {

        return articleMapper.getArticleDetail(id);

    }
}
