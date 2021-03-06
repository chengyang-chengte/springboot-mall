package com.kujudy.springbootmall.service;

import com.kujudy.springbootmall.constant.ProductCategory;
import com.kujudy.springbootmall.dto.ProductQueryParams;
import com.kujudy.springbootmall.dto.ProductRequest;
import com.kujudy.springbootmall.model.Product;

import java.util.List;

/**
 * <p>公司訊息: ChengYang Info</p>
 * <p>專案名稱: springboot-mall </p>
 * <p>檔案名稱: ProductSecvice </p>
 * <p>描述:  </p>
 * <p>建立時間: 20220316 </p>
 *
 * @author cheng
 * @version 1.0
 * [序號][日期] [更改人姓名][變更描述]
 */
public interface ProductService {
    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
