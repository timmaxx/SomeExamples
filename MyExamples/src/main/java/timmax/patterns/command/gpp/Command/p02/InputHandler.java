package timmax.patterns.command.gpp.Command.p02;

public class InputHandler {
    private final char button;
    private final Command buttonX = new JumpCommand();
    private final Command buttonY = new FireCommand();
    private final Command buttonA = new SwapCommand();
    private final Command buttonB = new LurchCommand();

    public InputHandler(char button) {
        this.button = button;
    }

    public Command handleInput() {
        if (button == 'X') {
            return buttonX;
        } else if (button == 'Y') {
            return buttonY;
        } else if (button == 'A') {
            return buttonA;
        } else if (button == 'B') {
            return buttonB;
        }

        return null;
    }
}
