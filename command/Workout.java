package command;

import java.io.IOException;

public class Workout implements Action{

    private Command command;

    public Workout (Command command) {
        this.command = command;
    }
    
    @Override
    public void performAction() throws IOException, ClassNotFoundException {
        command.workout();
    }
    
}
