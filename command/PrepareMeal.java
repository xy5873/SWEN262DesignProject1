package command;

import java.io.IOException;

public class PrepareMeal implements Action{

    private Command command;

    public PrepareMeal (Command command) {
        this.command = command;
    }
    
    @Override
    public void performAction() throws IOException, ClassNotFoundException {
        command.prepareMeal();
    }
    
}
