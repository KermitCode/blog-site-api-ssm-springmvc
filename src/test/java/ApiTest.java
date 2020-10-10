//import cn.api04007.pojo.Article;
//import cn.api04007.pojo.Category;
//import cn.api04007.pojo.Comment;
//import cn.api04007.services.ArticleService;
//import cn.api04007.services.CategoryService;
//import cn.api04007.services.CommentService;
//import cn.api04007.utils.HtmlUtil;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.transaction.event.TransactionalEventListener;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class ApiTest {
//
//    private static ApplicationContext context ;
//
//    static {
//        context = new ClassPathXmlApplicationContext("applicationContext.xml");
//    }
//
//    //测试类目数据读取
//    public void test1(){
//
//        CategoryService categoryServiceImpl = (CategoryService) context.getBean("categoryServiceImpl");
//        List<Category> categoryList = categoryServiceImpl.getAllCategory();
//
//        for (Category category : categoryList) {
//            System.out.println(category);
//        }
//
//    }
//
//    @Test
//    //测试评论数据读取
//    public void test2(){
//
//        CommentService commentServiceImpl = (CommentService) context.getBean("commentServiceImpl");
//
//        List<Comment> commentList = commentServiceImpl.getComment(1);
//        for (Comment comment : commentList) {
//            System.out.println(comment);
//        }
//    }
//
//    @Test
//    //测试文章列表数据读取
//    public void test3(){
//
//        ArticleService articleServiceImpl = (ArticleService) context.getBean("articleServiceImpl");
//        List<Article> articleList =  articleServiceImpl.getArticleList(0, 1);
//        for (Article article : articleList) {
//
//            article.setArText(HtmlUtil.filterHtml(article.getArText()));
//            System.out.println(article);
//        }
//        System.out.println("--------------");
//    }
//
//    @Test
//    //测试文章详情数据读取
//    public void test4(){
//
//        ArticleService articleServiceImpl = (ArticleService) context.getBean("articleServiceImpl");
//        Article article =  articleServiceImpl.getArticleDetail(22);
//        article.setArText(HtmlUtil.subString(HtmlUtil.filterHtml(article.getArText()),100));
//        System.out.println(article);
//
//        System.out.println("--------------");
//    }
//
//
//}
