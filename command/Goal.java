package command;

import java.io.IOException;

public class Goal implements Action{

    private Command command;

    public Goal (Command command) {
        this.command = command;
    }
    
    @Override
    public void performAction() throws IOException {
        command.goal();
    }
    
}
