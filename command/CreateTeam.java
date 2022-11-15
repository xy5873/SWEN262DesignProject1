package command;

import java.io.IOException;

public class CreateTeam implements Action{
    
    private Command command;

    public CreateTeam(Command command){
        this.command = command;
    }


    @Override
    public void performAction() throws IOException{
        command.createTeam();
    }

}
