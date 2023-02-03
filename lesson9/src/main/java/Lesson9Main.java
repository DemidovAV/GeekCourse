import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.lang.reflect.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lesson9Main {

    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static Connection connection;
    public static void main(String[] args) {
        Game witcher = new Game(1, "Witcher", GameType.SINGLE, 16);
        Game wow = new Game(2, "World of Warcraft", GameType.MULTIPLAYER, 12);
        try {
            connect();
            createTable(Game.class);
            addGame(witcher);
            addGame(wow);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void addGame(Game game) throws SQLException {
            preparedStatement = connection.prepareStatement("INSERT INTO Games (id, gameName, type, PG) VALUES (?, ?, ?, ?);");
            preparedStatement.setObject(1, game.id);
            preparedStatement.setObject(2, game.gameName);
            preparedStatement.setObject(3, game.type);
            preparedStatement.setObject(4, game.PG);
            preparedStatement.executeUpdate();
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
