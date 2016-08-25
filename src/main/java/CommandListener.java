/**
 * Created by Zver on 07.08.2016.
 */
public class CommandListener {
    Game game;
    private boolean exit = false;

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public enum Command {
        /**
         * начинаем игру
         */
        START,
        /**
         * выходим из игры
         */
        EXIT,
        /**
         * получаем координаты в которые хочет походить игрок
         * <p>
         * Note: в случае если координаты не число, выводим сообщение об ошибке
         * </p>
         */
        COORD
    }
    Board board;

    public void execute(Command cmd, String value){
        switch (cmd){
            case START:
                System.out.println("игра начата!");
                game = new Game();
                game.whoseTurn();
                game.draw();
                break;
            case EXIT:
                System.out.println("игра закончена!");
                this.setExit(true);
                break;
            case COORD:
                try {
                    game.update(value);
                }catch (Exception e){
                    System.out.println("неверный формат!");
                }
                game.whoseTurn();
                game.draw();
                break;
            default: break;
        }

    }
}
