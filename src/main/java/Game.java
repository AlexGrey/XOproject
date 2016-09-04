import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zver on 07.08.2016.
 */
public class Game {
    Scanner in;
    StateManager stateManager;
    Parser parser;
    Board board;
    List<Player> players = new ArrayList<Player>();
    Player currentPlayer;
    String winner = "none";
    /**
     * количество ходов до окончания. Если нет победителя объявляется ничья
     */
    int turn = 9;

    boolean exitGame = false;

    public void startSession(){
        board = new Board();
        players.add(new Player(Board.Cell.X));
        players.add(new Player(Board.Cell.O));
        setCurrentPlayer(players.get(0));
    }

    public Board getBoard() {
        return board;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public void setStateManager(StateManager.State stateManager) {
        this.stateManager.setState(stateManager);
    }

    public void run(){
        in = new Scanner(System.in);
        stateManager = new StateManager();
        stateManager.setState(StateManager.State.PREGAME);
        parser = new Parser(stateManager);

        System.out.println("welcome to the tic tac toe!");
        System.out.println("наберите \"start\" чтобы начать");

        while (!exitGame){
            String msg = in.nextLine();
            Cmd cmd = parser.parse(msg);
            cmd.execute(this);
        }
    }

    public void draw(){
        board.show();
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getTurn() {
        return turn;
    }

    public void checkWinner(){
        for (int i = 0; i < 3; i++){
            if (board.getMap()[i][i] == Board.Cell.EMPTY) continue;
            if (    board.getMap()[i][0] == board.getMap()[i][1] &&
                    board.getMap()[i][1] == board.getMap()[i][2]){
                this.setWinner(board.getMap()[i][i].toString());
            }
        }

        for (int i = 0; i < 3; i++){
            if (board.getMap()[i][i] == Board.Cell.EMPTY) continue;
            if (    board.getMap()[0][i] == board.getMap()[1][i] &&
                    board.getMap()[1][i] == board.getMap()[2][i]){
                this.setWinner(board.getMap()[i][i].toString());
            }
        }

        if (board.getMap()[0][0] != Board.Cell.EMPTY){
            if (    board.getMap()[0][0] == board.getMap()[1][1]&&
                    board.getMap()[1][1] == board.getMap()[2][2]){
                this.setWinner(board.getMap()[0][0].toString());
            }
        }

        if (board.getMap()[0][2] != Board.Cell.EMPTY){
            if (    board.getMap()[0][2] == board.getMap()[1][1]&&
                    board.getMap()[1][1] == board.getMap()[2][0]){
                this.setWinner(board.getMap()[0][2].toString());
            }
        }
    }

    public void swapActivePlayer(){
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        players.set(0, player2);
        players.set(1, player1);
    }

    Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    void setCurrentPlayer(Player player){
        currentPlayer = player;
    }

    public void whoseTurn(){
        System.out.println("ходит игрок " + getCurrentPlayer().getTitle());
    }
}
