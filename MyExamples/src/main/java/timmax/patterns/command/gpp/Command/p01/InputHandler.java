package timmax.patterns.command.gpp.Command.p01;

public class InputHandler {
    private Command buttonX;
    private Command buttonY;
    private Command buttonA;
    private Command buttonB;

    public void handleInput(char button) {
        if (button == 'X') {
            buttonX.execute();
        } else if (button == 'Y') {
            buttonY.execute();
        } else if (button == 'A') {
            buttonA.execute();
        } else if (button == 'B') {
            buttonB.execute();
        }
    }
}
