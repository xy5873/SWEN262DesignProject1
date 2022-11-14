package command;

public class Previous implements Action{
    
    private Command command;

    public Previous(Command command){
        this.command = command;
    }

    @Override
    public void performAction(){
        command.previous();
    }

}
