import java.lang.annotation.Annotation;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.lang.reflect.*;
import java.util.Map;

public class Lesson9Main {

    private static Statement statement;
    private static Connection connection;
    public static void main(String[] args) {
        try {
            connect();
            createTable(Game.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void createTable(Class myClass) throws SQLException {
        Map<Class, String> sqlClasses = new HashMap<>();
        sqlClasses.put(String.class, "TEXT");
        sqlClasses.put(int.class, "INTEGER");
        sqlClasses.put(GameType.class, "TEXT");


        if (!myClass.isAnnotationPresent(Table.class)) {
            throw new RuntimeException("No table found");
        }
        StringBuilder request = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        request.append(((Table) myClass.getAnnotation(Table.class)).title() + " (");
        Field[] fields = Game.class.getDeclaredFields();
        for(Field o: fields) {
            if(o.isAnnotationPresent(Column.class)) {
                request.append(o.getName())
                        .append(" ")
                        .append(sqlClasses.get(o.getType()))
                        .append(", ");
            }
        }
        request.setLength(request.length() - 2);
        request.append(");");
        System.out.println(request);
        statement.executeUpdate(request.toString());
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
