package command;

import java.io.IOException;

public class LogOut implements Action{

    private Command command;

    public LogOut (Command command) {
        this.command = command;
    }
    
    @Override
    public void performAction() throws IOException, ClassNotFoundException {
        command.logOut();
    }
    
}
