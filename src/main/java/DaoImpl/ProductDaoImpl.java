package DaoImpl;

import Constants.SqlConstants;
import Dao.ProductDao;
import Model.Category;
import Model.Product;
import Model.Unit;
import connection.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {


    @Override
    public Product save(Product product) {
        String sql = SqlConstants.SAVE_PRODUCT;

        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setString(1,product.getName());
                preparedStatement.setDouble(2,product.getPrice());
                preparedStatement.setLong(3,product.getCategory().getId());
                preparedStatement.setLong(4,product.getUnit().getId());
                int exist =  preparedStatement.executeUpdate();
                if(exist>0){
                    ResultSet resultSet = preparedStatement.getGeneratedKeys();
                    if(resultSet.next()){
                        product.setId(resultSet.getLong(1));
                    }
                }
                return product;
        }catch (SQLException ex){
            throw new IllegalStateException("exception happened while adding product to database!");
        }
    }

    @Override
    public Product findProductById(Long id) {
        String sql = SqlConstants.FIND_BY_PRODUCT;
        try (Connection connection = DbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Category category = new Category(resultSet.getString("cat.name"));
                Unit unit = new Unit(resultSet.getString("unit.name"));
                Product product = new Product(resultSet.getString("pro.name"),resultSet.getDouble("price"),category,unit);
                return product;
            }
            return null;
        }catch(SQLException ex){
            throw new IllegalStateException("System Xetasi");
        }
    }

    @Override
    public List<Product> allProduct() {
        String sql = "select pr.id,pr.name,pr.price,cat.name,unit.name, pr.is_active from product pr join category cat\n" +
                "on pr.product_type_id=cat.id join unit\n" +
                "on pr.unit_id = unit.id";
        List<Product> productList = new ArrayList<>();
        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getLong("pr.id"));
                product.setName(rs.getString("pr.name"));
                product.setPrice(rs.getDouble("pr.price"));
                product.setCategory(new Category(rs.getString("cat.name")));
                product.setUnit(new Unit(rs.getString("unit.name")));
                product.setIsActive(rs.getInt("pr.is_active"));
                productList.add(product);
            }
            return productList;
        }catch (SQLException ex){
            ex.printStackTrace();
            throw new IllegalStateException("system xetasi");
        }
    }
}
