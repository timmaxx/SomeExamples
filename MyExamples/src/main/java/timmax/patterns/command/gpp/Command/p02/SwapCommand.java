package timmax.patterns.command.gpp.Command.p02;

public class SwapCommand implements Command {
    @Override
    public void execute(GameActor gameActor) {
        gameActor.swapWeapon();
    }
}
