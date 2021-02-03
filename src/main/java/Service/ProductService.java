package Service;

import Model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    Product findProductById(Long id);

    List<Product> allProduct();
}
