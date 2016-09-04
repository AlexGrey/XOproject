/**
 * Created by Zver on 25.08.2016.
 */
public class Player {
    private Board.Cell type;
    private String title;

    public Player(Board.Cell type) {
        this.type = type;
        if (type.equals(Board.Cell.X)) this.title = "X";
        if (type.equals(Board.Cell.O)) this.title = "O";
    }

    public Board.Cell getType(){
        return this.type;
    }

    public String getTitle() {
        return title;
    }
}
