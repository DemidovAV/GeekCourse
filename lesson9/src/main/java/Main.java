import java.sql.*;

public class Main {
    public static Statement statement;
    public static Connection connection;
    public static PreparedStatement preparedStatement;


    public static void main(String[] args) {
        Game witcher = new Game(1, "Witcher", GameType.SINGLE, 16);
        Game wow = new Game(2, "World of Warcraft", GameType.MULTIPLAYER, 12);
        ConnectionManager cm = new ConnectionManager();
        TableManager tm = new TableManager();
        try {
            cm.connect();
            tm.createTable(Game.class);
            tm.addGame(witcher);
            tm.addGame(wow);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cm.disconnect();
        }
    }

}
