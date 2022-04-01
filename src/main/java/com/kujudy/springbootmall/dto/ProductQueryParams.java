package com.kujudy.springbootmall.dto;

import com.kujudy.springbootmall.constant.ProductCategory;

/**
 * <p>公司訊息: ChengYang Info</p>
 * <p>專案名稱: springboot-mall </p>
 * <p>檔案名稱: ProductQueryParams </p>
 * <p>描述:  </p>
 * <p>建立時間: 20220401 </p>
 *
 * @author cheng
 * @version 1.0
 * [序號][日期] [更改人姓名][變更描述]
 */
public class ProductQueryParams {
    private ProductCategory category;
    private String search;
    private String orderBy;
    private String sort;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
