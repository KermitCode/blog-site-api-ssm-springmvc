package cn.api04007.services;

import cn.api04007.pojo.Category;

import java.util.List;

public interface CategoryService {

    //读取文章类目列表
    public List<Category> getAllCategory();
}
