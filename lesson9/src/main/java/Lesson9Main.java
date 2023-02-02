import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
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

    public static void addGame(Game game) throws SQLException {
        StringBuilder request = new StringBuilder("INSERT INTO ");
        request.append(game.getClass().getAnnotation(Table.class).title() + " (");
    }
    public static void createTable(Class myClass) throws SQLException {
        Map<Class, String> sqlClasses = new HashMap<>();
        sqlClasses.put(String.class, "TEXT");
        sqlClasses.put(int.class, "INTEGER");
        sqlClasses.put(GameType.class, "TEXT");


        if (!myClass.isAnnotationPresent(Table.class)) {
            throw new RuntimeException("No table found");
        }
        StringBuilder request = new StringBuilder("CREATE TABLE ");
        request.append(((Table) myClass.getAnnotation(Table.class)).title() + " (");
        Field[] fields = Game.class.getDeclaredFields();
        for(int i = 0; i < fields.length; i++) {
            if(fields[i].isAnnotationPresent(Column.class)) {
                request.append(fields[i].getName())
                        .append(" ")
                        .append(sqlClasses.get(fields[i].getType()))
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
            connection = DriverManager.getConnection("jdbc:sqlite:myDB.db");
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
