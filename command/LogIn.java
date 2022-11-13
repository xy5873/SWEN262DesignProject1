package command;

import java.io.IOException;

public class LogIn implements Action{

    private Command command;

    public LogIn (Command command) {
        this.command = command;
    }
    
    @Override
    public void performAction() throws IOException, ClassNotFoundException {
        command.logIn();
    }
    
}
