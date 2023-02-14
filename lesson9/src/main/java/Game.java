@Table(title = "Games")

public class Game {
    @Column
    int id;

    @Column
    String gameName;

    @Column
    GameType type;

    @Column
    int PG;

    public Game(int id, String gameName, GameType type, int PG) {
        this.id = id;
        this.gameName = gameName;
        this.type = type;
        this.PG = PG;
    }
}
