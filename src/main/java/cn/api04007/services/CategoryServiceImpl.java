package cn.api04007.services;

import cn.api04007.dao.CategoryMapper;
import cn.api04007.pojo.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    //取得所有分类数据
    public List<Category> getAllCategory() {
        return categoryMapper.getAllCategory();
    }

}
