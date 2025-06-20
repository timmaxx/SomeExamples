package timmax.patterns.command.gpp.Command.p01;

public class FireCommand implements Command {
    private ObjectOfExecution objectOfExecution;

    @Override
    public void execute() {
        objectOfExecution.fireGun();
    }
}
