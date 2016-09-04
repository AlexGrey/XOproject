/**
 * Created by Zver on 04.09.2016.
 */
public abstract class Cmd {
    String name;
    String value;

    public Cmd(String name, String value) {
        this.name = name;
        this.value = value;
    }

    abstract void execute(Game game);
}
