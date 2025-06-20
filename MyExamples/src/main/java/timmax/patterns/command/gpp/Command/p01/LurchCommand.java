package timmax.patterns.command.gpp.Command.p01;

public class LurchCommand implements Command {
    private ObjectOfExecution objectOfExecution;

    @Override
    public void execute() {
        objectOfExecution.lurchIneffectively();
    }
}
