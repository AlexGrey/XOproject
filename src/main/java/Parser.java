import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zver on 03.09.2016.
 */
public class Parser {
    private StateManager stateManager;

    public Parser(StateManager stateManager){
        this.stateManager = stateManager;
    }

    public Cmd parse(String string){
        Cmd command = null;

        if (stateManager.getState() == StateManager.State.PREGAME){
            if (string.equals("start")){
                command = new StatusCmd("start", "ok");
            }
            else if (string.equals("exit")){
                command = new StatusCmd("exit", "ok");
            } else {
                command = new StatusCmd("error", "ok");
            }
        }

        if (stateManager.getState() == StateManager.State.GAME){
            if (matches(string)){
                command = new CoordCmd("coords", string);
            }
            else if (string.equals("exit")){
                command = new StatusCmd("exit", "ok");
            } else {
                command = new StatusCmd("error", "ok");
            }
        }

        if (stateManager.getState() == StateManager.State.ENDGAME){
            if (string.equals("Y")){
                command = new StatusCmd("start", "ok");
            }
            else if (string.equals("N")){
                command = new StatusCmd("exit", "ok");
            } else {
                command = new StatusCmd("error", "ok");
            }
        }
        return command;
    }

    private boolean matches(String string){
        Pattern p = Pattern.compile("[0-2] [0-2]");
        Matcher m = p.matcher(string);
        return m.matches();
    }
}
