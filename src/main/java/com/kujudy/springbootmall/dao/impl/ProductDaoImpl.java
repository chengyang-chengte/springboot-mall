package com.kujudy.springbootmall.dao.impl;

import com.kujudy.springbootmall.constant.ProductCategory;
import com.kujudy.springbootmall.dao.ProductDao;
import com.kujudy.springbootmall.dto.ProductQueryParams;
import com.kujudy.springbootmall.dto.ProductRequest;
import com.kujudy.springbootmall.model.Product;
import com.kujudy.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
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
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        String sql="SELECT product_id, product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date " +
                "FROM product WHERE 1=1";
        Map<String, Object> map = new HashMap<>();

        if (productQueryParams.getCategory()!=null)
        {
            sql=sql+ " AND category= :category";
            map.put("category", productQueryParams.getCategory().name());
        }

        if (productQueryParams.getSearch()!=null)
        {
            sql=sql+ " AND product_name LIKE :search";
            map.put("search", "%" + productQueryParams.getSearch() +"%");
        }

        sql=sql+ " ORDER BY "+productQueryParams.getOrderBy()+ " "+productQueryParams.getSort();

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        return productList;
    }

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

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql="INSERT INTO product (product_name, category, image_url, price, stock, " +
                "description, created_date, last_modified_date) " +
                "VALUES (:productName, :category, :image_url, :price, :stock, :description, " +
                ":createdDate, :lastModifiedDate);";

        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("image_url", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        Date now=new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder=new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map),keyHolder);

        int productId= keyHolder.getKey().intValue();

        return productId;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        String sql="UPDATE product SET product_name=:productName, category=:category, image_url=:image_url, " +
                "price=:price, stock=:stock, description=:description, last_modified_date=:lastModifiedDate "+
                " WHERE product_id=:productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("image_url", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        map.put("lastModifiedDate", new Date());
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteProductById(Integer productId) {
        String sql="DELETE FROM product WHERE product_id=:productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, map);

    }
}
