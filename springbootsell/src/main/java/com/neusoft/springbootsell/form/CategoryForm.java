package com.neusoft.springbootsell.form;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CategoryForm {
    private Integer categoryId;//类目id（如龙虾类，烧烤类等）
    private String categoryName;//类目名称
    private Integer categoryType;//类目名编号（方便排序等）
}
