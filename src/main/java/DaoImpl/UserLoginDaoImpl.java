package DaoImpl;

import Constants.SqlConstants;
import Dao.UserLoginDao;
import Model.Category;
import Model.Product;
import Model.Unit;
import Model.UserLogin;

import java.sql.*;

import Connection.DbConnection;
public class UserLoginDaoImpl implements UserLoginDao {


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
}
