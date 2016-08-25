/**
 * Created by Zver on 07.08.2016.
 */
public class Game {
    Board board;
    public Game(){
        board = new Board();
    }

    public void draw(){
        board.show();
    }

    public void update(String value){
        board.parseCoordinates(value);
        board.recalculate();
    }

    public void whoseTurn(){
        System.out.println("ходит игрок Х");
    }
}
