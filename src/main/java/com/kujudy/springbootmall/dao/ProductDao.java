package com.kujudy.springbootmall.dao;

import com.kujudy.springbootmall.model.Product;

/**
 * <p>公司訊息: ChengYang Info</p>
 * <p>專案名稱: springboot-mall </p>
 * <p>檔案名稱: ProductDao </p>
 * <p>描述:  </p>
 * <p>建立時間: 20220316 </p>
 *
 * @author cheng
 * @version 1.0
 * [序號][日期] [更改人姓名][變更描述]
 */
public interface ProductDao {
    Product getProductById(Integer productId);

}
