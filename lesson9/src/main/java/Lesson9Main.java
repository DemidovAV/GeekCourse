import java.lang.annotation.Annotation;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;

public class Lesson9Main {

    private static Statement statement;
    private static Connection connection;
    public static void main(String[] args) {
        Class<MyClass> myClass = MyClass.class;
        Annotation[] myClassAnno = myClass.getAnnotations();

    }

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Can't connect");
        }
    }
    public static void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
