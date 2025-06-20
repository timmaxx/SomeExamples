package timmax.patterns.command.gpp.Command.p01;

public class JumpCommand implements Command {
    private ObjectOfExecution objectOfExecution;

    @Override
    public void execute() {
        objectOfExecution.jump();
    }
}
