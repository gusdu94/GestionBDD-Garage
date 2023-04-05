import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private Connection connection;

    public Database(String url, String database, String user, String password) throws SQLException {

        try {
            this.connection = DriverManager.getConnection(url+database, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}