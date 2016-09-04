/**
 * Created by Zver on 03.09.2016.
 */
public class StateManager {
    enum State{
        PREGAME,
        GAME,
        ENDGAME
    }

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
