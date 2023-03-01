import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {


    public void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            Main.connection = DriverManager.getConnection("jdbc:sqlite:myDB.db");
            Main.statement = Main.connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Can't connect");
        }
    }
    public void disconnect() {
        try {
            Main.statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Main.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
