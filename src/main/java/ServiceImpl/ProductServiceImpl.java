package ServiceImpl;

import Dao.ProductDao;
import DaoImpl.ProductDaoImpl;
import Model.Product;
import Model.UserLogin;
import Service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductDao productDao = new ProductDaoImpl();
    @Override
    public Product saveProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    public Product findProductById(Long id) {
        return productDao.findProductById(id);
    }

    @Override
    public List<Product> allProduct() {
        return productDao.allProduct();
    }
}
