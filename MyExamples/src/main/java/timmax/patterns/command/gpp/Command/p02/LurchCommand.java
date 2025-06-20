package timmax.patterns.command.gpp.Command.p02;

public class LurchCommand implements Command {
    @Override
    public void execute(GameActor gameActor) {
        gameActor.lurchIneffectively();
    }
}
