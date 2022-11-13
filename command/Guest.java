package command;

public class Guest implements Action{
    
    private Command command;

    public Guest(Command command){
        this.command = command; 
    }

    @Override
    public void performAction(){
        command.guestMode();
    }
    
}
