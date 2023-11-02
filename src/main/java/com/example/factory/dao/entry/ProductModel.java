package com.example.factory.dao.entry;

import lombok.Data;

/**
  *@ClassName ProductModel
  *@Author wzh
  *@Version 1.0
  *@DATE 2023/10/9

  *@Description 数据表Product的对象模型
  *@param
  *@return
*/
@Data
public class ProductModel {
    private Long id;
    private String productName;
    private Long dirId;
    private double salePrice;
    private String supplier;
    private String brand;
    private double cutoff;
    private double costPrice;
}
