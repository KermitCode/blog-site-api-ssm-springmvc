package cn.api04007.controllers;

import cn.api04007.pojo.Category;
import cn.api04007.services.CategoryService;
import cn.api04007.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@SuppressWarnings("unchecked")
//文章分类控制器
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category/list")
    //提取所有文章分类数据接口
    public String categoryList(){

        List<Category>  cateList = categoryService.getAllCategory();

        //放入hash结构统一json返回。
        HashMap mapData = new HashMap<>();
        mapData.put("category", cateList);
        return JsonUtil.jsonOk(mapData);
    }
}
