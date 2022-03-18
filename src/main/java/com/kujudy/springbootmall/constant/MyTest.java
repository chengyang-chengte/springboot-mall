package com.kujudy.springbootmall.constant;

/**
 * <p>公司訊息: ChengYang Info</p>
 * <p>專案名稱: springboot-mall </p>
 * <p>檔案名稱: MyTest </p>
 * <p>描述:  </p>
 * <p>建立時間: 20220316 </p>
 *
 * @author cheng
 * @version 1.0
 * [序號][日期] [更改人姓名][變更描述]
 */
public class MyTest {
    public static void main(String args){
        ProductCategory category =ProductCategory.FOOD;
        String s= category.name();
        System.out.println(s);

        String s2= "CAR";
        ProductCategory category2 =ProductCategory.valueOf(s2);

    }
}
