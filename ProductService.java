package products;

import java.util.List;
import java.sql.Connection;

public class ProductService {
    ProductDao Dao;
    public ProductService(){
        Connection connection =DbUtl.getConnection();
        this.Dao = new ProductDao(connection);
    }

    public ProductRecord findById(int id) {
        ProductRecord product = Dao.findById(id);
        if (product == null) {
            throw new ProductNotFoundException();
        }
        return product;
    }
    public List<ProductRecord> findByName(String name){
        var list = Dao.findByName(name);
        return list;
    }

    public int insert(ProductRecord PR) {
        var result = Dao.insert(PR);
        return result;
    }

    public int update(ProductRecord PR){
        var result = Dao.update(PR);
        return result;
    }

    public int delete(int del){
        var result = Dao.delete(del);
        return result;
    }

}
