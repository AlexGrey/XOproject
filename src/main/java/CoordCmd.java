/**
 * Created by Zver on 04.09.2016.
 */
public class CoordCmd extends Cmd {
    public CoordCmd(String name, String value) {
        super(name, value);
    }

    void execute(Game game) {
        game.getBoard().parseCoordinates(this.value);
        if (game.getBoard().getMap()[game.getBoard().getX()][game.getBoard().getY()] == Board.Cell.EMPTY){
            game.getBoard().recalculate(game.getCurrentPlayer().getType());
            game.checkWinner();
            game.turn--;
            if (game.turn == 0){
                game.draw();
                System.out.println("партия окончена. Ничья!");
                System.out.println("хотите начать заново? Y/N");
                game.getStateManager().setState(StateManager.State.ENDGAME);
            } else {
                game.swapActivePlayer();
                game.setCurrentPlayer(game.players.get(0));
                String winner = game.getWinner();
                if (winner.equals("none")){
                    game.whoseTurn();
                    game.draw();
                } else {
                    game.draw();
                    System.out.println("партия окончена. Победил: " + winner);
                    System.out.println("хотите начать заново? Y/N");
                    game.getStateManager().setState(StateManager.State.ENDGAME);
                }
            }
        } else {
            System.out.println("ячейка " + game.getBoard().getX() + ":" + game.getBoard().getY() + " не пустая");
            game.whoseTurn();
            game.draw();
        }

    }
}
