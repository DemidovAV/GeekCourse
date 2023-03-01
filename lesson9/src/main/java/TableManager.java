import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TableManager {
    public void addGame(Game game) throws SQLException {
        Main.preparedStatement = Main.connection.prepareStatement("INSERT INTO Games (id, gameName, type, PG) VALUES (?, ?, ?, ?);");
        Main.preparedStatement.setObject(1, game.id);
        Main.preparedStatement.setObject(2, game.gameName);
        Main.preparedStatement.setObject(3, game.type);
        Main.preparedStatement.setObject(4, game.PG);
        Main.preparedStatement.executeUpdate();
    }
    public void createTable(Class myClass) throws SQLException {
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
        Main.statement.executeUpdate(request.toString());
    }
}
