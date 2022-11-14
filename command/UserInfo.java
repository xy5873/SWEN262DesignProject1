package command;

import java.io.IOException;

public class UserInfo implements Action{

    private Command command;

    public UserInfo (Command command) {
        this.command = command;
    }

    @Override
    public void performAction() throws IOException, ClassNotFoundException {
        command.userInfo();
    }
    
}
