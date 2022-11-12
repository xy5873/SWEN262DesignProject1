package command;

import java.io.IOException;

public class History implements Action{

    private Command command;

    public History (Command command) {
        this.command = command;
    }
    
    @Override
    public void performAction() throws IOException {
        command.history();
    }
    
}
