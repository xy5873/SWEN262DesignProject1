package command;

import java.io.IOException;

public class Recipe implements Action{

    private Command command;

    public Recipe (Command command) {
        this.command = command;
    }
    
    @Override
    public void performAction() throws IOException, ClassNotFoundException {
        command.recipe();
    }
    
}
