package timmax.patterns.command.gpp.Command.p01;

public class SwapCommand implements Command {
    private ObjectOfExecution objectOfExecution;

    @Override
    public void execute() {
        objectOfExecution.swapWeapon();
    }
}
