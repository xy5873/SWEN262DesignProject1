package command;

public class UserMode implements Action{
    
    private Command command;

    public UserMode(Command command){
        this.command = command;
    }

    @Override
    public void performAction(){
        command.userMode();
    }

}
