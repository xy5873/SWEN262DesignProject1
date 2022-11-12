package command;

import java.io.IOException;

public class Meal implements Action{

    private Command command;

    public Meal (Command command) {
        this.command = command;
    }
    
    @Override
    public void performAction() throws IOException {
        command.meal();
    }
    
}
