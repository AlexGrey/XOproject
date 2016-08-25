import java.util.Scanner;

/**
 * Created by Zver on 07.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CommandListener listener = new CommandListener();

        System.out.println("welcome to the tic tac toe!");
        System.out.println("наберите \"start\" чтобы начать");

        while (true){
            String msg = in.nextLine();
            if (msg.equals("exit")) listener.execute(CommandListener.Command.EXIT, "ok");
            if (listener.isExit()) break;
            if (msg.equals("start")) listener.execute(CommandListener.Command.START, "ok");
            else listener.execute(CommandListener.Command.COORD, msg);
        }
    }
}
