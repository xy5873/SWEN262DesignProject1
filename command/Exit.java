package command;

public class Exit implements Action{

    private Command command;

    public Exit (Command command) {
        this.command = command;
    }
    
    @Override
    public void performAction() {
        command.exit();
    }
    
}
