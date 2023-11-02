package service;





import com.example.factory.dao.entry.ProductModel;
import com.example.factory.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IndexService {
    public List<ProductModel> find(){
        /**
          *@ClassName IndexService
          *@Author wzh
          *@Version 1.0
          *@DATE 2023/10/9

          *@Description "/pro"的service层
         * *@param []
          *@return java.util.List<com.example.demo2.dao.ProductModel>
        */

        String sql = "select * from product";
        List<ProductModel> pro = new ArrayList<>();

        JDBCUtil jdbc = JDBCUtil.getInstance();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = JDBCUtil.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id");
                String productName = rs.getString("productName");
                Long dirId = rs.getLong("dir_id");
                double salePrice = rs.getDouble("salePrice");
                String supplier = rs.getString("supplier");
                String brand = rs.getString("brand");
                double cutoff = rs.getDouble("cutoff");
                double costPrice = rs.getDouble("costPrice");

                ProductModel productModel = new ProductModel();
                productModel.setId(id);
                productModel.setProductName(productName);
                productModel.setDirId(dirId);
                productModel.setSalePrice(salePrice);
                productModel.setSupplier(supplier);
                productModel.setBrand(brand);
                productModel.setCutoff(cutoff);
                productModel.setCostPrice(costPrice);

                pro.add(productModel);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return pro;
    }
}
