package Dao;


import Model.Product;

public interface UserLoginDao {

    Product save(Product product);

    Product findProductById(Long id);

}
