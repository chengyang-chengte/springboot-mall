package com.kujudy.springbootmall.dao.impl;

import com.kujudy.springbootmall.dao.ProductDao;
import com.kujudy.springbootmall.model.Product;
import com.kujudy.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>公司訊息: ChengYang Info</p>
 * <p>專案名稱: springboot-mall </p>
 * <p>檔案名稱: ProductDaoImpl </p>
 * <p>描述:  </p>
 * <p>建立時間: 20220316 </p>
 *
 * @author cheng
 * @version 1.0
 * [序號][日期] [更改人姓名][變更描述]
 */
@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {
        String sql="SELECT product_id, product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date " +
                "FROM product WHERE product_id=:productId";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        if(productList.size()>0)
        {
            return productList.get(0);
        }
        else
        {
            return null;
        }


    }
}
