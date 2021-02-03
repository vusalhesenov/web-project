package Dao;


import Model.Product;

import java.util.List;

public interface ProductDao {

    Product save(Product product);

    Product findProductById(Long id);

    List<Product> allProduct();

}
