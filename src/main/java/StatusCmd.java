/**
 * Created by Zver on 04.09.2016.
 */
public class StatusCmd extends Cmd {

    public StatusCmd(String name, String value) {
        super(name, value);
    }

    public void execute(Game game) {
        if (this.name.equals("start")){
            System.out.println("игра начата!");
            game.setStateManager(StateManager.State.GAME);
            game.startSession();
            game.whoseTurn();
            game.draw();
        } else if (this.name.equals("exit")){
            System.out.println("игра окончена!");
            game.exitGame = true;
        }else{
            System.out.println("ошибка ввода!");
            if (game.getStateManager().getState() == StateManager.State.GAME){
                game.whoseTurn();
                game.draw();
            }
        }
    }
}
