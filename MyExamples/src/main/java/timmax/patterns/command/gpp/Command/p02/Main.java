package timmax.patterns.command.gpp.Command.p02;

public class Main {
    public static void main(String[] args) {
        GameActor player = new GameActor();
        System.out.println("player = " + player);
        InputHandler inputHandler = new InputHandler('A');
        System.out.println("inputHandler = " + inputHandler);
        Command command = inputHandler.handleInput();
        System.out.println("command = " + command);
        if (command != null) {
            command.execute(player);
        }
    }
}
