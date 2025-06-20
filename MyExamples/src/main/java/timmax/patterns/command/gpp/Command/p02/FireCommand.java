package timmax.patterns.command.gpp.Command.p02;

public class FireCommand implements Command {
    @Override
    public void execute(GameActor gameActor) {
        gameActor.fireGun();
    }
}
