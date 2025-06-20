package timmax.patterns.command.gpp.Command.p02;

public class JumpCommand implements Command {
    @Override
    public void execute(GameActor gameActor) {
        gameActor.jump();
    }
}
