package command;

import java.io.IOException;

public class Create implements Action{
    
    private Command command;

    public Create(Command command){
        this.command = command;
    }

    @Override
    public void performAction() throws IOException, ClassNotFoundException{
        command.create();
    }

}
