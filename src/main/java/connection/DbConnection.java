package connection;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DbConnection {

    public static Connection getConnection() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/ecommerceDB");
            return ds.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalStateException("exception happened while connection to DB connection");
        }
    }
}
