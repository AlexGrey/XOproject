/**
 * Created by Zver on 07.08.2016.
 */

public class Board {

    enum Cell{
        X, O, EMPTY
    }

    private int x, y;
    private final String emptyChar = "#";
    private final String xChar = "X";
    private final String oChar = "O";
    private Cell[][] map = new Cell[3][3];


    public Board(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Cell.EMPTY;
            }
        }
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getEmptyChar() {
        return this.emptyChar;
    }

    public String getxChar() {
        return this.xChar;
    }

    public String getoChar() {
        return this.oChar;
    }

    public void parseCoordinates(String s){
            int first = Integer.parseInt(s.substring(0, 1));
            int second = Integer.parseInt(s.substring(2));
            System.out.println(first + " - число, " + second + " - число");
            setX(first);
            setY(second);
    }

    public void recalculate(){
        map[x][y] = Cell.O;
    }

    public void show(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == Cell.EMPTY){
                    System.out.print(getEmptyChar());
                }
                if (map[i][j] == Cell.O){
                    System.out.print(getoChar());
                }
            }
            System.out.println("");
        }
    }
}
