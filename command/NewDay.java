package command;

import java.io.IOException;

public class NewDay implements Action{

    private Command command;

    public NewDay (Command command) {
        this.command = command;
    }

    @Override
    public void performAction() throws IOException, ClassNotFoundException {
        command.NewDay();
    }
    
}
