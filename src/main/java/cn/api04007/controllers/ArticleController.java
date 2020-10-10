package cn.api04007.controllers;

import cn.api04007.pojo.Article;
import cn.api04007.services.ArticleService;
import cn.api04007.utils.DateUtil;
import cn.api04007.utils.HtmlUtil;
import cn.api04007.utils.JsonUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@RestController
//文章控制器：文章列表接口以及文章详情接口
public class ArticleController {

    private ArticleService articleService;

    @GetMapping("/article/list/{cateId}/{pageId}")
    //文章列表接口：传入文章分类cateId和页数：pageId
    public String getArticleList(@PathVariable("cateId") int cateId, @PathVariable("pageId") int pageId){

        //取得文章分页数据
        List<Article> articleList =  articleService.getArticleList(cateId, pageId);

        //处理文章详情
        for(int i=0; i<articleList.size(); i++){
            Article article = articleList.get(i);

            //过滤文章中的html字符串、以及换行、空格等内容
            String text = HtmlUtil.filterHtml(article.getArText());

            //截取文章前280个字符，并在末尾添加省略号，以从列表使用
            text = HtmlUtil.subString(text, 280);
            article.setArText(text+"...");

            //将文章中的时间戳值转换为可读的日期时间
            article.setArDatetime(DateUtil.toDatetime(article.getArTime()));

            articleList.set(i, article);
        }

        //放入hash结构统一返回json
        HashMap hashMap = new HashMap();
        hashMap.put("article", articleList);

        return JsonUtil.jsonOk(hashMap);
    }

    @GetMapping("/article/{id}")
    //文章详情接口：传入文章id
    public String getArticleDetail(@PathVariable("id") int id){

        Article article =  articleService.getArticleDetail(id);

        if(article != null){
            //文章存在更换一下时间样式
            article.setArDatetime(DateUtil.toDatetime(article.getArTime()));
        }else{
            //文章不存在响应code及失败信息
            return JsonUtil.jsonError("未找到对应文章");
        }

        //放入hash结构统一返回json
        HashMap hashMap = new HashMap();
        hashMap.put("article", article);
        return JsonUtil.jsonOk(hashMap);
    }
}
