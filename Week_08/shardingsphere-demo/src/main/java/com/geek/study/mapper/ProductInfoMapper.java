package com.geek.study.mapper;

import com.geek.study.bo.ProductInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Copyright (C), 2021
 * FileName: ProductInfoMapper
 * Author:   xzw
 * Date:     2021/3/5 21:43
 * Description:
 */
@Repository
public interface ProductInfoMapper {

    ProductInfo queryProductInfo();

    int updateProductInfo(@Param("id") Long id, @Param("productName") String productName);

    int saveNewProductInfo(ProductInfo info);
}
