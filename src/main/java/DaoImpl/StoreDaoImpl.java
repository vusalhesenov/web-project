package DaoImpl;

import Dao.StoreDao;
import Model.Store;
import connection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreDaoImpl implements StoreDao {
    @Override
    public List<Store> findAll() {
        String sql = "SELECT st.id , quantity , pr.name, st.is_active, st.insert_date FROM store st join product pr on st.product_id = pr.id";
        List<Store> storeList = new ArrayList<>();
        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Store store = new Store();
                store.setId(rs.getLong("st.id"));
                store.setQuantity(rs.getDouble("quantity"));
                store.setName(rs.getString("pr.name"));
                store.setIsActive(rs.getInt("st.is_active"));
                store.setInsertDate(rs.getDate("st.insert_date"));
                storeList.add(store);
            }
            return storeList;

        }catch (SQLException ex){
            ex.printStackTrace();
            throw new IllegalStateException("System Xetasi!");
        }
    }
}
