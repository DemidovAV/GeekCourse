@Table(title = "Games")

public class Game {
    @Column
    int id;

    @Column
    String gameName;

    @Column
    GameType type;

    public Game(int id, String gameName, GameType type) {
        this.id = id;
        this.gameName = gameName;
        this.type = type;
    }
}
