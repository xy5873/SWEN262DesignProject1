package command;

import java.io.IOException;

public class Password implements Action{
    
    private Command command;

    public Password(Command command){
        this.command = command;
    }

    @Override
    public void performAction() throws IOException, ClassNotFoundException{
        command.changePassword();
    }
}
